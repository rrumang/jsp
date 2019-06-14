package kr.or.ddit.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

// contextPath -> js, css 경로설정
// ${cp}/js/jquery.js
// application cp라는 속성에 contextPath 값을 넣어주면
//${cp}/js/jquery.js 처럼 편하게 쓸 수 있다.

public class ApplicationListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext application = sce.getServletContext();
		application.setAttribute("cp", application.getContextPath());
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
	}

}
