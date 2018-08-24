package com.fleamarket.memManage.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;

import com.fleamarket.bean.Bean;
import com.fleamarket.mapper.MemManageMapper;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.memManage.model.StoreDTO;


public class MemberService {
	private static MemberService service = new MemberService();
	private static MemManageDAO dao;
	
	
	public static MemberService getInstance(){
		dao = MemManageDAO.getInstance();
		return service;
	}
	
	//가입서비스
	public int joinBoardService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		
		dto.setEmail(request.getParameter("email"));
	//	System.out.println(dto.getEmail()+"메일이 들어온다");
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
	//	System.out.println(dto.getAddress()+"주소가 들오온다");
		dto.setAddress2(request.getParameter("address2"));
	//	System.out.println(dto.getAddress2()+"주소야주소야!!!!!!");
		
		return dao.joinBoard(dto);
	}//joinBoardService
	
	public int joinStoreService(HttpServletRequest request)throws Exception{
		StoreDTO storedto = new StoreDTO();
		
		storedto.setEmail(request.getParameter("email"));
	//	storedto.setHits(Integer.parseInt(request.getParameter("hits")));
		storedto.setOpen_date(request.getParameter("open_date"));
		storedto.setStore_name(request.getParameter("store_name"));
	//	storedto.setStore_no(Integer.parseInt(request.getParameter("store_no")));

		
		return dao.joinStore(storedto);
		
	}
	//랜덤 스토어명 생성
	public int randomStoreService(HttpServletRequest request , String randomNum)throws Exception{
		StoreDTO storedto = new StoreDTO();
	/*	Random ran = new Random();
		//랜덤 숫자 생성
		int randomInt = (ran.nextInt(100000)+1);
		String randomNum = ""+randomInt;
		*/
		storedto.setEmail(request.getParameter("email"));
		storedto.setStore_name(randomNum);
		
		return dao.randomStore(storedto);		
				
	}
			
	// 중복 스토어명 찾기
	public int listStoreService(HttpServletRequest request)throws Exception{
		
		StoreDTO storedto = new StoreDTO();
		MemberService service = MemberService.getInstance();
		storedto.setEmail(request.getParameter("email"));
		
		Random ran = new Random();
		//랜덤 숫자 생성
		int randomInt = (ran.nextInt(100000)+1);
		String randomNum = ""+randomInt;
		
		//랜덤값 불러옴
		storedto.setEmail(request.getParameter("email"));
		storedto.setStore_name(randomNum);
		//포문 - 리스트
		List<StoreDTO> list = dao.listStore();
		
		for (int i = 0; i < list.size(); i++) {
			//중복됨
			if(list.get(i).getStore_name().equals(randomNum) ){
				listStoreService(request);
			}else{//중복안됨
				
				System.out.println(i);
			
			}
			
		}
		return service.randomStoreService(request, randomNum);
	}
	
	//삭제서비스
	public int deleteMemberService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		String email = request.getParameter("email");
		MemManageDAO dao = new MemManageDAO();
		
		int n =dao.deleteMember(email);
		
//		re = dto.setEmail(request.getParameter("email"));
		System.out.println(request.getParameter("email")+"삭제될 운명입니다.");
		System.out.println(request.getParameter("email") + "dmdkdmkdmdkmdkmdkdmkm");
		
		return dao.deleteMember(email);
	}
	
	//수정 서비스
	public int updateMemberService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		
		dto.setEmail(request.getParameter("email"));	
		dto.setPassword(request.getParameter("password"));
		dto.setPhone(request.getParameter("phone"));
		dto.setName(request.getParameter("name"));
		dto.setAddress(request.getParameter("address"));
		dto.setAddress2(request.getParameter("address2"));
		
		return dao.updateMember(dto);
	}
	
}
