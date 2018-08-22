package com.fleamarket.mainDetail.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;
import com.fleamarket.mapper.MainDetailMapper;

public class MainDetailDAO {
	private static MainDetailDAO dao = new MainDetailDAO();
	
	public static MainDetailDAO getInstance(){
		
		return dao;
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config-mainDetail.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//추천 상품
	public List<RecommendDTO> recommend(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<RecommendDTO> recommend = null;
	  try {
      recommend = sqlSession.getMapper(MainDetailMapper.class).recommend();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return recommend;
	}
	
	//인기상품 리스트
	public List<HotItemDTO> hotItemList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<HotItemDTO> hotItemList = null;
	  try {
      hotItemList = sqlSession.getMapper(MainDetailMapper.class).hotItemList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return hotItemList;
	}
	
	//큰카테고리 리스트
	public List<CategoryDTO> categoryList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<CategoryDTO> categoryList = null;
	  try {
      categoryList = sqlSession.getMapper(MainDetailMapper.class).categoryList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return categoryList;
	}
	
}
