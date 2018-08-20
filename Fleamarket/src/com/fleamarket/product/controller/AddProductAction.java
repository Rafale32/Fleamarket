package com.fleamarket.product.controller;



import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.service.AddProductService;

public class AddProductAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemManageDTO member =(MemManageDTO)session.getAttribute("member");
		String email = member.getEmail();
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/product/productlist.do?email="+email); 
		forward.setRedirect(true);
		
		AddProductService addpro = AddProductService.getInstance();
		addpro.insertItemNBoard(request, response);
		
		return forward; //실험 해보고 null 값 바꿔줘라 
	}

}
