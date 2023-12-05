<%@ page language="java"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>
<%@ page import="pkg.studyBoard.*" %>

<% 
List<StudyBoardVO> li = (List<StudyBoardVO>) request.getAttribute("li");
%>
<section>
	<div>
		<h2>공부게시판</h2>
		<table border=1>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>내용</th>
				<th>아이디</th>
			</tr>
			<% 
			for (StudyBoardVO vo : li) { 
				int study_board_number = vo.getStudy_board_number();
				String id = vo.getId();
				String study_board_title = vo.getStudy_board_title();
				String study_board_content = vo.getStudy_board_content();
			%>
			<tr>
				<td><%=study_board_number %></td>
				<td><a href="<%=path %>/StudyBoardController?sw=E&id=<%=id %>"><%=study_board_title %></a></td>
				<td><%=study_board_content %></td>
				<td><%=id %></td>
			</tr>
			<% } %>
		</table>
	</div>
</section>

<%@ include file="/include/bottom.jsp" %>