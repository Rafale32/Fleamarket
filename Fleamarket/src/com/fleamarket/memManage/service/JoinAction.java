package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberService service = MemberService.getInstance();
		
		System.out.println("aaaaaaaaaaaaaaaaaaaa:"+request.getParameter("email"));
		service.joinBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/memmanage/login.do");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
