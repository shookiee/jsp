package kr.or.ddit.db.service;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IDbDao;
import kr.or.ddit.db.model.DbVO;

public class DbService implements IDbService {
	private IDbDao dbDao = new DbDao(); 
	
	@Override
	public List<DbVO> uriList() {
		return dbDao.uriList();
	}

	@Override
	public String getClassName(String uri) {
		return dbDao.getClassName(uri);
	}
	
}
