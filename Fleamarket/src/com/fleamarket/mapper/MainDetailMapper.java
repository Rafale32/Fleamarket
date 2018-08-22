package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.mainDetail.model.HotListDTO;
import com.fleamarket.mainDetail.model.ItemDetailDTO;
import com.fleamarket.mainDetail.model.ItemImgDTO;
import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.RecommendDTO;
import com.fleamarket.mainDetail.model.StoreInfoDTO;
import com.fleamarket.mainDetail.model.SubCategoryDTO;

public interface MainDetailMapper {
	List<RecommendDTO> recommend();
	List<HotItemDTO> hotItemList();
	List<HotListDTO> hotList();
	List<CategoryDTO> categoryList();
	List<SubCategoryDTO> subCategoryList();
	ItemDetailDTO itemDetail(int itemboard_no);
	List<ItemImgDTO> itemImgList(int itemboard_no);
	StoreInfoDTO storeInfo(int itemboard_no);
	List<ItemDetailDTO> storeItem(int store_no);
}
