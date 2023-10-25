<%@page import="java.util.Date"%>
<%@page import="javax.mail.internet.*"%>
<%@page import="net.utility.*"%>
<%@page import="javax.mail.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp"%>
<%@ include file="../header.jsp"%>

<!-- 본문 시작 template.jsp -->
<%
	String mname = request.getParameter("mname");
	String email = request.getParameter("email");
	
	out.print(mname);
	out.print(email);
	
	dto.setMname(mname);
	dto.setEmail(email);
	
	boolean flag = dao.findID(dto);
	
	if(flag == false){
		out.print("<p>이름/이메일을 다시 한번 확인해주세요!!</p>");
		out.print("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	} else{
		String message="";
		message += "아아디/임시 비밀번호가 이메일로 전송되었습니다.\\n";
		message += "임시 비밀번호는 로그인 후 회원정보수정에서 수정하시기 바랍니다.";
		out.println("<script>");
		out.println("	alert('" + message + "');");
		out.println("	location.href='loginForm.jsp'");
		out.println("</script>");
	}

%>
	
<%@ include file="../footer.jsp"%> 