<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	//예)sungjukRead.jsp?sno=43
	out.print(request.getParameter("sno"));
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
		sql.append(" delete FROM sungjuk ");
		sql.append(" WHERE sno=? ");
		
		pstmt=con.prepareStatement(sql.toString());
		pstmt.setInt(1, sno);
		
		int cnt=pstmt.executeUpdate();
		if(cnt==0){
			out.print("<p>성적 삭제 실패했습니다!!</p>");
			out.print("<p><a href='javascript:history.back()'>[다시시도]</p>");
		} else{
			out.print("<script>");
			out.print("		alert('성적이 삭제되었습니다.');");
			out.print("		location.href='sungjukList.jsp';");	//목록페이지 이동
			out.print("</script>");
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