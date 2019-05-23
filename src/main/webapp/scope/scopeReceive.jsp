<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%	
	// 출력용 아니고 로직용
	//4가지 파라미터를 받아서 4가지 영역의 속성으로 넣어준다
	//속성으로 넣는방법 : scope객체.setAttribute("속성명",속성(객체));
	//scope객체 : pageContext, request, session, application
	
	pageContext.setAttribute("pageAttribute", request.getParameter("pageParam"));
	request.setAttribute("requestAttribute", request.getParameter("requestParam"));
	session.setAttribute("sessionAttribute", request.getParameter("sessionParam"));
	application.setAttribute("applicationAttribute", request.getParameter("applicationParam"));
	
	request.getRequestDispatcher("/scope/scopePrint.jsp").forward(request, response);
%>