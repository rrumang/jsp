package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Before;
import org.junit.Test;

public class ProdDaoTest {
	
	IprodDao dao;
	
	@Before
	public void setup(){
		dao = new ProdDao();
	}

	@Test
	public void prodListtest() {
		/***Given***/
		String prod_lgu = "P201";

		/***When***/
		List<ProdVo> prodList = dao.prodList(prod_lgu);

		/***Then***/
		assertNotNull(prodList);
		assertEquals(21, prodList.size());

	}

}
