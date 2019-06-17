package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

public interface IDbService {
	List<DbVO> uriList();
	
	String getClassName(String uri);
}
