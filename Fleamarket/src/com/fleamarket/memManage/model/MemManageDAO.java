package com.fleamarket.memManage.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;
import com.fleamarket.mapper.MemManageMapper;

public class MemManageDAO {
	
	private static MemManageDAO dao = new MemManageDAO();
	
	public static MemManageDAO getInstance(){
		
		return dao;
		
	}//MemManageDAO
	
	public SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config-memManage.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}//SqlSessionFactory getSqlSessionFactory()
	
	public MemManageDTO loginMember(String email, String password){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  MemManageDTO member = null;
	  
	  try {
	    member = sqlSession.getMapper(MemManageMapper.class).loginMember(email, password);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return member;
	}//loginMember
	

	public int joinBoard(MemManageDTO dto){//회원가입
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MemManageMapper.class).joinMember(dto);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return re;
	}//joinBoard
	
	
}
