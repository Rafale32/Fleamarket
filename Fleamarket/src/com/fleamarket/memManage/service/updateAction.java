package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class updateAction implements Action {

	@Override
	
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		System.out.println("액션 안으로 왔습니다.");
		
		String email = request.getParameter("email");
				
		MemManageDTO memManageDTO =  new MemManageDTO();
		Bean bean = (Bean)request.getAttribute("bean");
		MemberService service = MemberService.getInstance();
		
		System.out.println("그냥 확인용");
		
		System.out.println("액션 안으로 왔습니다.5555" + memManageDTO.toString());
		
		MemManageDAO dao = MemManageDAO.getInstance();
		
		service.updateMemberService(request);
		
		bean.setMemManageDTO(memManageDTO);
		
		System.out.println("액션 안으로 왔습니다.6666");
		
		
		request.setAttribute("bean", bean);
		
		ActionForward forward = new ActionForward();
//		forward.setPath("/template.jsp");
		forward.setRedirect(true);
		forward.setPath("/Fleamarket/memmanage/detailAction.do?email="+email);
		request.setAttribute("forward", forward);
		
		System.out.println("업데이트폼으로 왔따.");
		return forward;
	}

}