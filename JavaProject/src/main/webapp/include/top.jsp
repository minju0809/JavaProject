<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="pkg.member.*" %>
<%@ page import="java.util.*" %>

<%
String path = request.getContextPath();

String login_id = (String) session.getAttribute("id"); 
String login_grade = (String) session.getAttribute("grade"); 
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Developer Project</title>
<link rel="stylesheet" type="text/css" href="<%=path %>/css/style.css">
</head>
<body>
	<header>
		<h2>개발자 플랫폼</h2>
	</header>
	<nav>
		<% 
		if(login_id == null) {
		%>
		<a href="<%=path %>/index.jsp">홈으로</a>
		<a href="<%=path %>/login/login.jsp">로그인</a>
		<a href="<%=path %>/MemberController?sw=F">회원가입</a>
		<% 
		} else {
			if (login_grade.equals("A")) {
		%>
			<a href="<%=path %>/index.jsp">홈으로</a>
			<a href="<%=path %>/MemberController?sw=F">회원등록</a>
			<a href="<%=path %>/MemberController?sw=S">회원목록</a>
			<a href="">공부게시판</a>
			<a href="<%=path%>/LoginController?sw=logout"><%=login_id %>(logout)</a>
		<% 
			} else if (login_grade.equals("C")) {
		%>
			<a href="<%=path %>/index.jsp">홈으로</a>
			<a href="">공부게시판</a>
			<a href="<%=path%>/LoginController?sw=logout"><%=login_id %>(logout)</a>	
		<%
			} 
		}
		
		%>
	</nav>