<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ct" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


1. 고정문자열 : ========================================================= <br>
2. loop : <c:forEach begin="1" end="52">=</c:forEach> <br>
3. customTag : <ct:logging/> <br>
4. loopCumstomTag : <ct:loopLogging/><br>
5. colorLogging : <ct:colorLogging size="10" color="blue"/> <br>
6. colorLogging : <ct:colorLogging color="red"/> <br>
7. rangersTag : <ct:rangers rangers="brown,cony,james,sally,moon"/> <br>
8. code : <ct:code code="P201"/>
</body>
</html>