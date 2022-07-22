package com.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.EmpDAO;
import common.Employee;

@WebServlet("/EmpListServlet.do")
public class EmpListServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;Charset=UTF-8");
		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.empList();
		
		
		PrintWriter out = resp.getWriter();
		
		out.print("<table border='1'");
		out.print("<thead><tr><th>사원번호</th><th>성씨</th><th>이름</th><th>이메일</th><th>연봉</th><th>직무</th></tr></thead>");
		out.print("<tbody>");
		for(Employee emp : list) {
			out.print("<tr><td>"+emp.getFirstName() + "</td>"
				+ "<td>"+emp.getLastName() + "</td>"
				+ "<td>"+emp.getEmail() + "</td>"
				+ "<td>"+emp.getHireDate() + "</td>"
				+ "<td>"+emp.getSalary() + "</td>"
				+ "<td>"+emp.getJobId() + "</td>"
		);
		}
		out.print("</tbody>");
		out.print("</table>");
	}
}
