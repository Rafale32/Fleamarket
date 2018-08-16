package com.fleamarket.memManage.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDAO;
import com.fleamarket.memManage.model.MemManageDTO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		MemManageDAO dao = new MemManageDAO();
		MemManageDTO dto = new MemManageDTO();
		ActionForward forward = new ActionForward();
		
		boolean result= false;
		
		try{
			String email = request.getParameter("email");//아이디
			String password = request.getParameter("password");//비번
			String name = request.getParameter("name");//이름
			String phone = request.getParameter("phone");//폰번호
			String address = request.getParameter("address");//주소
			String address2 = request.getParameter("address2");//상세주소
			
			dto.setEmail(email);//dto
			dto.setPassword(password);
			dto.setName(name);
			dto.setPhone(phone);
			dto.setAddress(address);
			dto.setAddress2(address2);
			dto.setAdmin(1);
			
			result = dao.joinBoard(dto);//dto
			
			if(result == false){
				System.out.println("가입");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}//actionForward

}//JoinAction
