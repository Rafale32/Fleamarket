package com.fleamarket.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.memManage.model.StoreDTO;

public interface MemManageMapper {
	//int insertBoard(Board board); 
	MemManageDTO loginMember(@Param("email")String email, @Param("password")String password); 
	//상점생성
	int joinStore(StoreDTO dto);
	//회원가입
	int joinMember(MemManageDTO dto);
	//랜덤 상점명으로 변경
	int randomStore(StoreDTO dto);
	//중복 상점 제거
	List<StoreDTO> listStore();
	//아이디 중복체크
	List<MemManageDTO> idCheck();	
	//회원 정보 보기
	MemManageDTO detailMember(String email);
	//회원 정보 수정
	int updateMember(MemManageDTO dto);
	//회원 탈퇴
	int deleteMember(String email);

	
}
