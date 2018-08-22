package com.fleamarket.memManage.service;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;


public class MemberService {
	private static MemberService service = new MemberService();
	private static MemManageDAO dao;
	
	
	public static MemberService getInstance(){
		dao = MemManageDAO.getInstance();
		return service;
	}
	
	Connection getConnection(){
		Connection conn = null;
		Context initContext;
		
		try{
			initContext = new InitialContext();
			DataSource ds = (DataSource)initContext.lookup("java:/comp/env/jdbc/myoracle");
			conn = ds.getConnection();
			
		}catch(NamingException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	
	public int joinBoardService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		
		dto.setEmail(request.getParameter("email"));
		//System.out.println(dto.getEmail()+"메일이 들어온다");
		dto.setPassword(request.getParameter("password"));
		dto.setName(request.getParameter("name"));
		dto.setPhone(request.getParameter("phone"));
		dto.setAddress(request.getParameter("address"));
//		System.out.println(dto.getAddress()+"주소가 들오온다");
		dto.setAddress2(request.getParameter("address2"));
//		System.out.println(dto.getAddress2()+"주소야주소야!!!!!!");
		
		
		return dao.joinBoard(dto);
	}//joinBoardService
	
	public int updateMemberService(HttpServletRequest request)throws Exception{
		MemManageDTO dto = new MemManageDTO();
		
		int re = -1;
		
		HttpSession session = request.getSession();
		dto = (MemManageDTO) session.getAttribute("member");
		System.out.println(dto.getEmail() + " 이메일 나오나요?");
		
		//dto = (MemManageDTO) session.getAttribute("email");
		
		dto.setPassword(request.getParameter("password"));
		System.out.println(request.getParameter("password") +"패스워드!!");
		
		dto.setName(request.getParameter("name"));
		System.out.println(request.getParameter("name") +"이름!!");
		
		dto.setPhone(request.getParameter("phone"));
		System.out.println(request.getParameter("phone") +"폰!!");
		
		dto.setAddress(request.getParameter("address"));
		System.out.println(request.getParameter("address") +"주소!!");
		
		dto.setAddress2(request.getParameter("address2"));
		System.out.println(request.getParameter("address2") +"상세주소!!");
		
		System.out.println(dto.getName()+"이름이 수정된다.");
		
		return re;
	}//updateMember
	
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
	
}
