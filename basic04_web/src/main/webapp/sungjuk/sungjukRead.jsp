<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukRead.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
 <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

	<h3>* 성적 상세보기 *</h3>
	<p>
		<a href="sungjukForm.jsp" class="btn btn-default">[성적쓰기]</a>
		<a href="sungjukList.jsp" class="btn btn-default">[성적목록]</a>
	</p>
<%
	//예)sungjukRead.jsp?sno=43
	//out.print(request.getParameter("sno"));
	int sno=Integer.parseInt(request.getParameter("sno"));
	
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
		sql.append(" SELECT sno,uname ,kor ,eng ,mat ,aver ,addr ,wdate ");
		sql.append(" FROM sungjuk ");
		sql.append(" WHERE sno=? ");
		
		pstmt=con.prepareStatement(sql.toString());
		pstmt.setInt(1, sno);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
%>
		<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<td><%=rs.getString("uname")%></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><%=rs.getInt("kor")%></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><%=rs.getInt("eng")%></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><%=rs.getInt("mat")%></td>
		</tr>
		<tr>
			<th>평균</th>
			<td><%=rs.getInt("aver")%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=rs.getString("addr")%>
<%
				//주소를 한글로 출력
				String addr = rs.getString("addr");
				if(addr.equals("Seoul")){
					out.print("서울");
				} else if(addr.equals("Jeju")){
					out.print("제주");
				} else if(addr.equals("Suwon")){
					out.print("수원");
				} else if(addr.equals("Busan")){
					out.print("부산");
				}
%>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=rs.getString("wdate")%></td>
		</tr>
		</table>
		<a href="sungjukUpdate.jsp?sno=<%=sno%>" class="btn btn-info">[수정]</a>
		&nbsp;&nbsp;
		<a href="sungjukDel.jsp?sno=<%=sno%>" class="btn btn-danger">[삭제]</a>
<%
		}else{
			out.println("해당 글 없음!!");
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
</body>
</html>