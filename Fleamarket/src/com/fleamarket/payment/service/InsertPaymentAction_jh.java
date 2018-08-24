package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
//결제페이지 값들 디비에 넣어 준다.
public class InsertPaymentAction_jh implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("insertPaymentAction 접속");
    ActionForward forward = new ActionForward();
    PaymentService service = PaymentService.getInstance();
    
    //주문부터 해야한다 => 배송테이블과 결제테이블이 주문테이블 참조하기 때문
    service.insertSpellService(request);    // ok
    System.out.println("save orderInfo ok");
    service.insertDeliveryService(request); // ok
    System.out.println("save deliveryInfo ok");
    service.insertPaymentService(request);  // ok
    System.out.println("save paymentInfo ok");
    
    //update
    service.updateItemDeliverystateService(request); // ok
    System.out.println("update itemDeliveryState ok");
    service.updateMemberPointService(request); // ok
    System.out.println("update MemberPoint ok");

    // 물품번호
    String str = request.getParameter("item_No");
    int item_no = 0;
    if(str != null){
      item_no = Integer.parseInt(str);
    }
    request.setAttribute("item_no", item_no);
    
    forward.setRedirect(true);
    forward.setPath("/Fleamarket/payment/detailpayment.do?item_no="+item_no);
    
    request.setAttribute("forward", forward);
    
    return forward;
  }

}
