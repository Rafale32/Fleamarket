package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;

public class DetailOrderAction_jh implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("DetailOrderAction 접속");
    ActionForward forward = new ActionForward();
    DetailOrderService_jh service = DetailOrderService_jh.getInstance();

    Bean bean = (Bean) request.getAttribute("bean");
    
    // 물품번호
    String str = request.getParameter("item_No");
    int item_no = 0;
    if(str != null){
      item_no = Integer.parseInt(str);
    }
    
    // 상품정보
    bean.setItemDTO(service.findItemService(request));
    System.out.println("load itemInfo ok");
    // 주문정보
    bean.setSpellDTO_jh(service.findSpellService(request));
    System.out.println("load orderInfo ok");
    // 결제정보
    bean.setPaymentDTO(service.findPaymentService(request));
    System.out.println("load paymentInfo ok");
    // 배송정보
    bean.setDeliveryDTO_jh(service.findDeliService(request));
    System.out.println("load DeliveryInfo ok");
    // 이미지
    bean.setItemImgDTO_jh(service.findImgService(request));
    System.out.println("load img ok");
    
    request.setAttribute("item_no", item_no);
    // request.setAttribute("bean", bean);

    forward.setPath("/template.jsp"); 
    forward.setRedirect(false); 
    forward.setConPath("./jh_gy/jh_view/order_detail_jh.jsp");

    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록

    return forward;
  }

}
