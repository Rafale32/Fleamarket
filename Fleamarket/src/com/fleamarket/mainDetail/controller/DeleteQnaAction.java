package com.fleamarket.mainDetail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.mainDetail.service.MainDetailService;

public class DeleteQnaAction implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    MainDetailService service = MainDetailService.getInstance();
    service.deleteQna(request);
    
    String itemboard_no =  (String) request.getParameter("itemboard_no");
    
    
    ActionForward forward = new ActionForward();
    forward.setPath("detailAction.do?itemboard_no="+itemboard_no); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
    forward.setRedirect(true); //완전 새로운 페이지로 갈거냐 안갈거냐
    forward.setConPath("./jy/detailProduct.jsp?itemboard_no="); //원하는 container 파일 경로
    
    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
    
    return forward;
  }

}
