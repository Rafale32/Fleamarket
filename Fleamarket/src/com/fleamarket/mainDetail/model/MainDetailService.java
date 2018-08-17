package com.fleamarket.mainDetail.model;

import java.util.ArrayList;
import java.util.List;

public class MainDetailService {
  private static MainDetailService service = new MainDetailService();
  private static MainDetailDAO dao;
  
  public static MainDetailService getInstance(){
    dao = MainDetailDAO.getInstance();
    return service;
  }
  
  public List<MainDetailDTO> recommendItemList(){
    List<MainDetailDTO> mainList = new ArrayList<MainDetailDTO>();
    List<TemDTO> itemList = new ArrayList<TemDTO>();
    mainList = dao.recommendList();
    itemList = dao.recommendItem();
    for(int i=0; i<mainList.size(); i++){
      mainList.get(i).setTem(itemList.get(i));
    }
   return mainList;
  }
  
}
