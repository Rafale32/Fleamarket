package com.fleamarket.payment.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.PaymentMapper;

public class SellProductDAO_gy {
	
	static SellProductDAO_gy dao = new SellProductDAO_gy();
	
	public static SellProductDAO_gy getInstance(){
		
		return dao;
		
	}

	//sql접속 메소드 입니다.
		public SqlSessionFactory getSqlSessionFactory(){
			System.out.println("펙토리안1");
			
			String resource = "mybatis-config-payment.xml";
			System.out.println("펙토리안2");
			InputStream in = null;
			
			try {
				in = Resources.getResourceAsStream(resource); 
				System.out.println("펙토리안3");
				
			} 
			catch (Exception e) {
				e.printStackTrace();
			}
			
			System.out.println("펙토리안4");
			
			return new SqlSessionFactoryBuilder().build(in);
		}
	
	
	
	
	
	
public List<SellProductDTO_gy> listBoard(){
		
		System.out.println("리스트 안으로 들어옴1");
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		System.out.println("리스트 안으로 들어옴2");
		List<SellProductDTO_gy> list = null;
		
		try {
			System.out.println("리스트 안의 트라이문");
			
			list = sqlSession.getMapper(PaymentMapper.class).listSellBoard(); //mapper 방식 //숫자로 게시판 글 갯수 조정가능
		//	list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard"); //id이름뿐만아니라 namespace이름도 갖고와야함
			
			System.out.println("리스트 안의 트라이문 종료");
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return list;
	}
	
	

}
