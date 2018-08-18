package com.fleamarket.mainDetail.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    MainDetailDAO dao = MainDetailDAO.getInstance();
    ItemDetailDTO itemDetail = dao.itemDetail(itemboard_no);
    request.setAttribute("itemDetail", itemDetail);
    
    Bean bean = (Bean) request.getAttribute("bean");
    MainDetailService service = MainDetailService.getInstance();
    bean.setCategoryList(service.categoryList());
    
    ActionForward forward = new ActionForward();
    forward.setPath("/template.jsp");
    forward.setRedirect(false);
    forward.setConPath("./jy/detailProduct.jsp");
    
    request.setAttribute("forward", forward);
    
    return forward;
  }
}
