<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>삭제검색(memberDelete.jsp)</title>
</head>
<body>
	<h3>삭제검색</h3>
	${error } ${request.servletContext.contextPath }
	<form action="${pageContext.request.contextPath }/memberSearch.do"
		method="post">
		아이디: <input type="text" name="id" /> 
		<input type="hidden" name="job"
			value="delete" /> 
			<input type="submit" value="조회" />
	</form>

	<c:set var="vo" value="${member }"></c:set>
	<c:choose>
		<c:when test="${!empty vo }">
			<form action="${pageContext.request.contextPath }/memberDelete.do"
				method="post">
				아이디: <input type="text" name="id" value="${vo.id }" readonly><br>
				비밀번호: <input type="text" name="passwd" value="${vo.passwd }"><br>
				<input type="submit" value="삭제" />
			</form>
		</c:when>
		<c:otherwise>
			<p>${result }</p>	
		</c:otherwise>
	</c:choose>

</body>
</html>