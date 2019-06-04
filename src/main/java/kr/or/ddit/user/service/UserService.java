package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserService.class);
	
	private static IUserService service;
	private IUserDao userDao;
	
	public UserService() {
		userDao = UserDao.getInstance();
	}
	
	/**
	 * 
	 * Method : userList 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 :
	 */
	@Override
	public List<UserVO> userList() {
		return userDao.userList();
	}

	@Override
	public UserVO getUser(String userId) {
		return userDao.getUser(userId);
	}

	@Override
	public Map<String, Object> userPagingList(PageVO pageVO) {
		//1. List<UserVO>, userCnt를 필드로 하는 vo
		//2. List<Object> resultList = new ArrayList<Object>();
		// resultList.add(userList);
		// resultList.add(usersCnt);
		//3. Map<String, Object> resultMap = new HashMap<String, Object>();
		// resultMap.put("userList, userList);
		// resultMap.put("usersCnt", usersCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
				
		resultMap.put("userList", userDao.userPagingList(pageVO));
		
//		resultMap.put("usersCnt", userDao.usersCnt());
		//usersCnt --> paginationSize 변경
		int usersCnt = userDao.usersCnt();
		//pageSize --> pageVO.getPageSize();
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVO.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		
		return resultMap;
	}

	@Override
	public int insertUser(UserVO userVo) {
		return userDao.insertUser(userVo);
	}

	@Override
	public int deleteUser(String userId) {
		return userDao.deleteUser(userId);
	}

	@Override
	public int updateUser(UserVO userVo) {
		return userDao.updateUser(userVo);
	}
	
	/**
	* Method : encryptPassAllUser
	* 작성자 : PC23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 비밀번호 암호화 일괄 적용 배치
	* 			: 재적용 하지 말 것 !!!!!!
	*/
	@Override
	public int encryptPassAllUser() {
		// 사용하지 마세요 !_! 이미 암호화 적용되었습니다!!!!!!!!!!!!!!!!!!!!!!!!
		if(1==1)
			return 0;
		int updateCntSum = 0;
		
		// 0. sql 실행에 필요한 sqlSession 객체를 생성
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		// 1. 모든 사용자 정보 조회(단, 기존 암호화 적용 사용자 제외_brown, sally)
		List<UserVO> userList = userDao.userListForPassEncrypt(sqlSession);
		
		// 2. 조회된 사용자의 비밀번호를 암호화 적용 후 사용자 업데이트
		for(UserVO userVo : userList) {
			String encryptPass = KISA_SHA256.encrypt(userVo.getPass());
			userVo.setPass(encryptPass);
			
			int updateCnt = userDao.updateUserEncryptPass(sqlSession, userVo);
			updateCntSum += updateCnt;
			
			// 비정상
			if(updateCnt != 1) {
				sqlSession.rollback();
				break;
			} 
		}
		// 3. sqlSession 객체를 commit, close
		sqlSession.commit();
		sqlSession.close();
		
		return updateCntSum;
	}

	
	public static void main(String[] args) {
		IUserService userService = new UserService();
		int updateCnt = userService.encryptPassAllUser();
		logger.debug("updateCnt : {}", updateCnt);
	}
	

}
