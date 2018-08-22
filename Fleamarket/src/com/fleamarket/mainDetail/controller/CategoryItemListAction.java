package com.fleamarket.mainDetail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.mainDetail.service.MainDetailService;

public class CategoryItemListAction implements Action{

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    MainDetailService service = MainDetailService.getInstance();
    
    Bean bean = (Bean) request.getAttribute("bean");
    bean.setCategoryItemList(service.categoryItemList(Integer.parseInt(request.getParameter("category_no"))));
    ActionForward forward = new ActionForward();
    
    forward.setPath("/template.jsp"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
    forward.setRedirect(false); //완전 새로운 페이지로 갈거냐 안갈거냐
    forward.setConPath("./jy/categoryItemList.jsp"); //원하는 container 파일 경로
    
    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
    
    return forward;
  }

}
