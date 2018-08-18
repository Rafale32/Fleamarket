package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PaymentDAO;
import com.fleamarket.product.model.ItemDTO;


public class PaymentService {
  private static PaymentService service = new PaymentService();
  private static PaymentDAO dao;

  public static PaymentService getInstance() {
    dao = PaymentDAO.getInstance();
    return service;
  }
  
 // 배송정보 입력
  public int insertDeliveryService(HttpServletRequest request) throws Exception {
    DeliveryDTO_jh delivery = new DeliveryDTO_jh();
    
    delivery.setDelivery_no(Integer.parseInt(request.getParameter("delivery_no")));
    delivery.setDelivery_name(request.getParameter("delivery_name"));
    delivery.setDelivery_ph(request.getParameter("delivery_ph"));
    delivery.setDelivery_address(request.getParameter("delivery_address"));
    delivery.setDelivery_address2(request.getParameter("delivery_address2"));
    delivery.setDelivery_contents(request.getParameter("delivery_contents"));

    return dao.insertDelivery(delivery);
  }// insertBoardService
  
  
  // 회원정보 가져오기
  public MemManageDTO selectMemberService(HttpServletRequest request) throws Exception {
    String email = request.getParameter("email");
    MemManageDTO memManageDTO = dao.selectMember(email);
    return memManageDTO;
  } //selectMemberService
  
  
  // 상품 정보 가져오기
  public ItemDTO selectItemService(HttpServletRequest request) throws Exception {
    String str = request.getParameter("item_no");
    
    int item_no = 0;
    if (str != null) {
      item_no = Integer.parseInt(str);
    }
    ItemDTO itemDTO = dao.selectItem(item_no);
    return itemDTO;
  }//selectItemService
   
  
  
  
  
  
  
  
  
  
  
  
  
  
}
