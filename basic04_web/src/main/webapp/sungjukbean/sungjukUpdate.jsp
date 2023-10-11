<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukUpdate.jsp</title>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"> 
</head>
<body>

	<h3>* 성적 수정 *</h3>
	<p>
		<a href="sungjukForm.jsp" class="btn btn-default">[성적쓰기]</a>
		<a href="sungjukList.jsp" class="btn btn-default">[성적목록]</a>
	</p>
<%
	int sno=Integer.parseInt(request.getParameter("sno"));
	dto = dao.read(sno); //수정하고자 하는 행을 DB에서 가져와서 dto에 담기
	
	if(dto==null){
		out.print("해당 글없음!!");
	} else{
		
		%>
		<form name="sungjukfrm" id="sungjukfrm" method="get" action="sungjukUpdateProc.jsp">
		<!-- 사용자에게는 필요한 값이 아니지만, 프로그램 흐름상 필요한 값은 hidden속성으로 담아서 넘긴다. -->
		<input type="hidden" name="sno" value="<%=sno%>">
		<table>
		<tr>
			<th class="form-control">이름</th>
			<td><input type="text" name="uname" id="uname" value="<%=dto.getUname()%>" 
			maxlength="50" required autofocus class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">국어</th>
			<td><input type="number" name="kor" id="kor" value="<%=dto.getKor()%>" 
			size="5" min="0" max="100" required placeholder="국어점수" class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">영어</th>
			<td><input type="number" name="eng" id="eng" value="<%=dto.getEng()%>" 
			size="5" min="0" max="100" required placeholder="영어점수" class="form-control input-sm"></td>
		</tr>	
		<tr>
			<th class="form-control">수학</th>
			<td><input type="number" name="mat" id="mat" value="<%=dto.getMat()%>" 
			size="5" min="0" max="100" required placeholder="수학점수" class="form-control input-sm"></td>
			<tr>
			<th class="form-control">주소</th>
			<td>
				<% String addr= dto.getAddr(); %>
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
	}
%>

</body>
</html>