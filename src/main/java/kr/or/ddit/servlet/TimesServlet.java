package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TimesServlet extends HttpServlet {
	
	private Logger logger = LoggerFactory.getLogger(TimesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8"); 
		
		// localhost/jsp/timesTables?param=6
		String param = req.getParameter("i");
		logger.debug("param : {}", param);
		
		
		String param2 = req.getParameter("j");
		logger.debug("param2 : {} ", param2);
		
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("	<title>hello world</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table>");
								for(int z=1; z<Integer.parseInt(param); z++){
		pw.write("					<tr>");						
									for(int u=2; u<Integer.parseInt(param2); u++){
		pw.write("						<td>" + u + "*" + z + "=" + u*z + "</td>");
									}
		pw.write("					</tr>");
								}
		pw.write("			</tr>");
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
		
		
	}

}
