package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Bean bean =(Bean)request.getAttribute("bean");
		MemberService service = MemberService.getInstance();
		
		System.out.println("야야야야야야1");

		String email = request.getParameter("email");
		
		System.out.println(email +"너는 이메일이다");
		
		
		MemManageDAO dao = MemManageDAO.getInstance();
		int dto = dao.updateMember(dto);
		
		service.updateMemberService(request);
		System.out.println("야야야야야야3");
		
	//	bean.setMemManageDTO(dto);
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./jw/updateForm.jsp");
		request.setAttribute("forward", forward);
		
		System.out.println(request.getParameter("name")+"이름이 왔음요");
		
		return forward;
		
	}

}
