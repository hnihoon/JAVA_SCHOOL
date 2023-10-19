<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>03_applicationTest.jsp</title>
</head>
<body>
	
	<h3>내장객체</h3>
<%
	/*
	   ● [application 내장객체]
	     - ServletContext application
	     - 사용자 모두가 공유하는 전역적 의미의 객체
	     - 서버에 대한 정보를 관리하는 객체
	*/
	
	//D:\java202307\java\workspace
	//					\.metadata
	//					\.plugins
	//					\org.eclipse.wst.server.core
	//					\tmp0
	//					\wtpwebapps
	//					\myweb
	//					\images
	
	out.print(application.getRealPath("/images")); // /images폴더의 실제 물리적인 경로
	out.print("<hr>");
	//웹경로 http://localhost:9090/myweb/images
	
	//톰캣 10 이상에서는 지원하지 않음
	out.print(request.getRealPath("/images"));
	out.print("<hr>");
	
	//application 내부변수
	application.setAttribute("uid", "ITWILL");
	out.print(application.getAttribute("uid"));
	
////////////////////////////////////////////////////////////////

	//● [response 내장객체] - 요청한 사용자에게 응답할 때
	//	 response.sendRedirect("")페이지 이동
	PrintWriter print = response.getWriter();

%>
</body>
</html>