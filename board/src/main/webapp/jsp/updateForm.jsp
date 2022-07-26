<%@page import="com.tst.common.BoardDAO"%>
<%@page import="com.tst.common.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updateForm.jsp</title>
</head>
<body>
	<%
		String bno = request.getParameter("bno");
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(Integer.parseInt(bno));
	%>
	
	<table border="1">
		<tr><th>글번호</th><td><input type="text" name="bid" value="<%=vo.getBoardId() %>" readonly></td><tr>
		<tr><th>제목</th><td><input type="text" name="btitle" value="<%=vo.getTitle() %>"></td><tr>
		<tr><th>내용</th><td><input type="text" name="bcontent" value="<%=vo.getContent() %>"></td><tr>
		<tr><td><input type="submit" value="수정"></td>
	</table>
	</form>
	
</body>
</html>