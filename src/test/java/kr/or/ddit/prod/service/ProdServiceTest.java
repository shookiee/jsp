package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;

public class ProdServiceTest {
	IProdService prodService;
	
	@Before
	public void setup(){
		prodService = new ProdServiceImpl();
	}
	
	@Test
	public void prodListTest() {
		/***Given***/
		String prod_lgu = "P101";

		/***When***/
		List<ProdVO> prodList = prodService.prodList(prod_lgu);
		
		/***Then***/
		assertEquals("모니터 삼성전자15인치칼라", prodList.get(0).getProd_name());
	}

}
