package com.tst.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//---------HttpSession------------
//세션은 클라이언트 당 1개씩 만들어짐
//세션객체에 값을 넣으면 동일한 유저만 값을 공유
//로그인, 로그아웃 기능에 사용

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		HttpSession session = null;
		String param = req.getParameter("p");
		String msg = null;

		// http://localhost:8088/helloProj/sessionTest?p=create

		// httpsession 생성, 변경, 삭제
		if (param.equals("create")) {
			// 생성된 세션값이 있으면 세션반환, 없으면 새로 생성해서 반환
			session = req.getSession();
			if (session.isNew()) {
				// 새로만들어진 세션일 경우
				msg = "새로운 세션 객체 생성";
			} else {
				msg = "기존 세션 객체 반환";
			}
		} else if (param.equals("delete")) {
			// 세션이 있으면 세션반환, 없으면 null
			// 세션이 없을때 새로 생성하려면 매개변수 true나 비워둠
			// 세션이 없을때 null을 반환하려면 false
			session = req.getSession(false);
			if (session != null) {
				// 세션삭제.
				session.invalidate();
				msg = "세션 객체 삭제";
			} else {
				msg = "삭제할 세션 객체 없음";
			}
		} else if (param.equals("add")) {
			// 세션 객체에 속성추가
			// key: msg, value: "메세지 추가함"
			session = req.getSession();
			session.setAttribute("msg", "메세지 추가함");
			msg = "세션 객체에 속성 지정함";
		} else if (param.equals("get")) {
			session = req.getSession(false);
			if (session != null) {
				// 세션객체의 속성값 가져옴
				String str = (String) session.getAttribute("msg");
				msg = str;
			} else {
				msg = "데이터를 추출할 세션 없음";
			}
		} else if (param.equals("remove")) {
			session = req.getSession(false);
			if (session != null) {
				session.removeAttribute("msg");
				msg = "세션 객체의 속성을 삭제";
			} else {
				msg = "속성을 제거할 세션 객체 없음";
			}

		}

		resp.getWriter().print("처리결과: " + msg);
	}

}
