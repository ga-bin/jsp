package com.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addMember")
public class AddMemberServ extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 사용자 : user_name=user2&user_pass=1234&role=1
		String name = req.getParameter("user_name");
		String pass = req.getParameter("user_pass");
		String role = req.getParameter("role");
		
		// get:수정, post:입력,
		// db입력
		resp.setContentType("text/html;Charset=UTF-8");
		PrintWriter out = resp.getWriter();

		EmpDAO dao = new EmpDAO();
		int r;
		if(req.getMethod().toUpperCase().equals("GET")) {
			r = dao.updateMember(name, pass, role);
			if(r<1) {
				 out.println("<script>alert('수정실패!'); location.href='/helloWorld1/html/get.html';</script>");
			}  else {
				out.println("<script>alert('수정성공!'); location.href='/helloWorld1/html/get.html';</script>");
			} 
		} else {
			r = dao.insertMember(name, pass, role);
			if(r<1) {
				 out.println("<script>alert('등록실패!'); location.href='/helloWorld1/html/get.html';</script>");
			}  else {
				out.println("<script>alert('등록성공!'); location.href='/helloWorld1/html/get.html';</script>");
			} 
		}
		
		
		// DB입력
		
		resp.getWriter().print("completed");
	}
}
