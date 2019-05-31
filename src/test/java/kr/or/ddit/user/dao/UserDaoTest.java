package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {

	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);

	private IUserDao userDao = new UserDao();

	// JUNIT 실행 순서
	// @BeforeClass가 적용된 메서드가 1회 실행

	// 다음 구간은 @Test가 적용된 모든 메서드에 대해 반복 적용
	// @Before가 적용된 메서드 실행
	// @Test가 적용된 메서드 실행
	// @After가 적용된 메서드 실행

	// @AfterClass가 적용된 메서드가 1회 실행

	@BeforeClass
	// static이 붙어야 함
	public static void beforeClass() {
		logger.debug("beforeClass");
	}

	@Before
	// static이 붙지않고 보통 setup을 붙임
	public void setup() {
		userDao = new UserDao();
		logger.debug("setup");
	}

	@After
	// 보통 teardown이라고 명명
	public void teardown() {
		logger.debug("teardown");
	}

	@AfterClass
	public static void afterClass() {
		logger.debug("afterClass");
	}

	/**
	 * Method : userListTest 작성자 : PC23 변경이력 : Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		/*** Given ***/

		/*** When ***/
		List<UserVO> userList = userDao.userList();

		/*** Then ***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("userList : {}", userList);
	}

	@Test
	// 반환 타입은 무조건 void, 매개변수는 없어야함
	public void getUserTest() {
		/*** Given ***/
		String userId = "brown";

		/*** When ***/
		UserVO userInfo = userDao.getUser(userId);

		/*** Then ***/
		assertEquals("브라운", userInfo.getName());
		logger.debug("userInfo : {}", userInfo);

	}

	// 사용자 페이징 리스트 조회
	// 고려사항
	// 몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여 줄 것인지 : 쿼리 실행 파라미터와 관련
	// 정렬순서? : 로직 관련 --> 파라미터화 시킬 수 있음
	/**
	 * 
	 * Method : userPagingListTest 작성자 : PC23 변경이력 : Method 설명 : 사용자 페이징 리스트 조회
	 * 테스트
	 */
	@Test
	public void userPagingListTest() {
		/*** Given ***/
		PageVO pageVO = new PageVO(1, 10);

		/*** When ***/
		List<UserVO> userList = userDao.userPagingList(pageVO);

		/*** Then ***/
		assertNotNull(userList);
		assertEquals(10, userList.size());

	}

	/**
	 * 
	 * Method : usersCntTest 작성자 : PC23 변경이력 : Method 설명 : 사용자 전체 수 조회 테스트
	 */
	@Test
	public void usersCntTest() {
		/*** Given ***/

		/*** When ***/
		int usersCnt = userDao.usersCnt();

		/*** Then ***/
		assertEquals(105, usersCnt);
	}

	/**
	 * Method : insertUserTest 작성자 : PC23 변경이력 : Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() {
		/*** Given ***/
		// 사용자 정보를 담고 있는 vo 객체 준비
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVo = null;
		try {
			userVo = new UserVO("tes", "shookie913", "tes", "shookie1234",
					"대전광역시 중구 중앙로 76", "영민빌딩 2층 204호", "34940",
					sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}

		/*** When ***/
		// userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);

		/*** Then ***/
		// insertCnt(1)
		assertEquals(1, insertCnt);
		userDao.deleteUser(userVo.getUserId());

	}

	
	
	@Test
	public void deleteUserTest(){
		/***Given***/
		String userId = "shooadf3";

		/***When***/
		int deleteCnt = userDao.deleteUser(userId);
		
		/***Then***/
		assertEquals(1, deleteCnt);
	}
	
	
	@Test
	public void updateUserTest(){
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVO userVo = null;
		
		try {
			userVo = new UserVO("수정쓰", "user13", "수정별명", "1234123", "대전광역시 중구 중앙로 76", "영민빌딩 2층 204호", "34940", sdf.parse("2019-05-31"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		/***When***/
		int updateCnt = userDao.updateUser(userVo);
				
		/***Then***/
		assertEquals(1, updateCnt);
	}
}
