package com.fleamarket.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.service.ProductDeleteService;

public class ProductDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String email = ((MemManageDTO)session.getAttribute("member")).getEmail();
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/product/productlist.do?email="+email);
		forward.setRedirect(true);
		
		int itemboard_No =Integer.parseInt(request.getParameter("itemboard_No"));
		ProductDeleteService ser = ProductDeleteService.getInstance();
		ser.itemBoardDelete(itemboard_No);
		
		return forward;
	}

}
