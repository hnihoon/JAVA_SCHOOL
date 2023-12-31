<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="ssi.jsp" %>
<%@ include file="../header.jsp" %>

<!-- 본문 시작 template.jsp -->
<h3>* 포토갤러리 *</h3>
<p><a href="pdsForm.jsp">[사진올리기]</a></p>
<% 
	ArrayList<PdsDTO> list = dao.list();
	if(list==null){ //if 시작
		out.println("관련 자료 없음!!");
	}else {
		out.println("전체 글 갯수 : " + list.size());
%>
		<table class="table table-hover">
		<thead>
			<tr class="success" id="pdst">
				<th>제목</th>
				<th>사진</th>
				<th>조회수</th>
				<th>작성자</th>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
<%
			for(int i=0; i<list.size(); i++){ //for 시작
				dto=list.get(i);
%>
			<tr>
				<td><a href="pdsRead.jsp?pdsno=<%=dto.getPdsno()%>"><%=dto.getSubject()%></a></td>
				<td><img src="../storage/<%=dto.getFilename()%>" width="50" height="40"></td>
				<td><%=dto.getReadcnt() %></td>
				<td><%=dto.getWname()%></td>
				<td><%=dto.getRegdate().substring(0, 10)%></td>
			</tr>
<%
			} //for 끝
%>
		</tbody>
		</table>
<% 
	} //if 끝

%>
<!-- 본문 끝 -->
<%@ include file="../footer.jsp" %>