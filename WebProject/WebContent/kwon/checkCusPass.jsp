<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#wrap{
		margin: 
	}

	.myhr{
		border: 0;
	    height: 3px;
	    background: #5D5D5D;
	}
	
	.mytable, .mytable td{
		border: 1px solid black;
		border-collapse: collapse;
		padding: 10px;
	}
		
	.userinfo{
		width: 700px;	
	}
	
	.submitBtn{
		padding-top:5px;
		padding-bottom:5px;
		padding-left:10px;
		padding-right:10px;
	}
	.cancelBtn{
		padding-top:5px;
		padding-bottom:5px;
		padding-left:10px;
		padding-right:10px;
	}
	
</style>
</head>
<%
		String driver= application.getInitParameter("Driver");
		String url= application.getInitParameter("url");
		String user= application.getInitParameter("user");
		String password=application.getInitParameter("password");
		
		String pass1;
		String pass2;
		
		String passfromDB = "select password from customer where id =?";
		
		try{
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,password);
		PreparedStatement pstmt = conn.prepareStatement(passfromDB);
		pstmt.setString(1, "test");
		ResultSet rs = pstmt.executeQuery();
		
		if(rs.next()){
			pass1=rs.getString(1);
			out.print("pass="+rs.getString(1));
		}
		
		
		}catch(Exception e){
			out.print(e.getMessage());
		}
%>
<body>
	<div id="wrap">
	<h2>회원정보 확인</h2>
	님의 정보를 안전하게 보호하기 위해 비밀번호를 다시한번 확인합니다.
	<hr class="myhr">
	<form aciton="userModify.jsp" id="passcheckform">
	<table class="mytable">
		<tr>
			<td>
			아이디(이메일)
			</td>
			<td class="userinfo">
			test@naver.com
			</td>			
		</tr>	
		<tr>
			<td>
			비밀번호
			</td>
			<td class="userinfo">
			<input type="text" name="password">
			</td>
		</tr>
	</table>
	<br>
	<input type="submit" value="확인" class="submitBtn">
	<input type="reset" value="취소" class="cancelBtn">
	</form>
	</div>
</body>
</html>