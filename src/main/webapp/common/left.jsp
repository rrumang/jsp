<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div class="col-sm-3 col-md-2 sidebar">
	<ul class="nav nav-sidebar">
		<li class="active"><a href="#">Main <span class="sr-only">(current)</span></a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/userList">사용자리스트2</a></li>
		<li class="active"><a href="${pageContext.request.contextPath}/userPagingList">페이지리스트</a></li><%--?page=1&pageSize=10--%>
		<li class="active"><a href="${pageContext.request.contextPath}/lprodPagingList">lprod 페이징 리스트</a></li><%--?page=1&pageSize=10--%>
	</ul>
</div>