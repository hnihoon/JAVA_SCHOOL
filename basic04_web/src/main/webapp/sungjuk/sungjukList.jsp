<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukList.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h3>* 성적 목록 *</h3>
	<p><a href="sungjukForm.jsp" class="btn btn-default">[성적쓰기]</a>
	
	<table border='1' class="table">
	<tr class="danger">
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>등록일</th>
	</tr>
<%
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try{
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "system";
		String password = "1234";
		String driver 	= "oracle.jdbc.driver.OracleDriver"; //objdbc8.jar
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT sno, uname, kor, eng, mat, wdate ");
		sql.append(" FROM sungjuk ");
		sql.append(" ORDER BY wdate desc ");
		
		pstmt=con.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		if(rs.next()){
			do{
%>
				<tr class="warning">
					<td><a href="sungjukRead.jsp?sno=<%=rs.getInt("sno")%>"><%=rs.getString("uname")%></a></td>				
					<td><%=rs.getInt("kor")%></td>				
					<td><%=rs.getInt("eng")%></td>				
					<td><%=rs.getInt("mat")%></td>				
					<td><%=rs.getString("wdate").substring(0, 10)%></td>				
				</tr>
<% 
			}while(rs.next());
			
		} else{
			out.print("<tr>");
			out.print("	 <td colspna='5'>글없음!!</td>");
			out.print("</tr>");
		}
		
	}catch(Exception e){
		out.println("오라클DB연결실패 : " + e);
	}finally{ //자원반납(순서주의)
		try{
			if(rs!=null){rs.close();}
		}catch(Exception e){}
		try{
			if(pstmt!=null){pstmt.close();}
		} catch(Exception e){}
		try{
			if(con!=null) {con.close();}
		} catch(Exception e){}
	}
%>
	</table>
</body>
</html>