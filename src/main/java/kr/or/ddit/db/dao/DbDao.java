package kr.or.ddit.db.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDao implements IDbDao {

	@Override
	public List<DbVO> uriList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVO> uriList = sqlSession.selectList("uri.uriList");
		sqlSession.close();
		
		return uriList;
	}

	@Override
	public String getClassName(String uri) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		String className = sqlSession.selectOne("uri.getClassName", uri);
		sqlSession.close();
		
		return className;
	}

}
