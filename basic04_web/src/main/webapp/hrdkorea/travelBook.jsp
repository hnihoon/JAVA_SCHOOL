<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>

<%-- 
	● 공통페이지 추가 방법
	<%@ include file="mainmenu.jsp" %> JSP 디렉티브
	<jsp:include page=""></jsp:include> 액션태그
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>home.jsp</title>
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
	<style>
		header{background:darkblue; color:white; text-align:center;}
		nav {background:lightblue; color:white;}
		footer {background:blue; color:white; text-align:center;}
		.maindiv{
			width: 900px;
			height: 600px;
			margin: auto;
		}
		
		h3{
		text-align: center;
		}
	</style>
	
	<script>
	function validate(){
		
			let rno = $("#rno").val(); 
			let tcode = $("#tcode").val();
			let rjumin1 = $("#rjumin1").val();
			let rjumin2 = $("#rjumin2").val();
			let rname = $("#rname").val();
			let rphone1 = $("#rphone1").val();
			let rphone2 = $("#rphone2").val();
			let rphone3 = $("#rphone3").val();
			let remail = $("#remail").val();
			
			if(rno == ""){
				alert("예약번호가 입력되지 않았습니다!");
				return false;
			 } else if(tcode == ""){
				alert("상품코드가 선택되지 않았습니다!")
				return false;
			} else if(rjumin1 == "" || rjumin2 == ""){
				alert("주민번호가 입력되지 않았습니다!")
				return false;
			} else if(rname == "") {
				alert("예약자성명이 입력되지 않았습니다!")
				return false;
			} else if(rphone1 == "" || rphone2 == "" || rphone3 == ""){
				alert("예약자전화가 입력되지 않았습니다!")
				return false;
			} else if(remail == ""){
				alery("고객이메일이 입력되지 않았습니다!")
				return false;
			} 
			
			return true;
		}
	</script>
</head>
<body>
	
	<header>여행예약 프로그램 ver2018-12</header>
	<nav>
		<jsp:include page="mainmenu.jsp"></jsp:include>
	</nav>
	
	<section>
		<!-- 본문시작 -->
			<h3>예약등록</h3>
			<form name="" id="" method="post" action="travelBookProc.jsp" onsubmit="return validate()">
				<table border="1">
			       <tr>
			           <th>예약번호</th>
			           <td>
			               <input type="text" name="rno" id="rno" size="8" maxlength="8" >
			           </td>
			       </tr>
			       <tr>
			           <th>상품코드</th>
			           <td>
			           	   <select name="tcode" id="tcode">
			           	       <option value="">상품선택</option>
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
		sql.append(" select tcode, '[' || tcode || ']' || tarea "); 
		sql.append("   || SUBSTR(tdate, 1, 4) || '-' || substr(tdate, 5, 2)  || '-' || substr(tdate, 7, 2) ");
		sql.append("   || ' 출발' as tname ");
		sql.append(" from tbl_tourcode_02 ");
		sql.append(" ORDER BY tcode ");
		
		pstmt=con.prepareStatement(sql.toString());
		rs=pstmt.executeQuery();
		if(rs.next()){
			do{
				out.println("<option value='" + rs.getString("tcode") + "'>");
				out.println(rs.getString("tname"));
				out.println("</option>");
			}while(rs.next());
			
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
</select>
			           </td>
			       </tr>
			       <tr>
			           <th>주민번호</th>
			           <td>
			               <input type="text" name="rjumin1" id="rjumin1" size="6" maxlength="6" >
			               -
			               <input type="text" name="rjumin2" id="rjumin2" size="7" maxlength="7" >
			           </td>
			       </tr>
			       <tr>
			           <th>예약자성명</th>
			           <td>
			               <input type="text" name="rname" id="rname" size="20" maxlength="20" >
			           </td>
			       </tr>
			       <tr>
			           <th>예약자전화</th>
			           <td>
			               <input type="text" name="rphone1" id="rphone1" size="3" maxlength="3" >
			               <input type="text" name="rphone2" id="rphone2" size="4" maxlength="4" >
			               <input type="text" name="rphone3" id="rphone3" size="4" maxlength="4" >
			           </td>
			       </tr>
			       <tr>
			               <th>고객이메일</th>
			           <td>
			               <input type="text" name="remail" id="remail" size="30" maxlength="30" >
			           </td>
			       </tr>  
			       <tr>
			           <th>결제상태</th>
			           <td>
			               <input type="radio" name="rstat" id="rstat" value="1" checked>미납
			               <input type="radio" name="rstat" id="rstat" value="2">완납
			           </td>
			       </tr>
					<tr>
			           <td colspan="2">
			               <input type="submit" value="예약" onclick="alery('예약등록이 완료 되었습니다.')">
			               <input type="reset"  value="다시쓰기" onclick="alert('정보를 지우고 처음부터 다시 입력합니다.')">
			           </td>
		      	   </tr>
       </table>
	</form>
		<!-- 본문 끝 -->
	</section>
	<footer>
		<p>
			HRDKOREA Copyright&copy;2018 All rights reserver.
			Human Resources Development Service of Korea
		</p>
	</footer>
</body>
</html>