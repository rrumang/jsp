package kr.or.ddit.db.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

import org.junit.Before;
import org.junit.Test;

public class DbDaoTest {
	IdbDao dao;
	@Before
	public void setup(){
		dao = new DbDao();
	}

	@Test
	public void DbDaotest() {
		/***Given***/
		/***When***/
		List<DbVo>dbList = dao.dbList();

		/***Then***/
		assertNotNull(dbList);
		assertEquals("/main.do", dbList.get(0).getUri());

	}

}
