package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVO;

public class ProdServiceImpl implements IProdService {
	private static IProdService service;
	private IProdDao prodDao = new ProdDaoImpl();
	
	@Override
	public List<ProdVO> prodList(String prod_lgu) {
		return prodDao.prodList(prod_lgu);
	}
	
	
}
