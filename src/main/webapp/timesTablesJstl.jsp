<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{
		border : 1px solid black;
	}
</style>
</head>
<body>
	<!-- localhost/jsp/jsp/timesTables.jsp -->
	<!-- 9*9단 출력 (2~9) -->
	<table>
		<c:forEach begin="1" end="${param.i == null ? 9 : param.i}" step="1" var="i">
			<tr>
				<c:forEach begin="2" end="${param.j == null ? 9 : param.j}" step="1" var="j">
						<td>${j } * ${i } = ${i*j }</td>
				</c:forEach>
			</tr>
		</c:forEach>
	</table>
</body>
</html>