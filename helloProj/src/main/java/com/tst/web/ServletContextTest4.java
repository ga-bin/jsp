package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

@WebServlet("/context4")
public class ServletContextTest4 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=utf-8");
		// 서블릿 컨텍스트를 받아옴
		ServletContext sc = this.getServletContext();

		// getAttribute 리턴값이 object 타입이라서(어떤 타입의 객체가 들어올지 모르기때문에)
		// ShareObject타입으로 변환해줌
		ShareObject obj1 = (ShareObject) sc.getAttribute("data");
		resp.getWriter().println("count: " + obj1.getCount() + ", str: " + obj1.getStr());

		// servletcontext3을 먼저 실행해야 data2객체가 servletcontext에 저장됨
		// data2라는 객체가 없으면 null값이 반환
		ShareObject obj2 = (ShareObject) sc.getAttribute("data2");
		resp.getWriter().println("count: " + obj2.getCount() + ", str: " + obj2.getStr());

	}

}
