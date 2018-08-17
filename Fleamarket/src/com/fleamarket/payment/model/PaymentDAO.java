package com.fleamarket.payment.model;

import java.io.InputStream;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;


public class PaymentDAO {
	private static PaymentDAO dao = new PaymentDAO();
	
	public static PaymentDAO getInstance(){
		
		return dao;
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config-payment.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	
	
	
	
//insertBoard
// public int insertDeliveryDTO(DeliveryDTO deliveryDTO) {
//   int re = -1;
//   SqlSession sqlSession = getSqlSessionFactory().openSession();
//
//   try {
////     re = sqlSession.getMapper(BoardMapper.class).insertBoard(deliveryDTO);
//
//     // 트랜잭션 처리
//     if (re > 0) {
//       sqlSession.commit();
//     } else {
//       sqlSession.rollback();
//     }
//
//   } catch (Exception e) {
//     e.printStackTrace();
//   } finally {
//     sqlSession.close();
//   }
//
//   return re;
// }//insertBoard
	
	
}
