<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
		<%
		int boardNo = Integer.parseInt(request.getParameter("bno"));
		%>
	<script>
		let remove = confirm("정말 삭제하시겠습니까?");
		if(remove) {
			location.href = "delete.jsp?bno=<%=boardNo%>";
		} else {
			location.href = "boardList.jsp";
		}
	</script>
</body>
</html>