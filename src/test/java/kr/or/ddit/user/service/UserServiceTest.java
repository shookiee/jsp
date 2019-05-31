package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVO;
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
		/*** Given ***/

		/*** When ***/
		List<UserVO> userList = userService.userList();

		/*** Then ***/
		assertEquals(105, userList.size());
		assertEquals("cony", userList.get(1).getUserId());
		logger.debug("userList : {}", userList);
	}

	@Test
	public void getUserTest() {
		/*** Given ***/
		String userId = "sally";

		/*** When ***/
		UserVO userInfo = userService.getUser(userId);

		/*** Then ***/
		assertEquals("병아리", userInfo.getAlias());
		logger.debug("userInfo : {}", userInfo);

	}

	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여 줄 것인지 : 쿼리 실행 파라미터와 관련
	// 정렬순서? : 로직 관련 --> 파라미터화 시킬 수 있음
	/**
	 * 
	 * Method : userPagingListTest 
	 * 작성자 : PC23 
	 * 변경이력 : Method 
	 * 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest() {
		/*** Given ***/
		PageVO pageVO = new PageVO(1, 10);

		/*** When ***/
		Map<String, Object> resultMap = userService.userPagingList(pageVO);
		List<UserVO> userList = (List<UserVO>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		/*** Then ***/
		// pagingList assert
		assertNotNull(userList);
		assertEquals(10, userList.size());

		// usersCnt assert
		assertEquals(11, paginationSize);
	}

	
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;
		
		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}", paginationSize);
		
		/***Then***/
		assertEquals(11, (int)paginationSize);
		
		
	}
	
	@Test
	public void insertUserTest(){
		/*** Given ***/
		// 사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVo = null;
		try {
			userVo = new UserVO("aadfdf", "shooadf3", "tes", "shookie1234",
					"대전광역시 중구 중앙로 76", "영민빌딩 2층 204호", "34940",
					sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/*** When ***/
		int insertCnt = userService.insertUser(userVo);

		/*** Then ***/
		assertEquals(1, insertCnt);
		userService.deleteUser(userVo.getUserId());
	}
	
	
	@Test
	public void deleteUserTest(){
		/***Given***/
		String userId = "userId";

		/***When***/
		int deleteCnt = userService.deleteUser(userId);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
}
