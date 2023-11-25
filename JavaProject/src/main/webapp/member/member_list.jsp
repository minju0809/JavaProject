<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ include file="../include/top.jsp" %>

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
				<th>성명</th>
				<th>비밀번호</th>
				<th>나이</th>
				<th>전화번호</th>
				<th>지역</th>
				<th>취업분야</th>
				<th>공부기간</th>
				<th>등급</th>
				<th>가입일자</th>
			</tr>
			<tr>
			<% 
			int count = 0;
			for (MemberVO vo : li) { 
				String photo = vo.getPhoto();
				String id = vo.getId();
				String password = vo.getPassword();
				String age = vo.getAge();
				String phone = vo.getPhone();
				String area = vo.getArea();
				String desired_field = vo.getDesired_field();
				String study_period = vo.getStudy_period();
				String grade2 = vo.getGrade();
				String join_date = vo.getJoin_date();
			%>
				<td><%=count + 1 %></td>
				<td><%=photo %></td>
				<td><%=id %></td>
				<td><%=password %></td>
				<td><%=age %></td>
				<td><%=phone %></td>
				<td><%=area %></td>
				<td><%=desired_field %></td>
				<td><%=study_period %></td>
				<td><%=grade %></td>
				<td><%=join_date %></td>
			<% } %>
			</tr>
		</table>
	</div>
	<div>
		<a href="./index.jsp">Home</a>
	</div>

</section>
</body>
</html>