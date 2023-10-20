<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 loginProc.jsp -->
<h3>* 로 그 인 결과 *</h3>
<%
	String id = request.getParameter("id").trim();
	String passwd = request.getParameter("passwd").trim();
	
	dto.setId(id);
	dto.setPasswd(passwd);
	String mlevel = dao.loginProc(dto);
	
	out.print("아이디 : " + id);
	out.print("<br>");
	out.print("비밀번호 : " + passwd);
	out.print("<br>");
	if(mlevel==null){
		out.println("<p>아이디/비밀번호 다시 한번 확인해주세요!!</p>");
		out.println("<p><a href='javascript:history.back()'>[다시시도]</a></p>");
	} else{
		//out.print("회원등급 : " + mlevel);
		
		//다른 페이지에서도 로그인 상태 정보를 공유할 수 있도록
		session.setAttribute("s_id", id);
		session.setAttribute("s_passwd", passwd);
		session.setAttribute("s_mlevel", mlevel);
		
		//쿠키 시작----------------------------------------------
		//->웹서버가 사용자PC에 지칭하는 텍스트 파일로 된 정보
		//->각 브라우저의 쿠기삭제의 영향을 받는다.
		//->보안에 취약하다.
		//->예)아이디저장,오늘창그만보기, 클릭한상풍목록
		//->예)오늘창그만보기는 자바스크립트 쿠키. 참조 : https://www.w3schools.com/js/js_cookies.asp

		//<input type="checkbox" name="c_id" value="SAVE">ID저장 
		
		//checkNull : 함수 내 전달값이 null이면 ""반환 아니면 전달값 반환 해주는 메서드 입니다.
		String c_id = Utility.checkNull(request.getParameter("c_id"));
		Cookie cookie = null;
		if(c_id.equals("SAVE")){	//ID저장에 체크를 했다면
			//쿠키 변수 선언 new Cookie("변수명" , 값)
			cookie = new Cookie("c_id" , id);
			//쿠키의 생존기간 1개월
			cookie.setMaxAge(60*60*24*30); //각 브라우저의 쿠키삭제의 영향을 받는다
		} else{
			cookie = new Cookie("c_id" , "");
			cookie.setMaxAge(0);
		}
		
		//요청한 사용자 PC에 쿠키값을 저장
		response.addCookie(cookie);
		//쿠키 끝-----------------------------------------------
		
		//페이지 이동
		//http://localhost:9090/myweb/index.jsp
		String root=Utility.getRoot(); // /myweb반환
		response.sendRedirect(root + "/index.jsp");
	}
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>