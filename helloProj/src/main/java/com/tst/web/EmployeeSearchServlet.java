package com.tst.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.EmpDAO;
import com.tst.common.Employee;

// emp.html에서 first_name을 받아와서
// list에 담고
// list를 empResult에 넘겨줌
// dispatch forward방식 사용

@WebServlet("/empSearch")
public class EmployeeSearchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String fName = req.getParameter("first_name");

		EmpDAO dao = new EmpDAO();
		List<Employee> list = dao.getEmpInfo(fName);
		req.setAttribute("data", list);

		//RequestDispatcher rd = req.getRequestDispatcher("empResult");
		RequestDispatcher rd = req.getRequestDispatcher("empResult.jsp");
		rd.forward(req, resp);

	}

}
