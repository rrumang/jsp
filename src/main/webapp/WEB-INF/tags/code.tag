<%@tag import="kr.or.ddit.prod.model.ProdVo"%>
<%@tag import="java.util.List"%>
<%@tag import="kr.or.ddit.prod.dao.ProdDao"%>
<%@tag import="kr.or.ddit.prod.dao.IprodDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@tag import="java.sql.DriverManager"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@ attribute name="code" required="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
code : ${code } <br>
<%-- <%
	String code = (String)jspContext.getAttribute("code");
	final String driver = "oracle.jdbc.driver.OracleDriver";
	final String url = "jdbc:oracle:thin:@localhost:1521:xe";
	final String user = "pc08";
	final String pass = "java";
	
	Connection conn = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	try{
		Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		pst = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu=?");
		pst.setString(1, code);
		
		rs = pst.executeQuery();
		
		out.write("<select>");
		while(rs.next())
			out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
		out.write("</select>");
		
		conn.close();
				
	}catch(Exception e){
		e.printStackTrace();
	}
%> --%>
<%
	IprodDao dao = new ProdDao();
	jspContext.setAttribute("prodList", dao.prodList(code));

%>
	<select>
		<c:forEach items="${prodList }" var="prod">
			<option value="${prod.prod_id }">${prod.prod_name }</option>
		</c:forEach>
	</select>









