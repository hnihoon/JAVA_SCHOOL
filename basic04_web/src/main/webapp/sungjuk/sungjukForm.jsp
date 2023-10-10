<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sungjukForm.jsp</title>
<style>

</style>
</head>
<body>

	<h3>* 성적 입력 폼 *</h3>
	<p><a href="sungjukList.jsp" class="btn btn-default">[성적목록]</a>
	
<form name="sungjukfrm" id="sungjukfrm" method="get" action="sungjukIns.jsp">
	<table>
	<tr>
		<th class="form-control">이름</th>
		<td><input type="text" name="uname" id="uname" maxlength="50" required autofocus class="form-control input-sm"></td>
	</tr>	
	<tr>
		<th class="form-control">국어</th>
		<td><input type="number" name="kor" id="kor" size="5" min="0" max="100" required placeholder="국어점수" class="form-control input-sm"></td>
	</tr>	
	<tr>
		<th class="form-control">영어</th>
		<td><input type="number" name="eng" id="eng" size="5" min="0" max="100" required placeholder="영어점수" class="form-control input-sm"></td>
	</tr>	
	<tr>
		<th class="form-control">수학</th>
		<td><input type="number" name="mat" id="mat" size="5" min="0" max="100" required placeholder="수학점수" class="form-control input-sm"></td>
		<tr>
		<th class="form-control">주소</th>
		<td>
			<select name="addr" id="addr" class="form-control">
				<option value="Seoul">서울</option>
				<option value="Jeju">제주</option>
				<option value="Suwon">수원</option>
				<option value="Busan">부산</option>
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

</body>
</html>