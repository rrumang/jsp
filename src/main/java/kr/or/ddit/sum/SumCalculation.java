package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* SumCalculation.java
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
@WebServlet("/sumCalculation")
public class SumCalculation extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(SumCalculation.class);
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter start : {}", request.getParameter("start"));
		logger.debug("parameter end : {}", request.getParameter("end"));
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));
		
		int sum = 0;
		
		for(int i=start; i<=end; i++){
			sum += i;
		}
		
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		request.getRequestDispatcher("/sumResult.jsp").forward(request, response);
		
	}

}
