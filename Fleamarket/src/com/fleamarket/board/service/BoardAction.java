package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;


public class BoardAction implements Action {
	//리다이렉트 할때는 무조건  가능페이지.do 로 해서 그 쪽페이지로 아예 가버릴때 사용 
		//false 사용할때는 .jsp 를 사용 해서 보내는것임
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
		forward.setRedirect(false); //완전 새로운 페이지로 갈거냐 안갈거냐
		forward.setConPath("./jy/main_container.jsp"); //원하는 container 파일 경로
		
		request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
		
		System.out.println("메인 액션 들어옴?");
		
		return forward;
	}

}
