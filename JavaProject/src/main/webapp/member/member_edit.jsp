<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%
MemberVO m = (MemberVO) request.getAttribute("m");
%>

<section>
	<div>
		<h2>회원목록</h2>
		<form action="<%=path%>/MemberController">
			<input type=hidden name=sw value="U"> 
			<table border=1>
				<%
				int memberCount = m.getMemberCount();
				String id = m.getId();
				String password = m.getPassword();
				String age = m.getAge();
				String phone = m.getPhone();
				String region = m.getRegion();
				String desired_field = m.getDesired_field();
				String study_period = m.getStudy_period();
				String grade = m.getGrade();
				String join_date = m.getJoin_date().substring(0, 19);
				%>
				<tr>
					<th>순번</th>
					<td><input type=text name="memberCount" value="<%=memberCount%>"
						readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type=text name="id" value="<%=id%>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type=text name="password" value="<%=password%>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type=text name="age" value="<%=age%>"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type=text name="phone" value="<%=phone%>"></td>
				</tr>
				<tr>
					<th>지역</th>
					<td><input type=text name="region" value="<%=region%>"></td>
				</tr>
				<tr>
					<th>취업분야</th>
					<td><input type=text name="desired_field" value="<%=desired_field%>"></td>
				</tr>
				<tr>
					<th>공부기간</th>
					<td><input type=text name="study_period" value="<%=study_period%>"></td>
				</tr>
				<%
				if (login_grade.equals("A")) {
				%>
				<tr>
					<th>등급</th>
					<td><input type=text name="grade" value="<%=grade%>"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type=text name="join_date" value="<%=join_date%>"></td>
				</tr>
				<tr>
					<td colspan=3 align=center>
						<input type=submit value="수정하기">
						<input type=button value="삭제하기" onClick="confirmDelete('<%=path%>/MemberController?sw=D&id=<%=id%>')">
					</td>
				</tr>
				<%
				} else if (login_grade.equals("C")) {
				%>
				<tr>
					<th>등급</th>
					<td><input type=text name="회원" value="회원" readonly></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type=text name="join_date" value="<%=join_date%>" readonly></td>
				</tr>
				<tr>
					<td colspan=3 align=center><input type=submit value="수정하기">
					</td>
				</tr>
				<%
				}
				%>
			</table>
		</form>
	</div>
</section>

<script>
	function confirmDelete(url) {
		var confirmResult = confirm("정말로 삭제하시겠습니까?");

		if (confirmResult) {
			window.location.href = url;
		}
	}
</script>

<%@ include file="/include/bottom.jsp"%>