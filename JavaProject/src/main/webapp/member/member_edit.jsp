<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%
MemberVO m = (MemberVO) request.getAttribute("m");
System.out.println("@@@@@@@@ edit" + m);
%>

<section>
	<div>
		<h2>회원목록</h2>
		<form action="<%=path%>/MemberController?sw=U" method=post
			enctype="multipart/form-data">
			<input type=hidden name=sw value="U"> 
			<input type=hidden name=id value="<%=m.getId()%>">
			<table border=1>
				<%
				int memberCount = m.getMemberCount();
				String photo = m.getPhoto();
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
					<td rowspan=11><img src="<%=path%>/files/<%=photo%>" width=100
						height=100></td>
					<th>순번</th>
					<td><input type=text value="<%=memberCount%>"
						readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type=text value="<%=id%>" readonly></td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td><input type=text value="<%=password%>"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type=text value="<%=age%>"></td>
				</tr>
				<tr>
					<th>연락처</th>
					<td><input type=text value="<%=phone%>"></td>
				</tr>
				<tr>
					<th>지역</th>
					<td><input type=text value="<%=region%>"></td>
				</tr>
				<tr>
					<th>취업분야</th>
					<td><input type=text value="<%=desired_field%>"></td>
				</tr>
				<tr>
					<th>공부기간</th>
					<td><input type=text value="<%=study_period%>"></td>
				</tr>
				<tr>
					<th>사진</th>
					<td><input type=file name=photo></td>
				</tr>
				<%
				if (login_grade.equals("A")) {
				%>
				<tr>
					<th>등급</th>
					<td><input type=text value="<%=grade%>"></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type=text value="<%=join_date%>"></td>
				</tr>
				<tr>
					<td colspan=3 align=center><input type=submit value="수정하기">
						<input type=button value="삭제하기"
						onClick="confirmDelete('<%=path%>/MemberController?sw=D&id=<%=id%>')">
					</td>
				</tr>
				<%
				} else if (login_grade.equals("C")) {
				%>
				<tr>
					<th>등급</th>
					<td><input type=text value="회원" readonly></td>
				</tr>
				<tr>
					<th>가입일자</th>
					<td><input type=text value="<%=join_date%>" readonly></td>
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