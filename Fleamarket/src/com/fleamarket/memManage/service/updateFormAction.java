package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class updateFormAction implements Action {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Bean bean = (Bean)request.getAttribute("bean");
		MemberService service = MemberService.getInstance();
		
		String email = request.getParameter("email");
		
		MemManageDAO dao = MemManageDAO.getInstance();
		MemManageDTO dto = dao.detailMember(email);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/memmanage/updateAction.do");
		forward.setRedirect(true);
//		forward.setPath("/jw/updateForm.jsp");
		request.setAttribute("forward", forward);
		
		System.out.println("업데이트폼으로 왔따.");
		return forward;
	}

}
