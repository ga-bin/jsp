<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>검색결과</h3>
	<c:choose >
		<c:when test="${!empty member }">
			<p>${member.id } / ${member.name } / ${member.passwd } / ${member.mail }</p>
		</c:when>
		<c:otherwise>
			<p>검색결과없음</p>
		</c:otherwise>
	</c:choose>
	<jsp:include page="./home.jsp"></jsp:include>
</body>
</html>