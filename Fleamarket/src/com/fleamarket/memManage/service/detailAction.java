package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.sun.xml.internal.ws.message.EmptyMessageImpl;

public class detailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
		forward.setRedirect(false); //완전 새로운 페이지로 갈거냐 안갈거냐
		//원하는 container 파일 경로
		forward.setConPath("./jw/detailForm.jsp");
		request.setAttribute("forward", forward);
		
		String email = request.getParameter("email");
		
		HttpSession session = request.getSession();
		
		MemManageDAO dao = MemManageDAO.getInstance();
		MemManageDTO dto = dao.detailMember(email);
				
		System.out.println(request.getParameter(email + "dhkdlddsldflksdjf"));
		

		
		return forward;
	}

}
