package com.fleamarket.mapper;

import java.util.List;

import com.fleamarket.mainDetail.model.MainDetailDTO;

public interface MainDetailMapper {
	//int insertBoard(Board board); 
	List<MainDetailDTO> recommendList();
	
}
