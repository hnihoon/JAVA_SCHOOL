<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukUpdate</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

	<h3>* 성적 수정 *</h3>
	<p>
		<a href="sungjukForm.jsp" class="btn btn-default">[성적쓰기]</a>
		<a href="sungjukList.jsp" class="btn btn-default">[성적목록]</a>
	</p>
<%
	//예)수정하고자 하는 글 번호 sungjukUpdate.jsp?sno=21
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
		
		//1)select문을 이용해서 수정할 행을 가져온다. (sungjukRead.jsp 참조)
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT sno,uname ,kor ,eng ,mat ,aver ,addr ,wdate ");
		sql.append(" FROM sungjuk ");
		sql.append(" WHERE sno=? ");
		
		pstmt=con.prepareStatement(sql.toString());
		pstmt.setInt(1, sno);
		
		rs = pstmt.executeQuery();
		if(rs.next()){
			//2) 1)의 내용을 폼에 출력(sungjukForm.jsp참조)

%>
	<form name="sungjukfrm" id="sungjukfrm" method="get" action="sungjukUpdateProc.jsp">
		<!-- 사용자에게는 필요한 값이 아니지만, ㅍ로그램 흐름상 필요한 값은 hidden속성으로 담아서 넘긴다. -->
		<input type="hidden" name="sno" value="<%=sno%>">
		<table>
		<tr>
			<th class="form-control">이름</th>
			<td><input type="text" name="uname" id="uname" value="<%=rs.getString("uname")%>" maxlength="50" required autofocus class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">국어</th>
			<td><input type="number" name="kor" id="kor" value="<%=rs.getInt("kor")%>" size="5" min="0" max="100" required placeholder="국어점수" class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">영어</th>
			<td><input type="number" name="eng" id="eng" value="<%=rs.getInt("eng")%>" size="5" min="0" max="100" required placeholder="영어점수" class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">수학</th>
			<td><input type="number" name="mat" id="mat" value="<%=rs.getInt("mat")%>" size="5" min="0" max="100" required placeholder="수학점수" class="form-control input-sm"></td>
			<tr>
			<th class="form-control">주소</th>
			<td>
				<% String addr= rs.getString("addr"); %>
				<select name="addr" id="addr" class="form-control">
					<option value="Seoul" <%if(addr.equals("Seoul")){out.print("selected");}%>>서울</option>
					<option value="Jeju" <%if(addr.equals("Jeju")){out.print("selected");}%>>제주</option>
					<option value="Suwon" <%if(addr.equals("Suwon")){out.print("selected");}%>>수원</option>
					<option value="Busan" <%if(addr.equals("Busan")){out.print("selected");}%>>부산</option>
				</select>		
			</td>
		</tr>
		<tr>
		    <td colspan="2" align="center">
				<input type="submit" value="전송" class="btn btn-success">
				<input type="reset"  value="취소" class="btn btn-danger">
			</td>
		</tr>
		</table>
	</form>
<%
		} else{
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