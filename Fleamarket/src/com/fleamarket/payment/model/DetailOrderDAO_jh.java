package com.fleamarket.payment.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.PaymentMapper;
import com.fleamarket.product.model.ItemDTO;

public class DetailOrderDAO_jh {
  private static DetailOrderDAO_jh dao = new DetailOrderDAO_jh();

  public static DetailOrderDAO_jh getInstance() {
    return dao;
  }

  public SqlSessionFactory getSqlSessionFactory() {

    String resource = "mybatis-config-payment.xml";

    InputStream in = null;

    try {
      in = Resources.getResourceAsStream(resource);

    } catch (Exception e) {
      e.printStackTrace();
    }

    return new SqlSessionFactoryBuilder().build(in);
  }

  // 상품 정보 조회 - 20180821 재헌
  public ItemDTO findItem(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    ItemDTO item = null;

    try {
      item = sqlSession.getMapper(PaymentMapper.class).findItem(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return item;
  } // findItem

  // 주문 내역 조회 - 20180821 재헌
  public SpellDTO_jh findSpell(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    SpellDTO_jh spell = null;
    try {
      spell = sqlSession.getMapper(PaymentMapper.class).findSpell(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return spell;
  } // findSpell

  // 주문 내역 조회 - 20180821 재헌
  public PaymentDTO findPayment(int spell_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    PaymentDTO pay = null;
    try {
      pay = sqlSession.getMapper(PaymentMapper.class).findPayment(spell_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return pay;
  } // findPayment

  // 주문 내역 조회 - 20180821 재헌
  public DeliveryDTO_jh findDeli(int spell_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    DeliveryDTO_jh deli = null;
    try {
      deli = sqlSession.getMapper(PaymentMapper.class).findDeli(spell_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return deli;
  } // findDeli
  
  

}
