package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.RecommendDTO;

public interface MainDetailMapper {
	List<RecommendDTO> recommend();
	List<HotItemDTO> hotItemList();
	List<CategoryDTO> categoryList();
}
