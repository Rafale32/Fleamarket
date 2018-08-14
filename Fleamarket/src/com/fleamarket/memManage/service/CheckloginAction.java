package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.mainDetail.model.MemberDTO;

public class CheckloginAction implements Action {
	//리다이렉트 할때는 무조건  가능페이지.do 로 해서 그 쪽페이지로 아예 가버릴때 사용 
	//false 사용할때는 .jsp 를 사용 해서 보내는것임 
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id =  "1111";
		String pw =  "1111";
		String nickName = "젠장조낸 어렵내";
		
		ActionForward forward = new ActionForward();
		
		//임시 아이디 확인해서 로긴
		if(id.equals(request.getParameter("id")) && pw.equals(request.getParameter("pw"))){
			MemberDTO member = new MemberDTO(); //아디 비번 맞으면 세션에 아이디와 닉네임 member 에 담아서 세션에 저장
			HttpSession session = request.getSession();
			member.setId(id);
			member.setNickname(nickName);
			session.setAttribute("member", member);
		}
		
		
		forward.setPath("/Fleamarket/maindetail/main.do"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
		forward.setRedirect(true); //완전 새로운 페이지로 갈거냐 안갈거냐
		forward.setConPath("./jw/main_container.jsp"); //원하는 container 파일 경로
		
		request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
		
		System.out.println("체크 로그인 액션 들어옴");
		
		
		
		return forward;
	}

}