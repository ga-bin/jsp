package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 요청페이지 site.html -> sendRedirect(서블릿) -> 페이지 재지정

@WebServlet("/sendRedirect")
public class SendRedirectServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String param = req.getParameter("site");

		// sendRedirect -> 요청을 받아서 다른 페이지로 이동
		if (param.equals("naver")) {
			resp.sendRedirect("https://www.naver.com");
		} else if (param.equals("daum")) {
			resp.sendRedirect("https://www.daum.net");
		} else if (param.equals("google")) {
			resp.sendRedirect("https://www.google.com");
		}

	}
}
