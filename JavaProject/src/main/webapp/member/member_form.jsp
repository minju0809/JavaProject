<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>
<%
List<MemberVO> li = (List<MemberVO>) request.getAttribute("li");

int memberCount = (int) request.getAttribute("memberCount");
%>

<%-- <script>
    function checkDuplicateId() {
        var inputId = document.getElementById("id").value;

        // AJAX 요청을 생성합니다.
        var xhr = new XMLHttpRequest();

        // 요청이 완료되었을 때 처리할 콜백 함수를 정의합니다.
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // 서버로부터 받은 JSON 형식의 응답을 해석합니다.
                    var response = JSON.parse(xhr.responseText);
                    console.log('Response:', response);

                    // isDuplicate 값에 따라 처리를 분기합니다.
                    if (response.isDuplicate) {
                        // 중복된 경우 경고창을 띄우고 포커스를 아이디 입력 필드로 이동합니다.
                        alert("@@@이미 있는 아이디입니다.");
                        document.getElementById("id").focus();
                    } else {
                        // 중복이 아닌 경우 다음 로직을 진행하거나 그냥 넘어갑니다.
                        // 예를 들어, 다음 필드로 포커스를 이동하거나 특정 동작을 수행할 수 있습니다.
                    }
                } else {
                    console.error("서버 오류 발생");
                }
            }
        };

        // 서버로 보낼 데이터를 설정하고, 서버에 POST 요청을 보냅니다.
        xhr.open("POST", "<%=path%>/MemberController?sw=I&id=" + encodeURIComponent(inputId));
        xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
        xhr.send();
    }
</script> --%>
    
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
				<td>
				    <label for="region">선택:</label>
				    <select name="region" id="region">
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
				    </select> (필수)
				</td>
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