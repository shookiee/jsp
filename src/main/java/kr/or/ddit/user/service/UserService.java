package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.dao.IUserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IUserService {
	
	
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

	

}
