package net.utility;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthenticator extends Authenticator{
	//사용하고자 하는 메일서버(SMTP, POP3)에서 인증받은 계정+비번 등록
	
	private PasswordAuthentication pa;
	
	public MyAuthenticator() {
		pa = new PasswordAuthentication("XXX@XXX.cafe24.com", "XXX");
	}
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}

