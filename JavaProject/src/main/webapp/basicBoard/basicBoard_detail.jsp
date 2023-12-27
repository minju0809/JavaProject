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
		<form action="<%=path%>/BasicBoardController">
			<input type=hidden name="sw" value="U">
			<table border=1 width="300">
				<tr>
					<th>번호</th>
					<td><input type=text name="boardNumber" value=<%=boardNumber%> readonly /></td>
				</tr>
				<tr>

					<th>아이디</th>
					<td><%=id%></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type=text name="title" value=<%=title%> /></td>
				</tr>
				<tr>

					<th>내용</th>
					<td><input type=text name="content" value=<%=content%> /></td>
				</tr>
				<tr>

					<td colspan=2 align=center>
						<button onClick="window.location='./BasicBoardController?sw=S'">목록</button>
						<input type=submit value="수정"/>
						<button
							onClick="window.location='./BasicBoardController?sw=D&boardNumber=<%=boardNumber%>'">삭제</button>
					</td>
				</tr>
			</table>
		</form>
	</div>
</section>

<%@ include file="/include/bottom.jsp"%>

