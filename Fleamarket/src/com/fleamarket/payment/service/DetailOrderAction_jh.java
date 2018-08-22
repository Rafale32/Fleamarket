package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;

public class DetailOrderAction_jh implements Action {

  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    ActionForward forward = new ActionForward();
    DetailOrderService_jh service = DetailOrderService_jh.getInstance();

    Bean bean = (Bean) request.getAttribute("bean");
    
    // 상품정보
    bean.setItemDTO(service.findItemService(request));
    // 주문정보
    bean.setSpellDTO_jh(service.findSpellService(request));
    // 결제정보
    bean.setPaymentDTO(service.findPaymentService(request));
    // 배송정보
    bean.setDeliveryDTO_jh(service.findDeliService(request));
    
    request.setAttribute("bean", bean);

    forward.setPath("/template.jsp"); // 원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지
                                      // 템플릿이 헤더및 푸터 있으니까
    forward.setRedirect(false); // 완전 새로운 페이지로 갈거냐 안갈거냐
    forward.setConPath("./jh_gy/jh_view/order_detail_jh.jsp"); // 원하는 container 파일 경로

    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록

    return forward;
  }

}
