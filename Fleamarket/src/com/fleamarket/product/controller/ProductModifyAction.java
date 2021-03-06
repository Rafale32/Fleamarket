package com.fleamarket.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.service.AddProductService;
import com.fleamarket.product.service.ProductModifyService;

public class ProductModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		HttpSession session = request.getSession();
		MemManageDTO member =(MemManageDTO)session.getAttribute("member");
		String email = member.getEmail();
		
		ActionForward forward = new ActionForward();
		forward.setPath("/Fleamarket/product/productlist.do?email="+email); 
		forward.setRedirect(true);
		
		request.setAttribute("forward", forward);
		
		ProductModifyService service = ProductModifyService.getInstance();
		service.productModify(request);
		
		return forward;
	}

}
