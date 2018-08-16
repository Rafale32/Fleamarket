package com.fleamarket.product.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;
import com.fleamarket.mapper.ProductMapper;

public class ProductDAO {
	
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstance(){
		
		return dao;
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config-product.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//로그인한 상태의 아이디로 찾아야하는 상태이기 때문에 그 이메일로 검색해서 찾아야함
	public List<ItemDTO> productList(String email){
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		List<ItemDTO> list = null;
		
		try {
			
			list = sqlsession.getMapper(ProductMapper.class).itemList(email);
			
			for(ItemDTO  tmp : list){
				if(tmp.getItemboard_No() != 0){
					tmp.setItemImgList(sqlsession.getMapper(ProductMapper.class).itemImgList(tmp.getItemboard_No()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		return list;
	}
	
	public List<ItemDTO> productListByStore(String storeName){
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		List<ItemDTO> list = null;
		
		try {
			
			list = sqlsession.getMapper(ProductMapper.class).itemListByStore(storeName);
			
			for(ItemDTO  tmp : list){
				if(tmp.getItemboard_No() != 0){
					tmp.setItemImgList(sqlsession.getMapper(ProductMapper.class).itemImgList(tmp.getItemboard_No()));
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		return list;
	}
	
	
}
