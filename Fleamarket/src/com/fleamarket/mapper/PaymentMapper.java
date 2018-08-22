package com.fleamarket.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_gy;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PaymentDTO;
import com.fleamarket.payment.model.PuerchaseDTO_gy;
import com.fleamarket.payment.model.SellProductDTO_gy;
import com.fleamarket.payment.model.SpellDTO_jh;
import com.fleamarket.payment.model.StoreDTO_jh;
import com.fleamarket.product.model.ItemDTO;

public interface PaymentMapper {
  
  
  //건엽
	// 구매내역 뽑는 메소드 입니다. -건엽 
  List<PuerchaseDTO_gy> listPuerchaseBoard();
  ///판매 내역을 뽑는 메소드 입니다. 거의비슷 합니다.
  List<SellProductDTO_gy> listSellBoard();
  // 딜리버리 스테이트를 바꾸는 메소드 입니다. 인트는 확인용
  int changeDelieryState(DeliveryDTO_gy dao);
  int changeDelieryStateSell(DeliveryDTO_gy dao);
  ////단락의 가로줄, 총수를 뽑아주는 메소드 입니다_건엽
  int countBoard();
  // 한페이지에 정해진 갯수만 나오게하는 쿼리 구매부
  List<PuerchaseDTO_gy> listBoardService(RowBounds row);
  // 한페이지에 정해진 갯수만 나오게하는 쿼리 판매부
  List<PuerchaseDTO_gy> listBoardService2(RowBounds row);
	
  // 재헌
  // 결제페이지 들어갈 때 
	// 회원 정보 가져오기 - 20180817 재헌
	MemManageDTO selectMember(String email);
	// 상품 정보 가져오기 - 20180817 재헌
	ItemDTO selectItem(int item_no);
	// 마지막 주문번호 가져오기 - 20180820 재헌
	SpellDTO_jh selectSpellNo();
	
	// 결제페이지에서 나올 때
  // 주문정보 입력 - 20180820 재헌
  int insertSpell(SpellDTO_jh spellDTO_jh);
	 // 배송정보 입력 - 20180817 재헌
  int insertDelivery(DeliveryDTO_jh deliveryDTO_jh);
  // 결제정보 입력 - 20180820 재헌
  int insertPayment(PaymentDTO paymentDTO);
  // 상품 배송상태 수정 - 20180820 재헌
  int updateItemDeliveryState(ItemDTO itemDTO);
  // 구매자 포인트 수정 - 20180820 재헌
  int updateMemberPoint(MemManageDTO memManageDTO);
  
  // 주문상세페이지 들어갈 때
  // 상품 및 상품글, 이미지 정보
  ItemDTO findItem(int item_no);
  // 주문내역
  SpellDTO_jh findSpell(int item_no);
  // 결제내역
  PaymentDTO findPayment(int spell_no);
  // 배송정보
  DeliveryDTO_jh findDeli(int spell_no);
  // 내상점
//  StoreDTO_jh findStore();
	
}
