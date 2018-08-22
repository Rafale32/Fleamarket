package com.fleamarket.product.service;

import com.fleamarket.product.model.ProductDAO;

public class ProductDeleteService {
	private static ProductDeleteService service = new ProductDeleteService();
	private static ProductDAO dao;
	
	public static ProductDeleteService getInstance(){
		
		dao = ProductDAO.getInstance();
		
		return service;
	}
	
	public ProductDeleteService() {
		// TODO Auto-generated constructor stub
	}
	
	public void itemBoardDelete (int itemboard_No){
		dao.itemBoardDelete(itemboard_No);
	}
	
}