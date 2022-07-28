package co.dev.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;

public class MemberDeleteController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String pw = req.getParameter("passwd");
		
		MemberService service = MemberService.getInstance();
		service.deleteMember(id);
		
		req.setAttribute("id", id);
		Utils.forward(req, resp, "memberResult/memberDeleteOutput.jsp");
		
	}

}
