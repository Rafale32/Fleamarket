package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PuerchaseDTO_gy;
import com.fleamarket.product.model.ItemDTO;

public interface PaymentMapper {

	// 구매내역 뽑는 메소드 입니다. -건엽 
	List<PuerchaseDTO_gy> listPuerchaseBoard();
	
	// 배송정보 입력 - 20180817 재헌
	int insertDelivery(DeliveryDTO_jh deliveryDTO_jh);
	
	// 회원 정보 가져오기 - 20180817 재헌
	MemManageDTO selectMember(String email);
	
	// 상품 정보 가져오기 - 20180817 재헌
	ItemDTO selectItem(int item_no);

}
