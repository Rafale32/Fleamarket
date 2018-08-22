package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PaymentDAO;
import com.fleamarket.payment.model.PaymentDTO;
import com.fleamarket.payment.model.SpellDTO_jh;
import com.fleamarket.product.model.ItemDTO;

public class PaymentService {
  private static PaymentService service = new PaymentService();
  private static PaymentDAO dao;

  public static PaymentService getInstance() {
    dao = PaymentDAO.getInstance();
    return service;
  }
  // 결제페이지 들어올 때

  // 회원정보 가져오기
  public MemManageDTO selectMemberService(HttpServletRequest request) throws Exception {
    String email = request.getParameter("email");
    MemManageDTO memManageDTO = dao.selectMember(email);
    return memManageDTO;
  } // selectMemberService

  // 상품 정보 가져오기
  public ItemDTO selectItemService(HttpServletRequest request) throws Exception {
    String str = request.getParameter("item_no");

    int item_no = 0;
    if (str != null) {
      item_no = Integer.parseInt(str);
    }
    ItemDTO itemDTO = dao.selectItem(item_no);

    return itemDTO;
  }// selectItemService

  // 마지막 주문번호 가져오기
  public SpellDTO_jh selectSpellNoService(HttpServletRequest request) throws Exception {
    SpellDTO_jh spellDTO_jh = dao.selectSpellNo();
    return spellDTO_jh;
  }// selectSpellNoService

  // 결제페이지에서 넘기기
  // 주문정보 입력
  public int insertSpellService(HttpServletRequest request) throws Exception {
    SpellDTO_jh spell = new SpellDTO_jh();

    spell.setSpell_no(Integer.parseInt(request.getParameter("spell_no")));
    spell.setSpell_date(request.getParameter("spell_date"));
    spell.setEmail(request.getParameter("email"));
    spell.setItem_no(Integer.parseInt(request.getParameter("item_No")));

    return dao.insertSpell(spell);
  }// insertSpellService

  // 배송정보 입력
  public int insertDeliveryService(HttpServletRequest request) throws Exception {
    DeliveryDTO_jh delivery = new DeliveryDTO_jh();

    delivery.setDelivery_name(request.getParameter("delivery_name"));
    delivery.setDelivery_ph(request.getParameter("delivery_ph"));
    delivery.setDelivery_address(request.getParameter("delivery_address"));
    delivery.setDelivery_address2(request.getParameter("delivery_address2"));
    delivery.setDelivery_contents(request.getParameter("delivery_contents"));
    delivery.setSpell_no(Integer.parseInt(request.getParameter("spell_no")));

    return dao.insertDelivery(delivery);
  }// insertBoardService

  // 결제정보 입력
  public int insertPaymentService(HttpServletRequest request) throws Exception {
    PaymentDTO payment = new PaymentDTO();

    payment.setPay_date(request.getParameter("pay_date"));
    payment.setPay_price(Integer.parseInt(request.getParameter("total2")));
    payment.setSpell_no(Integer.parseInt(request.getParameter("spell_no")));
    payment.setUse_point(Integer.parseInt(request.getParameter("finalPoint2")));

    return dao.insertPayment(payment);
  }// insertPaymentService

  // 상품 배송진행상태 수정
  public int updateItemDeliverystateService(HttpServletRequest request) throws Exception {
    ItemDTO item = new ItemDTO();
    item.setItem_No(Integer.parseInt(request.getParameter("item_No")));
    
    return dao.updateItemDeliveryState(item);
  }// updateItemDeliverystateService

  // 멤버 포인트 소모 및 적립 수정
  public int updateMemberPointService(HttpServletRequest request) throws Exception {
    MemManageDTO member = new MemManageDTO();
    
    member.setPoint(Integer.parseInt(request.getParameter("point")));
    member.setEmail(request.getParameter("email"));

    return dao.updateMemberPoint(member);
  }// updateMemberPointService

}
