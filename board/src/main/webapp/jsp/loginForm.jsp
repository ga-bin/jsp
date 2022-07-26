<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>loginForm.jsp</title>
</head>
<body>
	<%
	//	String msg = (String) request.getAttribute("msg");
	//	if (msg != null) {
	//		out.print("<p>" + msg + "</p>");
	//	}
	%>
	<c:set var="msg" value="${msg }"></c:set>
	<c:if test="${!empty msg }">
		<c:out value="'<p>' + msg + '</p>'"></c:out>
	</c:if>
	
	
	<form action="login.jsp" method="post">
		ID: <input type="text" name="id"><br>
		PW: <input type="password" name="pwd"><br>
		<input type="submit" value="로그인">
	</form>
</body>
</html>