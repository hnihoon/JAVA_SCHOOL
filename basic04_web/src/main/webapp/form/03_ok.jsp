<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_ok.jsp</title>
</head>
<body>

	<h3>계산결과</h3>
<%
	//한글 인코딩
	request.setCharacterEncoding("UTF-8");
	
	int num1=Integer.parseInt(request.getParameter("num1").trim());
	int num2=Integer.parseInt(request.getParameter("num2").trim());
	String op=request.getParameter("op").trim();
	
	int res1=0;	     //정수형 계산 결과
	double res2=0.0; //실수형 계산 결과
	
	if(op.equals("+")){
		res1=num1+num2;
	} else if(op.equals("-")){
		res1=num1-num2;
	} else if(op.equals("-")){
		res1=num1-num2;
	} else if(op.equals("*")){
		res1=num1*num2;
	} else if(op.equals("/")){
		res2=(double)num1/num2;
	} else if(op.equals("%")){
		res1=num1&num2;
	}
	
%>

	<!-- 출력 -->
	<table>
	<tr>
		<td><%=num1%>&nbsp;</td>
		<td><%=op%>&nbsp;</td>
		<td><%=num2%>&nbsp;</td>
		<td>=&nbsp;</td>
		<td>
<%
		if(op.equals("/")){
			out.print(String.format("%.1f", res2)); //소수점 1가지수로 문자열 출력
		} else {
			out.print(" "+res1);
		}
%>		
		</td>
	</tr>
	</table>

</body>
</html>