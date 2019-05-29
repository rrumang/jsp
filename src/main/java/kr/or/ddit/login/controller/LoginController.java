package kr.or.ddit.login.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class LoginController
 */
/**
 * LoginController.java
 *
 * @author PC08
 * @version 1.0
 * @see
 *
 *      <pre>
 * << 개정이력(Modification Information) >>
 * 
 * 수정자 수정내용
 * ------ ------------------------
 * PC08 최초 생성
 *
 * </pre>
 */
// web.xml servlet, servlet-mapping --> java annotation
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	private static final long serialVersionUID = 1L;

	// 사용자 로그인 화면 요청 처리
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("LoginController doGet()");

		for (Cookie cookie : request.getCookies()) {
			logger.debug("cookie : {}, {}", cookie.getName(), cookie.getValue());
		}

		// 로그인화면을 처리해줄 누군가??에게 위임
		// 단순 login화면을 html로 응답을 생성해주는 작업이 필요
		// /login/login.jsp위임 --> 별도의 상태변경이 없기때문에 dispatch방식으로 위임

		// RequestDispatcher rd =
		// request.getRequestDispatcher("/login/login.jsp");
		// rd.forward(request, response);

		// request.getRequestDispatcher("/login/login.jsp").forward(request,
		// response);

		// session에 사용자 정보가 있을경우 --> main화면으로 이동

		// session에 사용자 정보가 없을 경우 --> 기존로직
		HttpSession session = request.getSession();
		if (session.getAttribute("USER_INFO") == null) {
			request.getRequestDispatcher("/login/login.jsp").forward(request,
					response);
		} else {
			request.getRequestDispatcher("/main.jsp")
					.forward(request, response);
		}
	}

	// 로그인 요청을 처리
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		logger.debug("parameter rememberme : {}", request.getParameter("rememberme"));
		logger.debug("parameter userId : {}", request.getParameter("userId"));
		logger.debug("parameter password : {}",	request.getParameter("password"));

		// 사용자 파라미터 userId, password
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		// db에서 해당사용자 정보조회(service,dao)

		// 해당 사용자 정보를 이용하여 사용자가 보낸 userId, password 가 일치하는지 검사
		// -> userId:brown이고 password:brown1234라는 값이면 통과, 그외 값 불일치

		// 일치하면...(로그인 성공) : main화면으로 이동
		if (userId.equals("brown") && password.equals("brown1234")) {

			// remember 파라미터가 존재할 경우 userId, rememberme cookie를 설정해준다.
			// remember 파라미터가 존재하지 않을 경우 userId, rememberme cookie를 삭제해준다.
			int cookieMaxAge = 0;
			if (request.getParameter("rememberme") != null)
				cookieMaxAge = 60 * 60 * 24 * 30;

			Cookie userIdCookie = new Cookie("userId", userId);
			userIdCookie.setMaxAge(cookieMaxAge);

			Cookie remembermeCookie = new Cookie("rememberme", "true");
			remembermeCookie.setMaxAge(cookieMaxAge);

			response.addCookie(userIdCookie);
			response.addCookie(remembermeCookie);

			// session에 사용자 정보를 넣어둔다(사용빈도가 높기 때문에)
			HttpSession session = request.getSession();
			session.setAttribute("USER_INFO", new UserVo("브라운", "brown", "곰"));

			RequestDispatcher rd = request.getRequestDispatcher("/main.jsp");
			rd.forward(request, response);
		} else { // 불일치하면...(아이디 혹은 비밀번호를 잘못입력) : 로그인화면으로 이동
					// 로그인화면으로 이동 : localhost/jsp/login
					// 현재상황에서 /jsp/login url로 dispatch방식으로 위임이 불가
					// request.getMethod(); //GET, POST
			
			response.sendRedirect(request.getContextPath() + "/login");

		}

	}

}
