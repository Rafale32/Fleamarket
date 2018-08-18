package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.payment.model.PuerchaseDTO_gy;

public interface PaymentMapper {
	//int insertBoard(Board board); 
	//구매내역 뽑는 메소드 입니다. -건엽 
	
	List<PuerchaseDTO_gy> listPuerchaseBoard();
	///
	
	
}
