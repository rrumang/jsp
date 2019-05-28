package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LprodDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(LprodDaoTest.class);
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IlprodDao lprodDao;
	
	@Before
	public void setup(){
		lprodDao = new LprodDao();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	@Test
	public void lprodList() {
		/***Given***/
		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodList();

		/***Then***/
		assertEquals("1", lprodList.get(0).getLprod_id());
		assertEquals(12, lprodList.size());
		
		logger.debug("lprodList : {}", lprodList);

	}
	
	@Test
	public void getIdTest(){
		/***Given***/
		String lprod_id = "1";

		/***When***/
		LprodVo lprodVo = lprodDao.getId(lprod_id);

		/***Then***/
		assertEquals("컴퓨터제품", lprodVo.getLprod_nm());

	}
	
	@Test
	public void lprodPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		List<LprodVo> lprodList = lprodDao.lprodPagingList(pageVo);

		/***Then***/
		assertNotNull(lprodList);
		assertEquals(10, lprodList.size());
		logger.debug("lprodList : {}", lprodList);

	}
	
	@Test
	public void lprodCntTest(){
		/***Given***/
		/***When***/
		int lprodCnt = lprodDao.lprodCnt();

		/***Then***/
		assertEquals(12, lprodCnt);

	}

}
