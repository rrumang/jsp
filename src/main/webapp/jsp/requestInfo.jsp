<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 스크립틀릿 <%%> : 자바 로직을 작성하는 공간 --%>
	<%-- 표현식 <%=%>   : 결과물을 출력 --%>
	<%
		String msg = "test";
		msg += "_append";
	%>	
<!-- 		//jsp의 내장 객체, 묵시적객체(implict)(이미 선언돼있는 객체이기 떄문에 별도의 선언없이 사용가능한 객체의하나) -->
		request.getRemoteAddr()  : <%=request.getRemoteAddr()  %><br>
		request.getLocalAddr()   : <%=request.getLocalAddr()   %><br>
		request.getContentType() : <%=request.getContentType() %><br>
		request.getContextPath() : ${cp}<br>
		request.getMethod() :  <%=request.getMethod() %><br>
		request.getRequestURI() :  <%=request.getRequestURI() %><br>
		request.getProtocol() :  <%=request.getProtocol() %><br>
		
		<img src="${cp}/img/ryan.png">
		
		<%-- 파라미터 받기 --%>
		request.getParameter("rangersName") : <%=request.getParameter("rangersName") %><br>
		
</body>
</html>