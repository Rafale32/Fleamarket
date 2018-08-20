package com.fleamarket.payment.model;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.fleamarket.mapper.PaymentMapper;

public class PuerchaseDAO_gy {

	// 따로 만든 구매내역 디에이오
	private static PuerchaseDAO_gy dao = new PuerchaseDAO_gy();

	public static PuerchaseDAO_gy getInstance() {

		return dao;

	}

	// sql접속 메소드 입니다.
	public SqlSessionFactory getSqlSessionFactory() {
		System.out.println("펙토리안1");

		String resource = "mybatis-config-payment.xml";
		System.out.println("펙토리안2");
		InputStream in = null;

		try {
			in = Resources.getResourceAsStream(resource);
			System.out.println("펙토리안3");

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("펙토리안4");

		return new SqlSessionFactoryBuilder().build(in);
	}

	// 목록을 가져오는 리메소드 입니다.
	public List<PuerchaseDTO_gy> listBoard() {

		System.out.println("리스트 안으로 들어옴1");

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		System.out.println("리스트 안으로 들어옴2");
		List<PuerchaseDTO_gy> list = null;

		try {
			System.out.println("리스트 안의 트라이문");

			list = sqlSession.getMapper(PaymentMapper.class).listPuerchaseBoard(); 

			System.out.println("리스트 안의 트라이문 종료");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return list;
	}
	// 구매부 체인지 딜리버리
	public int changeDelivery(DeliveryDTO_gy dao) {
		int re=0;
		System.out.println("딜리버리 메소드 안으로 들어옴1");

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(PaymentMapper.class).changeDelieryState(dao); 
			
			System.out.println("딜리버리 메소드 안 re값 확인 : " + re);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return re;

	}
	
	// 판매자가 판매 승인시 상태 변경 메소드
	public int changeDeliverySell(DeliveryDTO_gy dao) {
		int re=0;
		System.out.println("딜리버리 메소드 안으로 들어옴1");

		SqlSession sqlSession = getSqlSessionFactory().openSession();

		try {
			re = sqlSession.getMapper(PaymentMapper.class).changeDelieryStateSell(dao); 
			
			System.out.println("딜리버리 메소드 안 re값 확인 : " + re);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.commit();
			sqlSession.close();
		}
		return re;

	}

}
