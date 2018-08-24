package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.model.ItemDTO;

//결제페이지 들어오는거
public class PaymentAction implements Action {
  // 리다이렉트 할때는 무조건 가능페이지.do 로 해서 그 쪽페이지로 아예 가버릴때 사용
  // false 사용할때는 .jsp 를 사용 해서 보내는것임
  @Override
  public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
    System.out.println("PaymentAction 접속");
    ActionForward forward = new ActionForward();
    PaymentService service = PaymentService.getInstance();
    HttpSession session = request.getSession();

    Bean bean = (Bean) request.getAttribute("bean");
//    20180822 세션에서 가져오게 되서 안씀
//    bean.setMemManageDTO(service.selectMemberService(request));
    // 상품정보
    bean.setItemDTO(service.selectItemService(request));
    System.out.println("load itemInfo ok");
    
    // 주문번호
    bean.setSpellDTO_jh(service.selectSpellNoService(request));
    System.out.println("load orderNo ok");
    
    // 이미지
    bean.setItemImgDTO_jh(service.selectImgService(request));
    System.out.println("load img ok");
    
    request.setAttribute("bean", bean);

    forward.setPath("/template.jsp"); 
    forward.setRedirect(false);
    forward.setConPath("./jh_gy/jh_view/order_jh.jsp");

    request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
    return forward;
  }

}
