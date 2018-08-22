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
	
	//추천 상품
	public List<RecommendDTO> recommend(){
	  //이 메소드에서 sql문 쓸거야
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  
	  //가져온 데이터를 넣을 공간을 만듬
	  List<RecommendDTO> recommend = null;
	  try {
	    //sql문을 이용하여 DB에서 가져온 데이터를 리스트에 넣음~~~.(select id)();
      recommend = sqlSession.getMapper(MainDetailMapper.class).recommend();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return recommend;
	}
	
	//인기상품 리스트
	public List<HotItemDTO> hotItemList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<HotItemDTO> hotItemList = null;
	  try {
      hotItemList = sqlSession.getMapper(MainDetailMapper.class).hotItemList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return hotItemList;
	}
	
	//큰카테고리 리스트
	public List<HotListDTO> hotList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<HotListDTO> categoryList = null;
	  try {
      categoryList = sqlSession.getMapper(MainDetailMapper.class).hotList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return categoryList;
	}
	
	public List<CategoryDTO> categoryList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<CategoryDTO> categoryList = null;
	  try {
      categoryList = sqlSession.getMapper(MainDetailMapper.class).categoryList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return categoryList;
	}
	
	public List<SubCategoryDTO> subCategoryList(){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<SubCategoryDTO> subCategoryList = null;
	  try {
      subCategoryList = sqlSession.getMapper(MainDetailMapper.class).subCategoryList();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return subCategoryList;
	}
	
	public ItemDetailDTO itemDetail(int itemboard_no){
	  
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  ItemDetailDTO itemDetail = null;
	  int re = -1;
	  try {
      itemDetail = sqlSession.getMapper(MainDetailMapper.class).itemDetail(itemboard_no);
      re = sqlSession.getMapper(MainDetailMapper.class).updateHits(itemboard_no);
      if(re >0){
        sqlSession.commit();
      }else{
        sqlSession.rollback();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  
	  return itemDetail;
	}
	
	public List<ItemImgDTO> itemImgList(int itemboard_no){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<ItemImgDTO> itemImgList = null;
	  try {
      itemImgList = sqlSession.getMapper(MainDetailMapper.class).itemImgList(itemboard_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return itemImgList;
	}
	
	public StoreInfoDTO storeInfo(int itemboard_no){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  StoreInfoDTO storeInfo = null;
	  try {
      storeInfo = sqlSession.getMapper(MainDetailMapper.class).storeInfo(itemboard_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return storeInfo;
	}
	
	public List<ItemDetailDTO> storeItemList(int store_no, int itemboard_no){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<ItemDetailDTO> storeItemList = null;
	  try {
      storeItemList = sqlSession.getMapper(MainDetailMapper.class).storeItem(store_no, itemboard_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return storeItemList;
	}
	
	public List<ItemQnaDTO> listQna(int itemboard_no){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<ItemQnaDTO> itemQnaList = null;
	  try {
      itemQnaList = sqlSession.getMapper(MainDetailMapper.class).listQna(itemboard_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return itemQnaList;
	}
	
	public int insertQna(ItemQnaDTO itemQna){
	  int re = -1;
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  try {
      re = sqlSession.getMapper(MainDetailMapper.class).insertQna(itemQna);
      if (re > 0){
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
	
	public ItemQnaDTO storeNoInfo(String name){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  ItemQnaDTO storeNoInfo = null;
	  try {
      storeNoInfo = sqlSession.getMapper(MainDetailMapper.class).storeNoInfo(name);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return storeNoInfo;
	}
	
	public int deleteQna(int itemQnaNo){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  int re = -1;
	  try {
      re = sqlSession.getMapper(MainDetailMapper.class).deleteQna(itemQnaNo);
      if(re > 0){
        sqlSession.commit();
      }else{
        sqlSession.rollback();
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return re;
	}
	
	public List<ItemDetailDTO> categoryItemList(int category_no){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  List<ItemDetailDTO> categoryItemList = null;
	  try {
      categoryItemList = sqlSession.getMapper(MainDetailMapper.class).categoryItemList(category_no);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return categoryItemList;
	}

}
