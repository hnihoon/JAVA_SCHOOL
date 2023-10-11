<%@ page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="net.sungjuk.*" %>

<jsp:useBean id="dao" class="net.sungjuk.SungjukDAO" scope="page"></jsp:useBean>
<jsp:useBean id="dto" class="net.sungjuk.SungjukDTO" scope="page"></jsp:useBean>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukList.jsp</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	
	<h3>* 성적 목록 *</h3>
	<p><a href=sungjukForm.jsp class="btn btn-default">[성적쓰기]</a></p>
	
	<table border='1' class="table">
	<tr class="danger">
		<th>이름</th>
		<th>국어</th>
		<th>영어</th>
		<th>수학</th>
		<th>등록일</th>
	</tr>
<%
	ArrayList<SungjukDTO> list = dao.list();
	if(list==null){
		out.print("<tr>");
		out.print("	  <td colspan='5'>글없음!!</td>");
		out.print("</tr>");
	} else{
		for(int i=0; i<list.size(); i++){
			dto = list.get(i); //한줄 가져오기
%>
		<tr class="warning">
			<td><a href="sungjukRead.jsp?sno=<%=dto.getSno()%>"><%=dto.getUname()%></a></td>
			<td><%=dto.getKor()%>
			<td><%=dto.getEng()%>
			<td><%=dto.getMat()%>
			<td><%=dto.getWdate().substring(0, 10)%>
		</tr>
<%
		}
	}
%>
	</table>
</body>
</html>