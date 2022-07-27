package co.dev.common;

import java.io.IOException;
import java.security.spec.EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.tribes.membership.Membership;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class FrontController extends HttpServlet {
	String enc;
	Map<String, Controller> mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		enc = config.getInitParameter("charset");
		
		mappings = new HashMap<>();
		mappings.put("/memberInsert.do", new MemberInsertController());
		mappings.put("/memberList.do", new MemberListController());
		mappings.put("/memberSearch.do", new MemberSearchController());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding(enc);
		
		String uri = req.getRequestURI();
		System.out.println(uri);
		String contextPath = req.getContextPath();
		System.out.println(contextPath);
		String path = uri.substring(contextPath.length());
		System.out.println(path);
		
		Controller cntrl = mappings.get(path);
		cntrl.execute(req, resp);
		
		
	}
	
}
