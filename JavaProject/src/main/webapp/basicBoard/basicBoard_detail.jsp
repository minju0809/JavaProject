<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%@ page import="pkg.basicBoard.*"%>

<%
BasicBoardVO vo = (BasicBoardVO) request.getAttribute("vo");
int boardNumber = vo.getBoardNumber();
String title = vo.getTitle();
String content = vo.getContent();
String id = vo.getId();
String regist_date = vo.getRegist_date();
int cnt = vo.getCnt();
%>
<section>
	<div>
		<h2>상세보기</h2>
		<table border=1 width="300">
			<tr>
				<th>번호</th>
				<td><%=boardNumber%></td>
			</tr>
			<tr>

				<th>아이디</th>
				<td><%=id%></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><%=title%></td>
			</tr>
			<tr>

				<th>내용</th>
				<td><%=content%></td>
			</tr>
			<tr>

				<td colspan=2 align=center>
					<button onClick="window.location='./BasicBoardController?sw=S'">목록</button>	
					<button
						onClick="window.location='./BasicBoardController?sw=D&boardNumber=<%=boardNumber%>'">삭제</button>
				</td>
			</tr>
		</table>
	</div>
</section>

<%@ include file="/include/bottom.jsp"%>

