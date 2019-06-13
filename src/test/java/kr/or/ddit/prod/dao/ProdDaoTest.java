package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

import org.junit.Before;
import org.junit.Test;

public class ProdDaoTest {
	IProdDao prodDao;
	
	@Before
	public void setup(){
		prodDao = new ProdDaoImpl();
	}
	
	@Test
	public void prodListTest() {
		/***Given***/
		String prod_lgu = "P101";

		/***When***/
		List<ProdVO> prodList = prodDao.prodList(prod_lgu);
		
		/***Then***/
		assertEquals(6, prodList.size());

	}

}
