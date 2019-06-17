package kr.or.ddit.db.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.db.dao.DbDao;
import kr.or.ddit.db.dao.IdbDao;
import kr.or.ddit.db.model.DbVo;

import org.junit.Before;
import org.junit.Test;

public class DbServiceTest {
	IdbService service;
	
	@Before
	public void setup(){
		service = new DbService();
	}

	@Test
	public void DbDaotest() {
		/***Given***/
		/***When***/
		List<DbVo>dbList = service.dbList();

		/***Then***/
		assertNotNull(dbList);
		assertEquals("/main.do", dbList.get(0).getUri());

	}


}
