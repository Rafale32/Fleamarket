package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class JoinFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("/jw/joinForm.jsp");
		request.setAttribute("forward", forward);
	
		//forward.setPath("/Fleamarket/memmanage/joinform.do");
		
		System.out.println("조인폼으로 왔다.");
		return forward;
	}

}
