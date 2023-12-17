<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<form action="<%=path%>/BasicBoardController">
	<input type=hidden name="sw" value="I">
		<table border=1>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" placeholder="(필수)"></td>
			</tr>
			<tr>
				<th>제목</th>
				<td><input type="text" name="title"></td>
			</tr>
			<tr>
				<th>내용</th>
				<td><input type="text" name="content"></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=submit value="등록">
					&emsp; <input type=reset value="다시작성"></td>
			</tr>
		</table>
	</form>
</section>
<%@ include file="/include/bottom.jsp"%>


