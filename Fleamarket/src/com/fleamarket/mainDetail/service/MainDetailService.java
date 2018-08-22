package com.fleamarket.mainDetail.service;

import java.util.ArrayList;
import java.util.List;

import com.fleamarket.mainDetail.model.HotListDTO;
import com.fleamarket.mainDetail.model.ItemDetailDTO;
import com.fleamarket.mainDetail.model.ItemImgDTO;
import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.MainDetailDAO;
import com.fleamarket.mainDetail.model.RecommendDTO;
import com.fleamarket.mainDetail.model.StoreInfoDTO;
import com.fleamarket.mainDetail.model.SubCategoryDTO;

public class MainDetailService {
  private static MainDetailService service = new MainDetailService();
  private static MainDetailDAO dao;
  
  public static MainDetailService getInstance(){
    dao = MainDetailDAO.getInstance();
    return service;
  }
  
  
  public List<RecommendDTO> recommend(){
    List<RecommendDTO> recoList = new ArrayList<RecommendDTO>();
    recoList = dao.recommend();
    return recoList;
  }
  
  public List<HotItemDTO> hotItemList(){
    List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    return hotItemList;
  }
  
  public List<CategoryDTO> categoryList(){
    List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
    List<SubCategoryDTO> subCategoryList = new ArrayList<SubCategoryDTO>();
    categoryList = dao.categoryList();
    subCategoryList = dao.subCategoryList();
    
    for(int i=0; i<categoryList.size(); i++){
      List<SubCategoryDTO> list = new ArrayList<SubCategoryDTO>();
      for(int j=0; j<subCategoryList.size(); j++){
        if(categoryList.get(i).getCategory_no()==subCategoryList.get(j).getCategory_no()){
          list.add(subCategoryList.get(j));
        }
      }
      categoryList.get(i).setSubCategory(list);
    }
    return categoryList;
  }
  
  public List<ItemImgDTO> itemImgList(int itemboard_no){
    List<ItemImgDTO> itemImgList = new ArrayList<ItemImgDTO>();
    itemImgList = dao.itemImgList(itemboard_no);
    return itemImgList;
  }
  
  public ItemDetailDTO itemDetail(int itemboard_no){
    ItemDetailDTO itemDetail = new ItemDetailDTO();
    itemDetail = dao.itemDetail(itemboard_no);
    return itemDetail;
  }
  
  //큰 카테고리 서비스 목록에 인기상품 리스트를 큰카테고리에 맞게 리스트로 나눠서 각각 분류하는 메소드
  public List<HotListDTO> hotList(){
    List<HotListDTO> hotList = new ArrayList<HotListDTO>();
    hotList = dao.hotList();
    List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    
    for(int i=0; i<hotList.size(); i++){
      List<HotItemDTO> list = new ArrayList<HotItemDTO>();
      for(int j=0; j<hotItemList.size(); j++){
        if(hotList.get(i).getCategory_title().equals(hotItemList.get(j).getCategory_title())){
          list.add(hotItemList.get(j));
        }
      }
      hotList.get(i).setHotItemList(list);
    }
    return hotList;
  }
  
  public StoreInfoDTO storeInfo(int itemboard_no){
    StoreInfoDTO storeInfo = new StoreInfoDTO();
    storeInfo = dao.storeInfo(itemboard_no);
    List<ItemDetailDTO> storeItemList = new ArrayList<ItemDetailDTO>();
    storeItemList = dao.storeItemList(storeInfo.getStore_no());
    storeInfo.setItemList(storeItemList);
    return storeInfo;
  }
}
