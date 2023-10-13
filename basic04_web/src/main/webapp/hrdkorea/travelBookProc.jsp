<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>travelBookProc</title>
</head>
<body>

<%
	request.setCharacterEncoding("UTF-8");

	String rno = request.getParameter("rno");
	String tcode = request.getParameter("tcode");
	String rjumin1 = request.getParameter("rjumin1");
	String rjumin2 = request.getParameter("rjumin2");
	String rname = request.getParameter("rname");
	String rphone1 = request.getParameter("rphone1");
	String rphone2 = request.getParameter("rphone2");
	String rphone3 = request.getParameter("rphone3");
	String remail = request.getParameter("remail");
	String rstat = request.getParameter("rstat");
	
	//주민번호 합침
	String rjumin = rjumin1 + rjumin2;
	
	Connection con = null;
	PreparedStatement pstmt = null;
	
	try{
		String url 		= "jdbc:oracle:thin:@localhost:1521:xe";
		String user 	= "system";
		String password = "1234";
		String driver 	= "oracle.jdbc.driver.OracleDriver"; //objdbc8.jar
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		out.println("오라클DB 서버 연결 성공!!");
		
		StringBuilder sql = new StringBuilder();
		sql.append(" INSERT INTO TBL_RESERVE_01(rno, rjumin, rname, rphone1 ,rphone2, rphone3, remail, rstat, tcode) ");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?) ");
		
		pstmt=con.prepareStatement(sql.toString());
		pstmt.setString(1, rno);
		pstmt.setString(2, rjumin);
		pstmt.setString(3, rname);
		pstmt.setString(4, rphone1);
		pstmt.setString(5, rphone2);
		pstmt.setString(6, rphone3);
		pstmt.setString(7, remail);
		pstmt.setString(8, rstat);
		pstmt.setString(9, tcode);
		
		int cnt=pstmt.executeUpdate();
		
		if(cnt==0){
			out.print("<p>오류가 발생하였습니다.</p>");
			out.print("<p><a href='javascript:history.back()'>[다시시도]</p>");
		} else{
			out.print("<script>");
			out.print("		alert('예약등록이 완료 되었습니다.');");
			out.println("   location.href='travelList.jsp';");  //목록페이지 이동
			out.print("</script>");
		}
		
	}catch(Exception e){
		out.println("오라클DB연결실패 : " + e);
	}finally{
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