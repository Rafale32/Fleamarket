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
	
	public List<MainDetailDTO> recommendList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<MainDetailDTO> list = null;
	  try{
	    list = sqlSession.getMapper(MainDetailMapper.class).recommendList();  
	  } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return list;
	}
	
	
	
	public int insertBoard(){
		
		return 0;
	}
	
	
}
