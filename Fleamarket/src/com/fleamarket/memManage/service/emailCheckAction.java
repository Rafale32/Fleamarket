package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDTO;
import com.sun.org.apache.bcel.internal.generic.NEW;

public class emailCheckAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemberService service = MemberService.getInstance();
		MemManageDTO memmanageDTO = new MemManageDTO();
		
		String email = request.getParameter("email");
	
	//	int result = service.idCheckService(request);
		
		//email = service.idCheckService(request); //id 중복체크 re값은  0 일때 중복 아님 = 가입 되야됨 -1일때 중복임 가입 되면 안됨
		
		ActionForward forward = new ActionForward();
		
		//forward.setPath("/template.jsp");
		forward.setRedirect(true);
		forward.setConPath("/Fleamarket/memmange/emailCheckAction.do");
		//forward.setConPath("./jw/emailCheck.jsp"); // 바꿔야 되는곳
		//request.setAttribute("forward", forward);
		
		System.out.println("조인액션으로 왔다.");
		
		return forward;
	}

}
