<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%@include file="/common/basicLib.jsp" %>

<script>
$(document).ready(function(){
	$("#locale").on("change", function(){
		$("#frm").submit();
	});
	$("#locale").val("${locale}");
});
</script>
</head>
<body>
<h2>select locale</h2>
<form  action="${cp }/selectLocale" id="frm" method="post">
	<select id="locale" name="locale">
	<%-- <option value="ko" <c:if test="${select == 'ko' }">selected</c:if>>한국어</option>
		<option value="en" <c:if test="${select == 'en' }">selected</c:if>>English</option>
		<option value="ja" <c:if test="${select == 'ja' }">selected</c:if>>日本語</option> --%>
		<option value="ko">한국어</option>
		<option value="en">English</option>
		<option value="ja">日本語</option>
	</select>
</form>

<fmt:setLocale value="${locale }"/>
<fmt:bundle basename="kr.or.ddit.msg.msg">
	<fmt:message key="GREETING"/><br>
	<fmt:message key="VISITOR">
		<fmt:param value="brown"/><br>
	</fmt:message>
</fmt:bundle>
</body>
</html>