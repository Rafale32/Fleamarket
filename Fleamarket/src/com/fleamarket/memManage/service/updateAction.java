package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class updateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberService service = MemberService.getInstance();
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./jw/updateForm.jsp");
		request.setAttribute("forward", forward);
		
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();		
		
		System.out.println("업데이트 이름이다." +request.getParameter("name"));
		
		service.updateMemberService(request);
		
		return forward;
	}

}
