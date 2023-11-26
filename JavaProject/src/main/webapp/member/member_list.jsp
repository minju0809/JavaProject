<%@ page language="java"
    pageEncoding="UTF-8"%>
    
<%@ include file="/include/top.jsp" %>

<% 
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");
%>
<section>
	<div>
		<h2>회원목록</h2>
		<table border=1>
			<tr>
				<th>순번</th>
				<th>이미지</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>지역</th>
				<th>취업분야</th>
				<th>공부기간</th>
				<th>등급</th>
				<th>가입일자</th>
			</tr>
			<% 
			for (MemberVO vo : li) { 
				int memberCount = vo.getMemberCount();
				String photo = vo.getPhoto();
				String id = vo.getId();
				String password = vo.getPassword();
				String age = vo.getAge();
				String phone = vo.getPhone();
				String region = vo.getRegion();
				String desired_field = vo.getDesired_field();
				String study_period = vo.getStudy_period();
				String grade = vo.getGrade();
				String join_date = vo.getJoin_date().substring(0, 19);
			%>
			<tr>
				<td><%=memberCount %></td>
				<td><img src="<%=path %>/files/<%=photo %>" width=50 height=50></td>
				<td><%=id %></td>
				<td><%=password %></td>
				<td><%=age %></td>
				<td><%=phone %></td>
				<td><%=region %></td>
				<td><%=desired_field %></td>
				<td><%=study_period %></td>
				<td><%=grade %></td>
				<td><%=join_date %></td>
			</tr>
			<% } %>
		</table>
	</div>
</section>

<%@ include file="/include/bottom.jsp" %>