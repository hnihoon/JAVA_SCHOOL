<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>elTest1.jsp</title>
</head>
<body>

	<h3>* EL(Expression Language) 표현언어 *</h3>
	
	123+456
	<br>
	표현식 : <%=123%><br>
	표현식 : <%=123+456%><br>
	<hr>
	
	표현언어 : ${123}<br>
	표현언어 : ${123+456}<br>
	

 <%-- 	
	<h3>* EL에서 사용되는 연산자 *</h3>
	더하기 : ${123+456}<br>  		579
	빼기	 : ${123-456}<br> 	 	-333
	곱하기 : ${123*456}<br> 		56088
	나누기 : ${123/456}<br>  		0.26973684210526316
	나머지 : ${123%456}<br>  		123
	
	나누기 : ${123 div 456}<br>   0.26973684210526316
	나머지 : ${123 mod 456}<br>   123
	<hr>
	
	2가 3보다 작다 : ${2 < 3}<br>  true 
	2가 3보다 크다 : ${2 > 3}<br>  false
--%>

</body>
</html>