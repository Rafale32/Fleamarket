package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

public class detailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		
		String email = request.getParameter("email");
		
		System.out.println(request.getParameter(email + "dhkdlddsldflksdjf"));
		
		MemManageDAO dao = MemManageDAO.getInstance();
		MemManageDTO dto = dao.detailMember(email);
		
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/memmanage/detailAction.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
