package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;

public interface ProductMapper {
	//int insertBoard(Board board); 
	
	List<ItemDTO> itemList(String email);
	List<ItemDTO> itemListByStore(String storeName);
	List<ItemImg> itemImgList(int itemboard_no);
	int itemPrice(int item_No);
	int favCount(int itemBoard_No);
	int itemQnaCount(int itemboard_no);
}
