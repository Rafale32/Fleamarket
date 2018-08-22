package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MemberService service = MemberService.getInstance();
		
//		System.out.println("메일이다:"+request.getParameter("email"));
//		System.out.println("주소다" + request.getParameter("address"));
//		System.out.println("주소다주소다" + request.getParameter("address2"));
		service.joinBoardService(request);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		
		forward.setConPath("/jw/login_container.jsp"); // 바꿔야 되는곳
		request.setAttribute("forward", forward);
		
		System.out.println("조인액션으로 왔다.");
		
		return forward;
		
	}

}
