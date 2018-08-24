package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// 가입 확인 이메일 보내는 메소드 입니당
  /*      SendTest2 send = new SendTest2();
        String recieverEmail = request.getParameter("email");
        System.out.println(recieverEmail);
        send.a(recieverEmail);
        //
		*/
		
		MemberService service = MemberService.getInstance();
		
		service.idCheckService(request);
		service.joinBoardService(request); 	//회원생성
		service.joinStoreService(request);	//스토어 생성
		service.listStoreService(request); 	//중복 스토어명 찾기		
	
		ActionForward forward = new ActionForward();
		
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("/jw/login_container.jsp"); // 바꿔야 되는곳
		request.setAttribute("forward", forward);
		
		System.out.println("조인액션으로 왔다.");
		
		return forward;
		
	}

}
