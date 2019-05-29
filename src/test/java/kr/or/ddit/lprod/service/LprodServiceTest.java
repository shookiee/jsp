package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

import org.junit.Before;
import org.junit.Test;

public class LprodServiceTest {

	
	private ILprodService lprodService;
	@Before
	public void setup(){
		lprodService = new LprodServiceImpl();
	}
	
	@Test
	public void test() {
		/***Given***/
		PageVO pageVo = new PageVO(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVO> lprodList = (List<LprodVO>) resultMap.get("lprodList");
		int paginationSize = (int) resultMap.get("paginationSize");
		/***Then***/
		
		assertNotNull(lprodList);
		assertEquals(5, lprodList.size());

		// usersCnt assert

	}

}
