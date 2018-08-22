package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class updateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("업데이트 액션입니당~~~~~~");
		
		//Bean bean = (Bean)request.getAttribute("bean");
		
		System.out.println("업데이2니당~~~~~~222222");
		MemberService service = MemberService.getInstance();
		System.out.println("업데이2니당~~33322");
		
		MemManageDTO memManageDTO = new MemManageDTO();
		MemManageDAO dao = MemManageDAO.getInstance();
		
		String email = request.getParameter("email");
		memManageDTO = dao.detailMember(email);
		
		
		//bean.setMemManageDTO(memManageDTO);
		
		//System.out.println("업데이트 액션입니당~~~~~~" + bean.getMemManageDTO().toString());

	
		
		//service.updateMemberService(request);
		
		System.out.println(email +"너는 이메일이다");
		
		
		//int dto = dao.updateMember(email);

		//bean.setMemManageDTO(dto);
		//request.setAttribute("bean", bean);
		

		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/memmanage/updateAction.do");
		forward.setRedirect(true);
		forward.setConPath("/jw/detailForm.jsp");
		request.setAttribute("forward", forward);
		
		System.out.println(request.getParameter("email")+"이름이 왔음요");
		
		return forward;
		
	}

}
