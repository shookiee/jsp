package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;


public class LprodServiceImpl implements ILprodService{

	private static ILprodService service;
	private ILprodDao lprodDao = new LprodDaoImpl();

	
	
	@Override
	public List<LprodVO> lprodList() {
		return lprodDao.lprodList();
	}
	
	@Override
	public Map<String, Object> lprodPagingList(PageVO pageVO) {
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		resultMap.put("lprodList", lprodDao.lprodPaginglist(pageVO));
		
		int lprodCnt = lprodDao.lprodCnt();
		int paginationSize = (int)Math.ceil((double)lprodCnt/pageVO.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	

}
