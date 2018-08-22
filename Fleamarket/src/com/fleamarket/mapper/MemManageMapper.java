package com.fleamarket.mapper;

import org.apache.ibatis.annotations.Param;

import com.fleamarket.memManage.model.MemManageDTO;

public interface MemManageMapper {
	//int insertBoard(Board board); 
	MemManageDTO loginMember(@Param("email")String email, @Param("password")String password); 
	
	int joinMember(MemManageDTO dto);
	
	MemManageDTO detailMember(String email);
	
	int updateMember(MemManageDTO dto);
	
	int deleteMember(String email);

	
}
