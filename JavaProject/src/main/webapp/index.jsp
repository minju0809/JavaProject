<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Developer Project</title>
<link rel="stylesheet" type="text/css" href="./css/style.css">
</head>
<body>
	<header>
		<h2>개발자 플랫폼</h2>
	</header>
	<nav>
		<% 
		String grade = "A";
		
		if(grade.equals("C")) {
		%>
		<a href="./index.jsp">홈으로</a>
		<a href="">로그인</a>
		<% 
		} else if (grade.equals("B")) {
		%>
		
		<a href="./index.jsp">홈으로</a>
		<a href="">공부게시판</a>
		<a href="">아이디(로그아웃)</a>		
		<% 
		} else if (grade.equals("A")) {
		%>
		<a href="./index.jsp">홈으로</a>
		<a href="">회원목록</a>
		<a href="">공부게시판</a>
		<a href="">아이디(로그아웃)</a>
		<% } %>
	</nav>
	<section>
	
	</section>
	<footer></footer>
</body>
</html>