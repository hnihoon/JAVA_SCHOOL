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

dto.setMname(mname);
dto.setEmail(email);

String id = dao.idemailCheck(dto);
String random = dao.getRandomString(10);

dao.incrementCnt(random,id);


try {
	String mailServer = "mw-002.cafe24.com";
	Properties props = new Properties();
	props.put("mail.smtp.host", mailServer);
	props.put("mail.smtp.auth", true);

	Authenticator myAuth = new MyAuthenticator();

	Session sess = Session.getInstance(props, myAuth);

	request.setCharacterEncoding("UTF-8");
	String to = "gmrtkcjsfl@naver.com";
	String from = email;
	String subject = "임시비밀번호 발급 안내";
	StringBuilder content = new StringBuilder();

	content.append("<hr>");
	content.append("임시비밀번호 : ");
	content.append("<hr>");

	InternetAddress[] address = { new InternetAddress(to) };
	/*
		수신인이 여러명인 경우
		InternetAddress[] address = { new InternetAddress(to1), 
	  								  new InternetAddress(to2),
	  								  new InternetAddress(to3), ~~~};}
	*/

	//메일 관련 정보 작성
	Message msg = new MimeMessage(sess);

	msg.setRecipients(Message.RecipientType.TO, address);

	msg.setFrom(new InternetAddress(from));

	msg.setSubject(subject);

	msg.setContent(content.toString(), "text/html; charset=UTF-8");

	msg.setSentDate(new Date());

	Transport.send(msg);
%>
<body>
	<div style="text-align: center">
		회원님의 아이디는
		부탁드립니다.
	</div>
</body>
<%
} catch (Exception e) {
out.println("<p>메일 전송 실패!!" + e + "</p>");
out.println("<p><a href='javascript:history.back();'>[다시시도]</a></p>");
}
%>

<%@ include file="../footer.jsp"%> 