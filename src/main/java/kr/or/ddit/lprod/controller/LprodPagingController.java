package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.IlprodService;
import kr.or.ddit.lprod.service.LprodService;
import kr.or.ddit.paging.model.PageVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* LprodPagingList.java
*
* @author PC08
* @version 1.0
* @see
*
* <pre>
* << 개정이력(Modification Information) >>
*
* 수정자 수정내용
* ------ ------------------------
* PC08 최초 생성
*
* </pre>
*/
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingController.class);
	
	private IlprodService lprodService;
	
	@Override
	public void init() throws ServletException {
		lprodService = new LprodService();
	}
	
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int page = 0;
		int pageSize = 0;
		
		if(request.getParameter("page") != null){
			page = Integer.parseInt(request.getParameter("page"));
		}else{
			page = 1;
		}
		
		if(request.getParameter("pageSize")!= null){
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
		}else{
			pageSize = 5;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setPage(page);
		pageVo.setPageSize(pageSize);
		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
