<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<br>
	<div align=center>
		<b>회원 로그인</b>
	</div>
	<div align=center>
		<form action="<%=path%>/LoginController">
			<input type=hidden name=sw value="loginOK">
			<table border=1>
				<tr>
					<th>아이디</th>
					<td><input type=text name="id" value="admin"></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type=text name="password" value="1234"></td>
				</tr>
				<tr>
					<td colspan=2 align=center><input type=submit value="로그인">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>