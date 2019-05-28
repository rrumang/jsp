package kr.or.ddit.lprod.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.lprod.dao.IlprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.paging.model.PageVo;

public class LprodService implements IlprodService {
	private IlprodDao dao;
	
	public LprodService() {
		dao = new LprodDao();
	}

	@Override
	public List<LprodVo> lprodList() {
		List<LprodVo> lprodList = new ArrayList<LprodVo>();
		lprodList = dao.lprodList();
		return lprodList;
	}

	@Override
	public LprodVo getId(String lprod_id) {
		LprodVo lprodVo = new LprodVo();
		lprodVo = dao.getId(lprod_id);
		return lprodVo;
	}

	@Override
	public Map<String , Object> lprodPagingList(PageVo pageVo) {
		Map<String , Object> resultMap = new HashMap<String, Object>();
		resultMap.put("lprodList", dao.lprodPagingList(pageVo));
		int lprodCnt = dao.lprodCnt();
		int paginationSize = (int) Math.ceil((double)lprodCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		return resultMap;
	}

	@Override
	public int lprodCnt() {
		int lprodCnt = dao.lprodCnt();
		return lprodCnt;
	}

}
