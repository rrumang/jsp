package kr.or.ddit.lprod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;

public class LprodDao implements IlprodDao {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDao.class);

	@Override
	public List<LprodVo> lprodList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodList");
		sqlSession.close();
		return lprodList;
	}

	@Override
	public LprodVo getId(String lprod_id) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		LprodVo vo = sqlSession.selectOne("lprod.getId", lprod_id);
		sqlSession.close();
		return vo;
	}

	@Override
	public List<LprodVo> lprodPagingList(PageVo pageVo) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<LprodVo> lprodList = sqlSession.selectList("lprod.lprodPagingList", pageVo);
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
