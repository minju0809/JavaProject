<%@ page language="java" pageEncoding="UTF-8"%>

<%@ include file="/include/top.jsp"%>

<section>
	<br>
	<%
	session.invalidate();
	response.sendRedirect(path + "/index.jsp");
	%>
	<br>
</section>

<%@ include file="/include/bottom.jsp"%>