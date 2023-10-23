<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>emailCheckForm.jsp</title>
</head>
<body>

	<div style="text-align: center">
		<h3>* 이메일 중복확인 *</h3>
		<form action="emailCheckProc.jsp" onsubmit="return blankCheck()">
			이메일 : <input type="text" name="email" id="email" maxlength="20" autofocus>
					<input type="submit" value="중복확인">
		</form>		
	</div>
	<script>
		function blankCheck() {
			let email=document.getElementById("email").value;
			email=email.trim();
			exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
			if(exptext.test(email)==false){
				alert("이메일 형식이 올바르지 않습니다.");
				return false;
			}
			return true;
		}
	</script>
</body>
</html>