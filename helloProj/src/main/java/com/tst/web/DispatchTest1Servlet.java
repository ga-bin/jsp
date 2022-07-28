package com.tst.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// dispatch를 통한 재지정 
// -forward방식-
// 요청을 들고와서 forward 페이지로 보내줌
// 클라이언트에 응답을 forward 페이지가 보냄

//-include방식-
// 클라이언트가 요청 -> 요청받은 페이지가 -> include 페이지로 보내줌
// include 페이지가 응답 -> 요청받은 페이지 -> 클라이언트
// 그래서 Dispatch page 1, Dispatch page 2 다 출력

@WebServlet("/dispatch1")
public class DispatchTest1Servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");

		resp.getWriter().print("<h2>Dispatch page 1</h2>");

		String title = req.getParameter("title");
		String author = req.getParameter("author");
		String publish = req.getParameter("publish");

		// 요청정보에 parameter 지정해서 dispatch2에 전송
		req.setAttribute("param1", title);
		req.setAttribute("param2", author);
		req.setAttribute("param3", publish);

		RequestDispatcher rd = this.getServletContext().getRequestDispatcher("/dispatch2");
		rd.include(req, resp);
		//rd.forward(req, resp);

	}
}
