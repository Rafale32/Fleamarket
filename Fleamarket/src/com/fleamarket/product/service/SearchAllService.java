package com.fleamarket.product.service;

import java.util.List;

import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ProductDAO;

public class SearchAllService {
	
	private static SearchAllService service = new SearchAllService();
	private static ProductDAO dao;

	public static SearchAllService getInstance(){
		dao = ProductDAO.getInstance();
		return service;
	}
	
	public List<ItemDTO> searchAll(String searchSubj,int start, int size){
		List<ItemDTO> list= null;
		
		list = dao.searchAll(searchSubj, start, size);
		
		return list;
	}
	
}
