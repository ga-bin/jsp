package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tst.common.ShareObject;

// ---------servletContext------------
// 여기서 값을 지정해서 servlet4번으로 넘겨줄거임
// setAttribute() 사용
// 웹 어플리케이션 단위로 공유함
// 정보를 넘겨주고 싶을때 사용
// 어떤사용자가 접속하든 같은 값을 공유


@WebServlet("/context3")
public class ServletContextTest3 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		// ServletContext 호출
		ServletContext sc = this.getServletContext();
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("객체 공유 테스트");

		ShareObject obj2 = new ShareObject();
		obj2.setCount(200);
		obj2.setStr("객체 공유 테스트22");

		// 서블릿 컨텍스트에 data라는 이름으로 obj1을 저장
		sc.setAttribute("data", obj1);
		sc.setAttribute("data2", obj2);

		resp.getWriter().print("ServletContext object add.");

	}

}
