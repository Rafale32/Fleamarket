package com.fleamarket.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;

public interface ProductMapper {
	//int insertBoard(Board board); 
	
	List<ItemDTO> itemList(RowBounds row , String email);
	List<ItemDTO> itemListByStore(RowBounds row , String storeName);
	List<ItemImg> itemImgList(int itemboard_no);
	int itemPrice(int item_No);
	int favCount(int itemBoard_No);
	int itemQnaCount(int itemboard_no);
	
	List<String> cateList(CategoryDTO catename);
	
	int insertItem(ItemDTO itemDTO);
	int insertItemBoard(ItemDTO itemDTO);
	int insertImgs(ItemImg itemImg);
	int countItemBoard();
}
