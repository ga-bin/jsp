1<%@page import="javax.tools.DocumentationTool.Location"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.tst.common.BoardDAO"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>deleteForm.jsp</title>
</head>
<body>
	<%
	int bno = Integer.parseInt(request.getParameter("bno"));
	
	BoardDAO dao = new BoardDAO();
	dao.deleteBoard(bno);
	
	response.sendRedirect("boardList.jsp");
	%>
	

</body>
</html>


