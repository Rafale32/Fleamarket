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
    PaymentService service = PaymentService.getInstance();
    
    //insert
    //주문부터 해야한다 => 배송테이블과 결제테이블이 주문테이블 참조하기 때문
    service.insertSpellService(request);    // ok
    System.out.println(1);
    service.insertDeliveryService(request); // ok
    System.out.println(2);
    service.insertPaymentService(request);  // ok
    System.out.println(3);
    
    //update
    service.updateItemDeliverystateService(request); //ok
    System.out.println(4);
    service.updateMemberPointService(request); // 
    System.out.println(5);

    ActionForward forward = new ActionForward();
    forward.setPath("/Fleamarket/payment/detailpayment.do"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
    forward.setRedirect(true); //완전 새로운 페이지로 갈거냐 안갈거냐
    
    //  detailPayment.do
    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
    
    return forward;
  }

}
