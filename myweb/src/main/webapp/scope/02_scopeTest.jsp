<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>02_scopeTest.jsp</title>
</head>
<body>

	<h3>웹페이지 내부변수의 SCOPE(유효범위)</h3>
<%--
	 ● [페이지 이동]
	   1) <a href=""></a>
	   2) <form action=""></form>
	   3) location.href=""
	   4) <jsp:forward page=""></jsp:forward>
	   5) response.sendRedirect("")
 --%>
<%
	pageContext.setAttribute("one", 100);
	request.setAttribute("two", 200);
	session.setAttribute("three", 300);
	application.setAttribute("uid", "WebMaster");
%>
 	<!-- 1)a태그 활용 request 적용X --> 
	<a href="02_scopeResult.jsp">[a태그 SCOPE 결과 페이지 이동]</a>
	
	<hr>
	<!-- 2)form태그 action활용 request 적용X -->
 	<form action="02_scopeResult.jsp">
 		<input type="submit" value="[action SCOPE 결과 페이지 이동]">
 	</form>
 	
 	<!-- 3)location.href활용 request 적용X -->
 	<!-- 
 		<script>
 			alert("[location.href로 SCOPE 결과 페이지 이동]");
 			location.href="02_scopeResult.jsp";
 		</script> 
 	-->
 	
 	<!-- 4)responsc.sendRedirect() 활용 request 적용X -->
<%
	/* response.sendRedirect("02_scopeResult.jsp"); */
%>

---------------------------------------------------------------------
 	
 	<!-- 5)액션태그 활용 request 적용O -->
 	<!--
 	 request.getAttribute("two") 200 접근 가능
 	 request 내부변수는 부모페이지(02_scopeTest.jsp)와 자식페이지(02_scopeResult.jsp)에서만 유효하다	
 	 -->
 	<%-- <jsp:forward page="02_scopeResult.jsp"></jsp:forward> --%>
 	
 	<!-- 6) RequestDispatcher 활용 request 적용O-->
<%
	String view = "02_scopeResult.jsp";
	RequestDispatcher rd = request.getRequestDispatcher(view);
	rd.forward(request, response);
%>
 	<!-- 
 		내부변수 		02_scopeTest.jsp(부모) 	02_scopeResult.jsp(자식)
 		------------------------------------------------------------
 		pageContext			o						X			
		request				o					o 또는 X
		session				o						o
		application			o						o
 		
 	 -->
</body>
</html>