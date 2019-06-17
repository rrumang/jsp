package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// localhost/userList.do ==> init ==> 
@WebServlet("*.do")// .do로 끝나는 거에 대해서 프론트컨트롤러가 응답을 처리함
public class FrontController extends HttpServlet{
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
		String uri = req.getRequestURI();
		
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(req, resp);
		
		// viewName redirect:으로 시작할 경우 : redirect
		// 그외에는 forward
		logger.debug("viewName : {}", viewName);
//		if(viewName.startsWith("redirect:"))
//			resp.sendRedirect(viewName.substring("redirect:".length()));
//		else
//			req.getRequestDispatcher(viewName).forward(req, resp);
		
		ViewResolver.viewResolve(viewName, req, resp);
		
		
//		if(uri.equals("/userList.do"))
//			new UserListController().execute(req, resp);
//		else if(uri.equals("/userCreate.do"))
//			new UserCreateController().execute(req, resp);
//		else if(uri.equals("/userModify.do"))
//			new UserModifyController().execute(req, resp);
//		else if(uri.equals("/user.do"))
//			new UserController().execute(req, resp;) 이 부분을 위처럼 단순하게 바꿔줄 수 있다.
	}
}
