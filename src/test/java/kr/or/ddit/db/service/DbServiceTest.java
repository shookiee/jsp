package kr.or.ddit.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVO;

import org.junit.Before;
import org.junit.Test;

public class DbServiceTest {
	IDbService dbService;
	
	@Before
	public void setup(){
		dbService = new DbService();
	}
	
	@Test
	public void uriListTest() {
		/***Given***/

		/***When***/
		List<DbVO> uriList = dbService.uriList();
		
		/***Then***/
		assertEquals(2, uriList.size());
		assertEquals("/main.do", uriList.get(0).getUri());
	}
	
	@Test
	public void getClassName(){
		/***Given***/
		String uri = "/main.do";

		/***When***/
		String className = dbService.getClassName(uri);
		
		/***Then***/
		assertEquals("kr.or.ddit.controller.MainController", className);
	}

}
