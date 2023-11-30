<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");

int memberCount = (int) request.getAttribute("memberCount");
%>

<section>
	<form name="f1" method="post" enctype="multipart/form-data"
		action="<%=path%>/MemberController?sw=I">
		<table border=1>
			<tr>
				<th>번호</th>
				<td><input type="text" name="memberCount"
					value="<%=memberCount%>" readonly></td>
			</tr>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" placeholder="(필수)"></td>
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
				<td><label for="region">선택:</label> <select name="region"
					id="region">
						<option value="seoul">서울</option>
						<option value="busan">부산</option>
						<option value="incheon">인천</option>
						<option value="daegu">대구</option>
						<option value="gwangju">광주</option>
						<option value="daejeon">대전</option>
						<option value="ulsan">울산</option>
						<option value="gyeonggi">경기</option>
						<option value="gangwon">강원</option>
						<option value="chungbuk">충청북도</option>
						<option value="chungnam">충청남도</option>
						<option value="jeonbuk">전라북도</option>
						<option value="jeonnam">전라남도</option>
						<option value="gyeongbuk">경상북도</option>
						<option value="gyeongnam">경상남도</option>
						<option value="jeju">제주</option>
				</select> (필수)</td>
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