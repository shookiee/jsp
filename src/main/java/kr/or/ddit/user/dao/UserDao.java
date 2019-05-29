package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IUserDao {

	private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

	private static IUserDao dao;

	public static IUserDao getInstance() {
		if (dao == null)
			dao = new UserDao();
		return dao;
	}

	public static void main(String[] args) {

		/*** Given ***/
		IUserDao userDao = new UserDao();

		/*** When ***/
		List<UserVO> userList = userDao.userList();

		/*** Then ***/
		logger.debug("userList : {}", userList);

		/*** Given ***/
		String userId = "sally";

		/*** When ***/
		UserVO userInfo = userDao.getUser(userId);

		/*** Then ***/
		logger.debug("userInfo : {}", userInfo);

	}

	/**
	 * Method : userList 작성자 : PC23 변경이력 :
	 * 
	 * @return Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		sqlSession.close();
		
		return userList;
	}

	/**
	 * 
	 * Method : getUser 작성자 : PC23 변경이력 :
	 * 
	 * @param userId
	 * @return Method 설명 : 특정 사용자 조회
	 */
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO userInfo = sqlSession.selectOne("user.getUser", userId);
		sqlSession.close();

		return userInfo;
	}

	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC23
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public List<UserVO> userPagingList(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userPagingList", pageVO);
		sqlSession.close();
		return userList;
	}

	
	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체수 조회
	 */
	@Override
	public int usersCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		int usersCnt = (Integer)sqlSession.selectOne("user.usersCnt");
		sqlSession.close();
		
		return usersCnt;
	}

}
