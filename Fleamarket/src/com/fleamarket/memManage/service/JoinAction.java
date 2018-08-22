package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberService service = MemberService.getInstance();
		
		System.out.println("메일이다:"+request.getParameter("email"));
		System.out.println("주소다" + request.getParameter("address"));
		System.out.println("주소다주소다" + request.getParameter("address2"));
		service.joinBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/memmanage/login.do");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
