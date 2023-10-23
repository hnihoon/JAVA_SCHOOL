<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 bbsIns.jsp -->
<%
	//사용자가 입력 요청한 정보를 가져오기
	String mname	=request.getParameter("mname").trim();
	String subject	=request.getParameter("subject").trim();
	String content	=request.getParameter("content").trim();
	
	//dto객체에 담기
	dto.setMname(mname);
	dto.setSubject(subject);
	dto.setContent(content);
	
	int cnt= dao.create(dto);
	
	if(cnt==0){
		out.println("<p>글추가 실패했습니다.</p>");
		out.println("<p><a href='javascript:hustory.back()'>[다시시도]</a></p>");
	} else{
		out.println("<script>");
		out.println("	alert('게시글이 추가되었습니다.');");
		out.println("	location.href='noticeList.jsp';"); //목록페이지 이동
		out.println("</script>");
	}
	
%>
<!-- 본문 끝 -->

<%@ include file="../footer.jsp" %>