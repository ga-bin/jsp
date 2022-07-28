package com.tst.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 


@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();

		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");

		if (id.isEmpty() || pwd.isEmpty()) {
			out.print("ID와 비밀번호를 입력해주세요");
			return;
		}
		HttpSession session = req.getSession();
		// 세션이 새로 만들어졌거나 세션의 id값이 없을 때
		if (session.isNew() || session.getAttribute("id") == null) {
			session.setAttribute("id", id);
			out.print("로그인 성공");
			out.print(session.getAttribute("id"));
		} else {
			out.print("로그인 중");
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		// 세션이 존재하고 id 값이 존재하면 세션삭제
		if (session != null && session.getAttribute("id") != null) {
			session.invalidate();
			out.print("로그아웃함");
		} else {
			out.print("로그인 상태가 아닙니다");
		}

	}
}
