package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbDaoTest {
	IDbDao dbDao;
	
	@Before
	public void setup(){
		dbDao = new DbDao();
	}
	
	@Test
	public void uriListTest() {
		/***Given***/

		/***When***/
		List<DbVO> uriList = dbDao.uriList();
		
		/***Then***/
		assertEquals(2, uriList.size());
		assertEquals("/main.do", uriList.get(0).getUri());
	}

	
	@Test
	public void getClassNameTest(){
		/***Given***/
		String uri = "/main.do";

		/***When***/
		String className = dbDao.getClassName(uri);
		
		/***Then***/
		assertEquals("kr.or.ddit.controller.MainController", className);

	}
	
	
}
