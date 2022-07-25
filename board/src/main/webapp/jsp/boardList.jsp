<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.tst.common.BoardVO"%>
<%@ page import="com.tst.common.BoardDAO"%>
<%@ page import="java.util.*"%>
<%
	request.setCharacterEncoding("UTF-8");
%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<table border="1">
		<thead>
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>작성일자</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<%
				BoardDAO dao = new BoardDAO();
				List<BoardVO> list = dao.boardList();
				for (BoardVO vo : list) {
			%>
			<tr>
				<td><a href="getBoard.jsp?id=<%=vo.getBoardId()%>"><%=vo.getBoardId()%></a></td>
				<td><%=vo.getTitle()%></td>
				<td><%=vo.getWriter()%></td>
				<td><%=vo.getCreateDate()%></td>
				<td><%=vo.getView()%></td>
			</tr>

			<%
				}
			%>
		</tbody>
	</table>
	
	

</body>
</html>