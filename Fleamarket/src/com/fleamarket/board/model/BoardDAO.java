package com.fleamarket.board.model;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;

public class BoardDAO {
	private static BoardDAO dao = new BoardDAO();
	
	public static BoardDAO getInstance(){
		
		return dao;
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config-board.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	
	
	
	
	public int insertBoard(){
		
		return 0;
	}
	
	
}
