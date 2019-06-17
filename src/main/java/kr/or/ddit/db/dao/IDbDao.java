package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVO;

public interface IDbDao {
	List<DbVO> uriList();
	
	String getClassName(String uri);
}
