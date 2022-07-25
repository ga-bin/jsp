<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tst.common.BoardVO"%>
<%@ page import="com.tst.common.BoardDAO"%>
<%
request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>getBoard.jsp</title>
</head>
<body>

	<%
		int boardNo = Integer.parseInt(request.getParameter("id"));
		BoardDAO dao = new BoardDAO();
		BoardVO vo = dao.getBoard(boardNo);
		dao.updateBoard(boardNo);
	%>

	<table>
		<tr>
			<td>글번호</td>
			<td><%=vo.getBoardId()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=vo.getTitle()%></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%=vo.getContent()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=vo.getWriter()%></td>
		</tr>
		<tr>
			<td>작성일시</td>
			<td><%=vo.getCreateDate()%></td>
		</tr>
		<tr>
			<td>조회수</td>
			<td><%=vo.getView()%></td>
		</tr>
	
	
	</table>
	<button onclick="location.href='boardList.jsp'" >뒤로가기</button>
	


</body>
</html>