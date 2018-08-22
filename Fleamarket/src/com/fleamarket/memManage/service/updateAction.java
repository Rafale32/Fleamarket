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
		MemManageDTO dto =  new MemManageDTO();
		MemberService service = MemberService.getInstance();

		MemManageDAO dao = MemManageDAO.getInstance();
		System.out.println("액션 안으로 왔습니다.5555" + dto.toString());
		
		service.updateMemberService(request);
		
		dao.updateMember(dto);
		System.out.println("액션 안으로 왔습니다.6666");
		System.out.println("그냥 확인용");
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./jw/updateForm.jsp");
		request.setAttribute("forward", forward);
		
		System.out.println("업데이트폼으로 왔따.");
		return forward;
	}

}