package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
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

}
