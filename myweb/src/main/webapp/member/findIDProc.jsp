<%@page import="javax.mail.Transport"%>
<%@page import="java.util.Date"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.activation.MimeType"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="net.utility.Utility"%>
<%@page import="javax.mail.Session"%>
<%@page import="net.utility.MyAuthenticator"%>
<%@page import="javax.mail.Authenticator"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="ssi.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>findIDProc.jsp</title>
</head>
<body>

<%
	String mname = request.getParameter("mname");
	String email = request.getParameter("email");
	
	dto.setMname(mname);
	dto.setEmail(email);
	
	String id = dao.idemailCheck(dto);
	String random = dao.getRandomString(10);
	
	dao.incrementCnt(random,id);
	
try{
		
		
		//2)메일서버(POP3/SMTP) 지정하기
		String mailServer = "mw-002.cafe24.com"; //cafe24 메일서버
		Properties props = new Properties();
		props.put("mail.smtp.host", mailServer);
		props.put("mail.smtp.auth", true);
		
		//3)메일서버에서 인증받은 계정+비번
		Authenticator myAuth = new MyAuthenticator(); //다형성
		
		//4) 2)와 3)이 유효한지 검증
		Session sess = Session.getInstance(props, myAuth);
		out.print("메일 서버 인증 성공!!");
		
		//5)메일 보내기
		request.setCharacterEncoding("UTF-8");
		String subject="임시 비밀번호 발송";
		String content="임시 비밀번호 입니다.";
		
		
		//엔터 및 특수문자 변경
		content=Utility.convertChar(content);
		
		//표작성
		content += "<hr>";
		content += "<table border='1'>";
		content += "<tr>";
		content += "	<th>아이디</th>";
		content += "	<th>임시 비밀번호</th>";
		content += "</tr>";
		content += "<tr>";
		content += "	<td>" + id + "</td>";
		content += "	<td>" + random + "</td>";
		content += "</tr>";
		content += "</table>";
		
		//받는사람 이메일주소
		InternetAddress[] address = { new InternetAddress(email)};
		
		//메일 관련 정보 작성
		Message msg = new MimeMessage(sess);
		
		//받는사람
		msg.setRecipients(Message.RecipientType.TO, address);
		//참조		Message.RecipientType.CC
		//숨은참조		Message.RecipientType.BCC
		
		//보내는 사람
		msg.setFrom(new InternetAddress("hdh462601@gmail.com"));
		
		//메일 제목
		msg.setSubject(subject);
		
		//메일 내용
		msg.setContent(content, "text/html; charset=UTF-8");
		
		//메일 보낸 날짜
		msg.setSentDate(new Date());
		
		//메일 전송
		Transport.send(msg);
		
		out.print(id+"님에게 메일이 발송되었습니다.");
		
		
	}catch(Exception e){
		out.println("<p>메일 전송 실패!!" + e + "</p>");
		out.println("<p><a href='javascript:history.back();'>[다시시도]</a></p>");
	}
		
%>

</body>
</html>