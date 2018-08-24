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
    ItemDTO itemDTO = null;

    try {
      itemDTO = sqlSession.getMapper(PaymentMapper.class).findItem(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return itemDTO;
  } // findItem

  // 주문 내역 조회 - 20180821 재헌
  public SpellDTO_jh findSpell(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    SpellDTO_jh spellDTO_jh = null;
    try {
      spellDTO_jh = sqlSession.getMapper(PaymentMapper.class).findSpell(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return spellDTO_jh;
  } // findSpell

  // 결제 내역 조회 - 20180821 재헌
  public PaymentDTO findPayment(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    PaymentDTO paymentDTO = null;
    try {
      paymentDTO = sqlSession.getMapper(PaymentMapper.class).findPayment(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return paymentDTO;
  } // findPayment

  // 배송 내역 조회 - 20180821 재헌
  public DeliveryDTO_jh findDeli(int spell_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    DeliveryDTO_jh deliveryDTO_jh = null;
    try {
      deliveryDTO_jh = sqlSession.getMapper(PaymentMapper.class).findDeli(spell_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return deliveryDTO_jh;
  } // findDeli
  
  // 상품이미지 조회 - 20180823 재헌
  public ItemImgDTO_jh findImg(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    ItemImgDTO_jh itemImgDTO_jh = null;

    try {
      itemImgDTO_jh = sqlSession.getMapper(PaymentMapper.class).findImg(item_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return itemImgDTO_jh;
  } // findItem

}
