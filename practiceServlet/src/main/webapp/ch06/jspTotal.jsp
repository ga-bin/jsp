<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>
1. JSP �ּ�
<!-- HTML�ּ� : ȭ�鿡�� �� ���̰� �ҽ� ���⿡�� ���� -->
<%--JSP�ּ� : ȭ��� �ҽ� ���⿡�� ������ ���� --%>
</h3>

<%!
String[] members = {"��浿", "ȫ�浿", "����", "�ڻ��"};
int num1 = 10;

int calc(int num2) {
	return num1 + num2;
}
%>

<h3>
2. calc(10) �޼��� ���� ���:
<%=calc(10)%>
</h3>
<hr>

<h3>3. include: hello.jsp</h3>


<h3>4. ��ũ��Ʈ(�迭 ������ ���)</h3>
<ul>
	<%
	for(String name : members) {
		%>
		<li><%=name %></li>
	<%
	}
	%>
</ul>
</body>
</html>