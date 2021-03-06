package com.fleamarket.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fleamarket.product.model.CateDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;
import com.fleamarket.product.service.ProductListService;

public interface ProductMapper {
	//int insertBoard(Board board); 
	
	List<ItemDTO> itemList(RowBounds row , String email);
	List<ItemDTO> itemListByStore(RowBounds row , String storeName);
	List<ItemImg> itemImgList(int itemboard_no);
	int itemPrice(int item_No);
	int favCount(int itemBoard_No);
	int itemQnaCount(int itemboard_no);
	
	List<String> cateList(CateDTO catename);
	
	int insertItem(ItemDTO itemDTO);
	int insertItemBoard(ItemDTO itemDTO);
	int insertImgs(ItemImg itemImg);
	int countItemBoard(String email);
	int countItemBoardByStore(String store_name);
	
	int itemBoardDelete(int itemboard_No);
	ItemDTO getAllFromProduct(int itemboard_No);//상품에 관한 모든 정보 itemdto 에 넣기 수정폼에 원래 있던값 넣기 위해서
	ItemDTO getCatebySubNo(int sub_no);
	
	int deleteImg(ItemImg img);
	int deleteThumImg(ItemImg img);
	int updateProduct(ItemDTO itemDTO);
	
	int updateItem(ItemDTO itemDTO);
	int updateItemBoard(ItemDTO itemDTO);
	int updateInsertImgs(ItemDTO itemDTO);
	List<ItemDTO> searchAll(RowBounds row,String searchSubj);
	String getOneImg(int itemboard_No);
	
}
