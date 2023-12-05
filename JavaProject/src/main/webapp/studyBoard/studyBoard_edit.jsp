<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<%
StudyBoardVO m = (StudyBoardVO) request.getAttribute("m");

/* String study_comment_id = (String) request.getAttribute("study_comment_id"); */

List<StudyCommentBoardVO> commentList = (List<StudyCommentBoardVO>) request.getAttribute("commentList");
%>

<section>
	<div>
		<h2>게시글 상세 보기</h2>
		<form action="<%=path%>/StudyBoardController">
			<input type=hidden name=sw value="U"> 
			<table border=1 width=700px>
				<%
				int study_board_number = m.getStudy_board_number();
				String id = m.getId();
				String study_board_title = m.getStudy_board_title();
				String study_board_content = m.getStudy_board_content();
				%>
				<tr>
					<th>순번</th>
					<td><input type=text name="memberCount" value="<%=study_board_number%>"
						readonly></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type=text name="id" value="<%=id%>" readonly></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type=text name="phone" value="<%=study_board_title%>"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><input type=text name="region" value="<%=study_board_content%>"></td>
				</tr>
				<%
				if (login_grade.equals("A") || login_id.equals(id)) {
				%>
				<tr>
					<td colspan=3 align=center>
						<input type=submit value="수정하기">
						<input type=button value="삭제하기">
					</td>
				</tr>
				<%
				} 
				%>
			</table>
		</form>
		<form>
			<table border=1 width=700px>
				<tr>
					<td>
						<input type="text" name="study_comment_content" size=92>
						<input type="submit" value="입력">
					</td>
					
				</tr>
			</table>
		</form>
		<form name="commentForm" action="<%=path%>/StudyBoardController">
			<input type=hidden name="sw" value="CommentInsert">
			<input type=hidden name="id" value="id">
			<input type=hidden name="study_comment_id" value="study_comment_id">
		
			<table border=1 width=700px>
				<tr>
					<th>번호</th>
					<th>내용</th>
					<th>작성자</th>
				</tr>
				<%
				for (StudyCommentBoardVO cvo : commentList) { 
					int study_comment_board_number = cvo.getStudy_comment_board_number();
					String study_comment_id = cvo.getStudy_comment_id();
					String study_comment_content = cvo.getStudy_comment_content();
				%>
				<tr>
					<td><%=study_comment_board_number %></td>
					<td><%=study_comment_id %></td>
					<td><%=study_comment_content %></td>
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