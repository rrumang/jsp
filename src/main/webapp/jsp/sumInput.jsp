<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start<input type="text" name="start" value="2"/> <br>
		end<input type="text" name="end" value="8"/> <br>
		<button>제출</button>
	</form>
</body>
</html>