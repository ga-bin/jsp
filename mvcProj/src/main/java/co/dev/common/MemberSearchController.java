package co.dev.common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;
import oracle.jdbc.oracore.Util;

public class MemberSearchController implements Controller {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		String job = req.getParameter("job");

		if (id.isEmpty()) {
			req.setAttribute("error", "id를 입력하세요.");

			if (job.equals("search")) {
				Utils.forward(req, resp, "memberView/memberSearch.jsp");
			} else if (job.equals("update")) {
				Utils.forward(req, resp, "memberView/memberUpdate.jsp");
			} else if (job.equals("delete")) {
				Utils.forward(req, resp, "memberView/memberDelete.jsp");
			}
			return;
		}
		
		MemberService service = MemberService.getInstance();
		MemberVO vo = service.getMember(id);
		req.setAttribute("member", service.getMember(id));
		
		if(vo == null) {
			req.setAttribute("result", "필요한정보가 업습니다.");
		}
		
		
		if(job.equals("search")) {
		Utils.forward(req, resp, "memberResult/memberSearchOutput.jsp");
		} else if(job.equals("update")) {
			Utils.forward(req, resp, "memberView/memberUpdate.jsp");
		} else if(job.equals("delete")) {
			Utils.forward(req, resp, "memberView/memberDelete.jsp");
		}
	}

}
