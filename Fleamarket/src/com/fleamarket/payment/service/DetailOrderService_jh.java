package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.DetailOrderDAO_jh;
import com.fleamarket.payment.model.PaymentDTO;
import com.fleamarket.payment.model.SpellDTO_jh;
import com.fleamarket.product.model.ItemDTO;

public class DetailOrderService_jh {
  private static DetailOrderService_jh service = new DetailOrderService_jh();
  private static DetailOrderDAO_jh dao;

  public static DetailOrderService_jh getInstance() {
    dao = DetailOrderDAO_jh.getInstance();
    return service;
  }
  
          // 주문 상세 내역 페이지 들어 갈 때
 //상품 및 상품글, 이미지정보
 public ItemDTO findItemService(HttpServletRequest request) throws Exception {
   String str = request.getParameter("item_no");

   int item_no = 0;
   if (str != null) {
     item_no = Integer.parseInt(str);
   }
   
   ItemDTO item = dao.findItem(item_no);

   return item;
 }// selectItemService
  
//주문내역
public SpellDTO_jh findSpellService(HttpServletRequest request) throws Exception {
  String str = request.getParameter("item_no");

  int item_no = 0;
  if (str != null) {
    item_no = Integer.parseInt(str);
  }
  SpellDTO_jh spell = dao.findSpell(item_no);

  return spell;
}// findItemService
  
//결제내역
public PaymentDTO findPaymentService(HttpServletRequest request) throws Exception {
 String str = request.getParameter("item_no");

 int item_no = 0;
 if (str != null) {
   item_no = Integer.parseInt(str);
 }
 PaymentDTO payment = dao.findPayment(item_no);

 return payment;
}// findPaymentService
  
//배송정보
public DeliveryDTO_jh findDeliService(HttpServletRequest request) throws Exception {
 String str = request.getParameter("item_no");

 int item_no = 0;
 if (str != null) {
   item_no = Integer.parseInt(str);
 }
 
 DeliveryDTO_jh deli = dao.findDeli(item_no);

 return deli;
}// findDeliService



}
