package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.mainDetail.model.MainDetailDTO;
import com.fleamarket.mainDetail.model.TemDTO;

public interface MainDetailMapper {
	List<MainDetailDTO> recommendList();
	List<TemDTO> recommendItem();
}
