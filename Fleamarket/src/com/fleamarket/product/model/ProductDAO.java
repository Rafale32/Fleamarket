package com.fleamarket.product.model;

import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.bean.Bean;
import com.fleamarket.mapper.ProductMapper;
import com.fleamarket.product.service.ProductListService;


public class ProductDAO {
	
	private static ProductDAO dao = new ProductDAO();
	
	public static ProductDAO getInstance(){
		
		return dao;
		
	}
	
	public SqlSessionFactory getSqlSessionFactory(){
		
		String resource = "mybatis-config-product.xml";
		
		InputStream in = null;
		
		try {
			in = Resources.getResourceAsStream(resource);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//로그인한 상태의 아이디로 찾아야하는 상태이기 때문에 그 이메일로 검색해서 찾아야함
	public List<ItemDTO> productList(String email, int startRow){
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		List<ItemDTO> list = null;
		
		try {
			
			list = sqlsession.getMapper(ProductMapper.class).itemList(new RowBounds(startRow, ProductListService.PAGE_SIZE),email);
			
			for(ItemDTO  tmp : list){
				if(tmp.getItemboard_No() != 0){
					tmp.setItemImgList(sqlsession.getMapper(ProductMapper.class).itemImgList(tmp.getItemboard_No()));
				}	
					
				tmp.setPrice(sqlsession.getMapper(ProductMapper.class).itemPrice(tmp.getItem_No()));
				tmp.setFavCount(sqlsession.getMapper(ProductMapper.class).favCount(tmp.getItemboard_No()));
				tmp.setItemQnaCount(sqlsession.getMapper(ProductMapper.class).itemQnaCount(tmp.getItemboard_No()));
				//itemQnaCount
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		return list;
	}
	
	//상점 이름 으로 그 상점의 등록된 물품을 리스트로
	public List<ItemDTO> productListByStore(String storeName, int startRow){
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		List<ItemDTO> list = null;
		
		try {
			
			list = sqlsession.getMapper(ProductMapper.class).itemListByStore(new RowBounds(startRow, ProductListService.PAGE_SIZE) , storeName);
			
			for(ItemDTO  tmp : list){
				if(tmp.getItemboard_No() != 0){
					tmp.setItemImgList(sqlsession.getMapper(ProductMapper.class).itemImgList(tmp.getItemboard_No()));
				}
				
				tmp.setPrice(sqlsession.getMapper(ProductMapper.class).itemPrice(tmp.getItem_No()));
				tmp.setFavCount(sqlsession.getMapper(ProductMapper.class).favCount(tmp.getItemboard_No()));
				tmp.setItemQnaCount(sqlsession.getMapper(ProductMapper.class).itemQnaCount(tmp.getItemboard_No()));
				
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		return list;
	}
	
	
	
	public List<String> cateList(CateDTO catename){
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		List<String> list = null;
		
		try {
			
			list = sqlsession.getMapper(ProductMapper.class).cateList(catename);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		
		return list;
	}
	
	
	public int insertItemNBoard(ItemDTO itemDTO){
		int re1 = -1;
		int re2 = -1;
		int re3 = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re1 = sqlSession.getMapper(ProductMapper.class).insertItem(itemDTO);
			re2 = sqlSession.getMapper(ProductMapper.class).insertItemBoard(itemDTO);
			for(ItemImg tmp : itemDTO.getItemImgList()){
				re3 = sqlSession.getMapper(ProductMapper.class).insertImgs(tmp);
			}
			if(re1>0 && re2>0 && re3>0){//정상처리
				sqlSession.commit();
				re3 = 1;
			}else{//비정상 처리
				sqlSession.rollback();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re3;
	}
	
	
	
	public int countItemBoard(String email){ //페이징 처리 위한 아이템 전체 갯수 이지만 이메일로 검색한 전체 갯수
		int cnt = 0;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
				cnt= sqlSession.getMapper(ProductMapper.class).countItemBoard(email);
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}
	
	public int countItemBoardByStore(String store_name){
		int cnt = 0;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
				cnt= sqlSession.getMapper(ProductMapper.class).countItemBoardByStore(store_name);
			} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return cnt;
	}
	
	
	public int itemBoardDelete(int itemboard_No){ //실제 삭제가 아닌 삭제상테를 변경하는것임 delete_state = 0 1  1이 삭제 상태 0이 삭제 아님
		int state = -1;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			state = sqlSession.getMapper(ProductMapper.class).itemBoardDelete(itemboard_No);
			if(state>0){//정상처리
				sqlSession.commit();
			}else{//비정상 처리
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return state;
	}
	
	public ItemDTO getAllFromProduct(int itemboard_No, HttpServletRequest request){//상품에 관한 모든 정보 itemdto 에 넣기 수정폼에 원래 있던값 넣기 위해서
		
		SqlSession sqlsession = getSqlSessionFactory().openSession();
		
		ItemDTO item = null;
		List<ItemImg> itemImg = null;
		Bean bean = (Bean)request.getAttribute("bean");
		
		try {
			
			item = sqlsession.getMapper(ProductMapper.class).getAllFromProduct(itemboard_No);
			//item.setItemboard_Contents(item.getItemboard_Contents().trim()); //앞뒤 트림 처리
			itemImg = sqlsession.getMapper(ProductMapper.class).itemImgList(itemboard_No);
			item.setItemImgList(itemImg);
			bean.setCateList(sqlsession.getMapper(ProductMapper.class).cateList(null));//대 카테고리 전부 가져와서 빈에 박기
			//카테고리번호로 그걸 가지고 카테고리명 가지고 오기
			ItemDTO tmp = sqlsession.getMapper(ProductMapper.class).getCatebySubNo(item.getSub_No());
			item.setCategory_Title(tmp.getCategory_Title());
			item.setSub_Title(tmp.getSub_Title()); //System.out.println(tmp.getSub_Title()+":aaaaaaa:"+tmp.getCategory_Title());
			CateDTO cateDTO = new CateDTO(); cateDTO.setCategory_title(tmp.getCategory_Title());
			List<String> subTitle = sqlsession.getMapper(ProductMapper.class).cateList(cateDTO); //대카테 해당하는 서브카테 전부가져와서 넣기
			bean.setSub_cateList(subTitle);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlsession.close();
		}
		
		return item;
	}
	
	
	public int deleteImg(ItemImg img){
		
		int state = -1;
		int state1 = -1;
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			
			state = sqlSession.getMapper(ProductMapper.class).deleteImg(img);
			state1 =sqlSession.getMapper(ProductMapper.class).deleteThumImg(img);
			if(state>0){//정상처리
				sqlSession.commit();
			}else{//비정상 처리
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return state;
		
	}
	
	
}
