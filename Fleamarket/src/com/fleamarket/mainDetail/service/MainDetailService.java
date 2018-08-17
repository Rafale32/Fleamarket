package com.fleamarket.mainDetail.service;

import java.util.ArrayList;
import java.util.List;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.MainDetailDAO;
import com.fleamarket.mainDetail.model.RecommendDTO;

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
  
  public List<CategoryDTO> hotList(){
    List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
    categoryList = dao.categoryList();
    List<HotItemDTO> hotList = new ArrayList<HotItemDTO>();
    hotList = dao.hotItemList();
    
    for(int i=0; i<categoryList.size(); i++){
      List<HotItemDTO> list = new ArrayList<HotItemDTO>();
      for(int j=0; j<hotList.size(); j++){
        if(categoryList.get(i).getCategory_title().equals(hotList.get(j).getCategory_title())){
          list.add(hotList.get(j));
        }
      }
      categoryList.get(i).setHotItemList(list);
    }
    return categoryList;
  }
  
}
