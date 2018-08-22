package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

public class detailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		Bean bean = (Bean)request.getAttribute("bean");
		MemberService service = MemberService.getInstance();
		
		String email = request.getParameter("email");
		
		MemManageDAO dao = MemManageDAO.getInstance();
		MemManageDTO dto = dao.detailMember(email);
		
		//System.out.println(request.getParameter("email") + "이메일이이이이이이");
		
	//	System.out.println(dto.getEmail() +"kfjsalkdfjlaksdjflksdfj");
		
		bean.setMemManageDTO(dto);
		request.setAttribute("dto", dto);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./jw/detailForm.jsp");
		request.setAttribute("forward", forward);
		
		return forward;
		
	}

}
