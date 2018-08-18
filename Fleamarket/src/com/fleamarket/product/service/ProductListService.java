package com.fleamarket.product.service;

import java.util.List;

import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ProductDAO;

public class ProductListService {
	
	private static ProductListService service = new ProductListService();
	private static ProductDAO dao;
	
	public static ProductListService getInstance(){
		
		dao = ProductDAO.getInstance();
		
		return service;
	}
	
	
	public List<ItemDTO> productListService(String email, String storeName){
		
		//로그인 상태 일때는 email 이 있고 로그인 아닐때는 상점 이름으로 찾아야하는대 클릭 했을때 파람으로 가지고 와야함 
		
		if(storeName != null){
			return dao.productListByStore(storeName);
		}else if(email != null){
			return dao.productList(email);
		}
		
		return null;
	}
	
}
