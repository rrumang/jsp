package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;

public class DbDao implements IdbDao {

	@Override
	public List<DbVo> dbList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<DbVo> dbList = sqlSession.selectList("db.dbList");
		return dbList;
	}

}
