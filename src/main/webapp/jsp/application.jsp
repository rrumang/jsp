<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileInputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.write("application.getContextPath()  :" + application.getContextPath() + "<br>");
	out.write("application.getServerInfo()   :" + application.getServerInfo() + "<br>");
	out.write("application.getMajorVersion() :" + application.getMajorVersion() + "<br>");
	out.write("application.getMinorVersion()  :" + application.getMinorVersion() + "<br>");
	out.write("application.getInitParameter(\"ADMIN\")  :" + application.getInitParameter("ADMIN") + "<br>");
	
	out.write("application.getRealPath(\"/res/190522.txt\") : " + application.getRealPath("/res/190522.txt"));
	
	try{
		FileReader fr = new FileReader(application.getRealPath("/res/190522.txt"));
		BufferedReader br = new BufferedReader(fr);
		
		String tmp = "";
		
		for(int i=1; (tmp=br.readLine())!= null; i++){
			out.write(tmp + "<br>");
		}
		br.close();
	} catch (IOException e){
		e.printStackTrace();
	}
	
%>
</body>
</html>