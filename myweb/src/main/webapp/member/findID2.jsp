<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../header.jsp" %>



<!-- 본문 시작 tindID.jsp -->
<h3>* 아이디/비밀번호 찾기 *</h3>
												<!-- myscript.js -->
<form method="post" action="findIDProc2.jsp" onsubmit="return idemailCheck()">
	<div style='width: 400px; height: 250px; margin: auto;'>
		<table class="table">
			<tr>
				<td>
					<input type="text" name="mname" id="mname" placeholder="이름" maxlength="10" required>
				</td>
			</tr>
			<tr>
				<td>
				    <input type="text" name="email" id="email" placeholder="이메일" maxlength="30" required>
				</td>
			</tr>
		</table>
		<input type="submit" value="아이디/비번찾기"  class="btn btn-primary" id="setiw"/>
		<input type="reset"  value="취소"  class="btn btn-primary" id="iwreset"/>
			</div>
	</form>
	
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>