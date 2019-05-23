package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* mulCalculation.java
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
@WebServlet("/mulCalculation")
public class mulCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(mulCalculation.class);
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter start : {}", request.getParameter("parameter1"));
		logger.debug("parameter end : {}", request.getParameter("parameter2"));
		
		int start = Integer.parseInt(request.getParameter("parameter1"));
		int end = Integer.parseInt(request.getParameter("parameter2"));
		
		int mul = 1;
		
		for(int i= start; i<=end; i++){
			mul *= i; 
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("mulResult", mul);
		request.getRequestDispatcher("/mulResult.jsp").forward(request, response);
	}

}
