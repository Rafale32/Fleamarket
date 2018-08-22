package com.fleamarket.product.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.product.service.ProductModifyFormService;

public class ProductModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("모디파이폼 액션 들어옴?");
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./subtemplate_mystore.jsp");
		forward.setSubConPath("./dy/productmodifyform.jsp");
		request.setAttribute("forward", forward); 
		
		Bean bean = (Bean)request.getAttribute("bean");
		
		int itemboard_No = Integer.parseInt(request.getParameter("itemboard_No"));
		
		ProductModifyFormService ser = ProductModifyFormService.getInstance();
		bean.setItemDTO(ser.getAllItems(itemboard_No, request));
		
		
		return forward;
	}

}
