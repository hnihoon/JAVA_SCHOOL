<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukRead.jsp</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
</head>
<body>

	<h3>* 성적 상세보기 *</h3>
	<p>
		<a href="sungjukForm.jsp" class="btn btn-default">[성적쓰기]</a>
		<a href="sungjukList.jsp" class="btn btn-default">[성적목록]</a>
	</p>
<%
	int sno=Integer.parseInt(request.getParameter("sno"));
	dto = dao.read(sno);
	
	if(dto==null){
		out.print("해당 글없음!!");
		
	} else{	
%>
		<table class="table table-bordered">
		<tr>
			<th>이름</th>
			<td><%=dto.getUname()%></td>
		</tr>
		<tr>
			<th>국어</th>
			<td><%=dto.getKor()%></td>
		</tr>
		<tr>
			<th>영어</th>
			<td><%=dto.getEng()%></td>
		</tr>
		<tr>
			<th>수학</th>
			<td><%=dto.getMat()%></td>
		</tr>
		<tr>
			<th>평균</th>
			<td><%=dto.getAver()%></td>
		</tr>
		<tr>
			<th>주소</th>
			<td><%=dto.getAddr()%>
<%
				//주소를 한글로 출력
				String addr = dto.getAddr();
				if(addr.equals("Seoul")){
					out.print("서울");
				} else if(addr.equals("Jeju")){
					out.print("제주");
				} else if(addr.equals("Suwon")){
					out.print("수원");
				} else if(addr.equals("Busan")){
					out.print("부산");
				}
	}
%>
			</td>
		</tr>
		<tr>
			<th>작성일</th>
			<td><%=dto.getWdate()%></td>
		</tr>
		</table>
		<a href="sungjukUpdate.jsp?sno=<%=sno%>" class="btn btn-info">[수정]</a>
		&nbsp;&nbsp;
		<a href="sungjukDel.jsp?sno=<%=sno%>" class="btn btn-danger">[삭제]</a>
	
</body>
</html>
