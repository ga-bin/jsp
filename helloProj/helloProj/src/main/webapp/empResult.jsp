<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ page import="java.util.*"%>
<%@ page import="com.tst.common.Employee"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>empResult.jsp</title>
</head>
<body>
	<table border="1">
		<thead>
			<tr>
				<th>사원번호</th>
				<th>이름</th>
				<th>이메일</th>
				<th>급여</th>
			</tr>
		</thead>
		<tbody>

			<!-- %안에 자바 소스코드 입력 -->
			<%
			request.getParameter("first_name");
			List<Employee> list = (List<Employee>) request.getAttribute("data");
			for (Employee emp : list) {
			%>
			<tr>
				<!-- %=으로 표현식 입력 -->
				<td><%=emp.getEmployeeId()%></td>
				<td><%=emp.getFirstName()%></td>
				<td><%=emp.getEmail()%></td>
				<td><%=emp.getSalary()%></td>
			</tr>
			<%
			//	out.print("사원번호: " + emp.getEmployeeId() + ", 사원이름: " + emp.getFirstName() + ", 이메일: " + emp.getEmail() + ", 직무: "
			//			+ emp.getJobId() + "<br>");
			}
			%>

		</tbody>

	</table>
</body>
</html>