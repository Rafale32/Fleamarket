package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class MemberService {
	private static MemberService service = new MemberService();
	private static MemManageDAO dao;
	
	public static MemberService getInstance(){
		dao = MemManageDAO.getInstance();
		return service;
	}
	
	public int joinBoardService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		
		dto.setEmail(request.getParameter("email"));
		System.out.println(dto.getEmail()+"asdfasdfcfghjxfgh");
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
		System.out.println(dto.getAddress()+"주소야");
		dto.setAddress2(request.getParameter("address2"));
		System.out.println(dto.getAddress2()+"주소야주소야");
		
		return dao.joinBoard(dto);
	}
}
