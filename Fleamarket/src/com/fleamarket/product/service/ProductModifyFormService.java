package com.fleamarket.product.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ProductDAO;

public class ProductModifyFormService {
	
	private static ProductModifyFormService service = new ProductModifyFormService();
	
	private static ProductDAO dao;
	
	public static ProductModifyFormService getInstance(){
		
		dao = ProductDAO.getInstance();
		return service;
	}
	
	
	public ItemDTO getAllItems(int itemboard_No, HttpServletRequest request){
		
		ItemDTO item = dao.getAllFromProduct(itemboard_No, request);
		
		
		
		return item;
	}
	
}
