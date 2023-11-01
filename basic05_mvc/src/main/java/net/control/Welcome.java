package net.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
	※ 참조 : https://docs.oracle.com/javaee/7/api/
		
	● HttpServlet 클래스
	  - http 프로토콜 기반의 요청과 응답을 처리해 주는 클래스
	 
	● Welcome 서블릿 클래스
	  - /WER-INF/web.xml (배치관리자)에 등록해야 한다.
	
	● 결과확인
	  - http:localhost:9090/basic05_mvc/wel.do
*/
	
public class Welcome extends HttpServlet {
	//나의 클래스의 부모가 class		: extends 	 상속(확장)
	//나의 클래스의 부모가 interface  : implements 상속(구현)
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송방식 method=get방식으로 요청하면 doGet() 함수가 자동으로 호출됨
		//req : 모델1방식의 내장객체 request와 동일
		//resp : 모델1방식의 내장객체 response와 동일
		try {
			
			//HTML문서 구조로 응답
			resp.setContentType("text/html; charset=UTF-8");
			
			//단순 문자열 응답(AJAX)
			//resp.setContentType("text/html; charset=UTF-8");
			
			PrintWriter out = resp.getWriter();
			out.println(" <!DOCTYPE html> ");
			out.println(" <html> ");
			out.println(" <head> ");
			out.println(" 	<meta charset=\"UTF-8\"> ");
			out.println(" 	<title>환영합니다.</title> ");			
			out.println(" </head> ");			
			out.println(" <body> ");			
			out.println(" 	<strong>대한민국</strong> ");			
			out.println(" 	<hr> ");			
			out.println(" 	<span style='color:red'>오필승코리아</span> ");			
			out.println(" 	<hr> ");			
			out.println(" 	<table border='1'> ");			
			out.println(" 	<tr> ");			
			out.println(" 		<th>이름</th> ");			
			out.println("		 <td>무궁화</td> ");			
			out.println(" 	</tr> ");			
			out.println(" 		</table> ");			
			out.println(" </body> ");			
			out.println(" </html> ");			

		}catch(Exception e) {
			System.out.println("요청실패 : " + e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//전송방식 method=post방식으로 요청하면 doPost() 함수가 자동으로 호출됨
	}
	
}
