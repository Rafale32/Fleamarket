package com.fleamarket.mainDetail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.mainDetail.model.ItemDetailDTO;
import com.fleamarket.mainDetail.model.MainDetailDAO;
import com.fleamarket.mainDetail.service.MainDetailService;

public class DetailAction implements Action{
  
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
    String str = request.getParameter("itemboard_no");
    int itemboard_no = 0;
    
    if(str != null){
      itemboard_no = Integer.parseInt(str);
    }
    
    Bean bean = (Bean) request.getAttribute("bean");
    MainDetailService service = MainDetailService.getInstance();
    //카테고리목록
    bean.setCategoryList(service.categoryList());
    //상품상제정보
    bean.setItemDetail(service.itemDetail(itemboard_no));
    //상품 이미지
    bean.setItemImgList(service.itemImgList(itemboard_no));
    //상점 정보
    bean.setStoreInfo(service.storeInfo(itemboard_no));
    //상품문의
    bean.setItemQnaList(service.itemQnaList(itemboard_no));
    
    request.setAttribute("itemboard_no", itemboard_no);
    
    HttpSession session = request.getSession();
    
    ActionForward forward = new ActionForward();
    forward.setPath("/template.jsp");
    forward.setRedirect(false);
    forward.setConPath("./jy/detailProduct.jsp");
    
    request.setAttribute("forward", forward);
    
    return forward;
  }
}
