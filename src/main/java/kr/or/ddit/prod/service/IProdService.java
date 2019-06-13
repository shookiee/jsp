package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.model.ProdVO;

public interface IProdService {
	List<ProdVO>prodList(String prod_lgu);
}
