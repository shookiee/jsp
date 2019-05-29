package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVO;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> lprodList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodList");
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<LprodVO> lprodPaginglist(PageVO pageVO) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVO> lprodList = sqlSession.selectList("lprod.lprodPagingList", pageVO);
		sqlSession.close();
		return lprodList;
				
	}

	@Override
	public int lprodCnt() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		
		int lprodCnt = (Integer)sqlSession.selectOne("lprod.lprodCnt");
		sqlSession.close();
		
		return lprodCnt;
	}



	
	
}
