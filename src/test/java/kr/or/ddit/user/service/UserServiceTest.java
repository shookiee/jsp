package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);
	
	private IUserService userService = new UserService();
	
	
	@Before
	public void setup() {
		userService = new UserService();
		logger.debug("setup");
	}
	
	@Test
	public void userListTest() {
		/***Given***/
		
		/***When***/
		List<UserVO> userList = userService.userList();
		
		/***Then***/
		assertEquals(105,	userList.size());
		assertEquals("cony", userList.get(1).getUserId());
		logger.debug("userList : {}", userList);
	}
	
	
	
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "sally";
		
		/***When***/
		UserVO userInfo = userService.getUser(userId);

		/***Then***/
		assertEquals("병아리", userInfo.getAlias());
		logger.debug("userInfo : {}", userInfo);

	}

}
