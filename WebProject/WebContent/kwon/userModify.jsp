<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>개인정보 수정페이지</h1>
	<%
		String driver= application.getInitParameter("Driver");
		String url= application.getInitParameter("url");
		String user= application.getInitParameter("user");
		String password=application.getInitParameter("password");
		out.print(driver+"<br>");
		out.print(url+"<br>");
		out.print(user+"<br>");
		out.print(password+"<br>");
		try{
		//드라이버 로드
		Class.forName(driver);
		//DB연결 객체 얻기
		Connection conn = DriverManager.getConnection(url,user,password);
		if(conn!=null){
			out.print("webDB에 연결했습니다.<br>");
			conn.close();
			out.print("webDB에서 연결을 끊었습니다.");
		}else
			out.print("webDB 연결을 할 수 없습니다.");
		}catch(Exception e){
			out.print(e.getMessage());
		}
	%>
</body>
</html>