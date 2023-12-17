<%@ page language="java"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>
<%@ page import="pkg.basicBoard.*" %>

<% 
@SuppressWarnings("unchecked")
List<BasicBoardVO> li = (List<BasicBoardVO>) request.getAttribute("li");
%>
<section>
	<div>
		<h2>기본게시판</h2>
		<table border=1>
			<tr>
				<th>순번</th>
				<th>제목</th>
				<th>내용</th>
				<th>아이디</th>
				<th>등록일자</th>
				<th>조회수</th>
				<th>삭제</th>
			</tr>
			<% 
			for (BasicBoardVO vo : li) { 
				int boardNumber = vo.getBoardNumber();
				String title = vo.getTitle();
				String content = vo.getContent();
				String id = vo.getId();
				String regist_date = vo.getRegist_date();
				int cnt = vo.getCnt();
			%>
			<tr>
				<td><%=boardNumber %></td>
				<td><%=title %></td>
				<td><%=content %></td>
				<td><%=id %></td>
				<td><%=regist_date %></td>
				<td><%=cnt %></td>
				<td><button onClick="window.location='./BasicBoardController?sw=D&boardNumber=<%=boardNumber %>'">삭제</button></td>
			</tr>
			<% } %>
		</table>
	</div>
</section>

<%@ include file="/include/bottom.jsp" %>

