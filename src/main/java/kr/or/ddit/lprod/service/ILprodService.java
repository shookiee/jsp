package kr.or.ddit.lprod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.paging.model.PageVO;

public interface ILprodService {
	List<LprodVO> lprodList();
	
	Map<String, Object> lprodPagingList(PageVO pageVO);

}
