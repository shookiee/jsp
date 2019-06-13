package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

public interface IProdDao {

	List<ProdVO> prodList(String prod_lgu);

}
