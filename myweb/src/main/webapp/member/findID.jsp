<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>



<!-- 본문 시작 tindID.jsp -->
	<h3>* 아이디/비밀번호 찾기 *</h3>
	<br>
	<form method="get" action="findIDProc.jsp" onsubmit="return idemailCheck()">
	<div style='width: 400px; height: 250px; margin: auto;'>
		<table class="table">
			<tr>
				<td>
					<input type="text" name="mname" id="mname" placeholder="이름" maxlength="10" required>
				</td>
				<td rowspan="2">
				    <!-- type=image는 기본속성이 submit -->
				    <input type="submit" id="iwb" class="btn btn-success" value="조회" >
				</td>
			</tr>
			<tr>
				<td>
				    <input type="text" name="email" id="email" placeholder="이메일" maxlength="30" required>
				</td>
			</tr>
			</div>
		</table>
	</form>
	
	
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>