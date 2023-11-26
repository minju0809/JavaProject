<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%
int memberCount = (int) request.getAttribute("memberCount");
%>
<section>
		<form name="f1" method="post" enctype="multipart/form-data"
			action="<%=path%>/MemberController?sw=I">
		<table border=1>
			<tr>
				<th>번호</th>
				<td><input type="text" name="memberCount" value="<%=memberCount %>" readonly></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" placeholder="(필수)"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="text" name="password" placeholder="(필수)"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="phone"></td>
			</tr>
			<tr>
				<th>지역</th>
				<td><input type="text" name="area" placeholder="(필수)"></td>
			</tr>
			<tr>
				<th>취업분야</th>
				<td><input type="text" name="desired_field"></td>
			</tr>
			<tr>
				<th>공부기간</th>
				<td><input type="text" name="study_period"></td>
			</tr>
			<tr>
				<th>사진</th>
				<td><input type="file" name="photo"></td>
			</tr>
			<tr>
				<td colspan=2 align=center><input type=submit value="등록">
					&emsp; <input type=reset value="다시작성"></td>
			</tr>
		</table>
	</form>
</section>
<%@ include file="/include/bottom.jsp"%>