package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class deleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Bean bean = (Bean)request.getAttribute("bean"); 
		MemberService service = MemberService.getInstance();
		
		System.out.println(request.getParameter("email") +"@@@@@@@@@@@@");
		
		String email = request.getParameter("email");
		
		System.out.println(request.getParameter("email") +"!!!!!!!!!!!!!");
		
		MemManageDAO dao = MemManageDAO.getInstance();
		int dto = dao.deleteMember(email);
		
		request.setAttribute("email", email); 
		
		System.out.println(request.getParameter("email") +"123123123123123");
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./jw/deleteForm.jsp");
		request.setAttribute("forward", forward);
		
		
		System.out.println(request.getParameter("email") +"123123123123123");
		System.out.println("회원 탈퇴");
		
		return forward;
	}

}
