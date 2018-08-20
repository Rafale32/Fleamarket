package com.fleamarket.payment.model;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.PaymentMapper;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.model.ItemDTO;

public class PaymentDAO {
  private static PaymentDAO dao = new PaymentDAO();

  public static PaymentDAO getInstance() {
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

  // 20180817 천재헌, 배송정보 받아올거
  public int insertDelivery(DeliveryDTO_jh deliveryDTO_jh) {
    int re = -1;
    SqlSession sqlSession = getSqlSessionFactory().openSession();

    try {

      re = sqlSession.getMapper(PaymentMapper.class).insertDelivery(deliveryDTO_jh);

      if (re > 0) {
        sqlSession.commit();
      } else {
        sqlSession.rollback();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return re;
  } // insertDeliveryDTO

  // 20180817 천재헌, 회원정보 받아올거
  public MemManageDTO selectMember(String email) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    MemManageDTO memManageDTO = null;

    try {

      memManageDTO = sqlSession.getMapper(PaymentMapper.class).selectMember(email);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return memManageDTO;
  } // selectMember

  // 20180817 천재헌, 상품정보 받아올거
  public ItemDTO selectItem(int item_no) {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    ItemDTO itemDTO = null;
    try {

      itemDTO = sqlSession.getMapper(PaymentMapper.class).selectItem(item_no);

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return itemDTO;
  } // selectItem

}
