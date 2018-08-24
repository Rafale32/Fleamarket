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
  
  //20180817 천재헌, 이미지 받아올거
  public ItemImgDTO_jh selectImg(int item_no) {
     SqlSession sqlSession = getSqlSessionFactory().openSession();
     ItemImgDTO_jh itemImgDTO_jh = null;
     try {
       itemImgDTO_jh = sqlSession.getMapper(PaymentMapper.class).selectImg(item_no);
     } catch (Exception e) {
       e.printStackTrace();
     } finally {
       sqlSession.close();
     }
     return itemImgDTO_jh;
   } // selectItem
  

  // 20180820 천재헌, 마지막 주문번호 가져오기
  public SpellDTO_jh selectSpellNo() {
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    SpellDTO_jh spellDTO_jh = null;
    try {
      spellDTO_jh = sqlSession.getMapper(PaymentMapper.class).selectSpellNo();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
    return spellDTO_jh;
  }

  // 20180820 천재헌, 주문정보 입력
  public int insertSpell(SpellDTO_jh spellDTO_jh) {
    int re = -1;
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    try {
      re = sqlSession.getMapper(PaymentMapper.class).insertSpell(spellDTO_jh);
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
  }

  // 20180817 천재헌, 넣는다 배송정보
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

  // 20180820 천재헌, 결제정보 입력
  public int insertPayment(PaymentDTO paymentDTO) {
    int re = -1;
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    try {
      re = sqlSession.getMapper(PaymentMapper.class).insertPayment(paymentDTO);
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
  }

  // 상품 배송진행상태 수정 - 20180820 재헌
  public int updateItemDeliveryState(ItemDTO itemDTO) {
    int re = -1;
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    try {
      re = sqlSession.getMapper(PaymentMapper.class).updateItemDeliveryState(itemDTO);
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
  }

  // 구매자 포인트 수정 - 20180820 재헌
  public int updateMemberPoint(MemManageDTO memManageDTO) {
    int re = -1;
    SqlSession sqlSession = getSqlSessionFactory().openSession();
    try {
      re = sqlSession.getMapper(PaymentMapper.class).updateMemberPoint(memManageDTO);
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
  }

}
