package com.fleamarket.mainDetail.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.HotListDTO;
import com.fleamarket.mainDetail.model.ItemDetailDTO;
import com.fleamarket.mainDetail.model.ItemImgDTO;
import com.fleamarket.mainDetail.model.ItemQnaDTO;
import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.MainDetailDAO;
import com.fleamarket.mainDetail.model.RecommendDTO;
import com.fleamarket.mainDetail.model.StoreInfoDTO;
import com.fleamarket.mainDetail.model.SubCategoryDTO;

public class MainDetailService {
  private static MainDetailService service = new MainDetailService();
  private static MainDetailDAO dao;

  public static MainDetailService getInstance() {
    dao = MainDetailDAO.getInstance();
    return service;
  }

  public List<RecommendDTO> recommend() {
    List<RecommendDTO> recoList = new ArrayList<RecommendDTO>();
    recoList = dao.recommend();
    
    for(int i=0; i<recoList.size(); i++){
      recoList.get(i).setImgList(dao.itemImgList(recoList.get(i).getItemboard_no()));
      recoList.get(i).setItemboard_date(time(recoList.get(i).getItemboard_date()));
    }
    
    return recoList;
  }

  public List<HotItemDTO> hotItemList() {
    List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    
    for(int i=0; i<hotItemList.size(); i++){
      hotItemList.get(i).setImgList(dao.itemImgList(hotItemList.get(i).getItemboard_no()));
    }
    return hotItemList;
  }

  public List<CategoryDTO> categoryList() {
    List<CategoryDTO> categoryList = new ArrayList<CategoryDTO>();
    List<SubCategoryDTO> subCategoryList = new ArrayList<SubCategoryDTO>();
    categoryList = dao.categoryList();
    subCategoryList = dao.subCategoryList();

    for (int i = 0; i < categoryList.size(); i++) {
      List<SubCategoryDTO> list = new ArrayList<SubCategoryDTO>();
      for (int j = 0; j < subCategoryList.size(); j++) {
        if (categoryList.get(i).getCategory_no() == subCategoryList.get(j).getCategory_no()) {
          list.add(subCategoryList.get(j));
        }
      }
      categoryList.get(i).setSubCategory(list);
    }
    return categoryList;
  }

  public List<ItemImgDTO> itemImgList(int itemboard_no) {
    List<ItemImgDTO> itemImgList = new ArrayList<ItemImgDTO>();
    itemImgList = dao.itemImgList(itemboard_no);
    return itemImgList;
  }
    
  public String time(String itemTime){
  //아이템상세글 작성시간 처리
    Date date = new Date();
    SimpleDateFormat f = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
    String today = f.format(date);
    String itemDate = itemTime;
    
    List<Integer> tlist = new ArrayList<Integer>();
    List<Integer> ilist = new ArrayList<Integer>();
    tlist.add(Integer.parseInt(today.substring(0,4)));
    tlist.add(Integer.parseInt(today.substring(5,7)));
    tlist.add(Integer.parseInt(today.substring(8,10)));
    tlist.add(Integer.parseInt(today.substring(11,13)));
    tlist.add(Integer.parseInt(today.substring(14,16)));
    tlist.add(Integer.parseInt(today.substring(17,19)));
    
    ilist.add(Integer.parseInt(itemDate.substring(0,4)));
    ilist.add(Integer.parseInt(itemDate.substring(5,7)));
    ilist.add(Integer.parseInt(itemDate.substring(8,10)));
    ilist.add(Integer.parseInt(itemDate.substring(11,13)));
    ilist.add(Integer.parseInt(itemDate.substring(14,16)));
    ilist.add(Integer.parseInt(itemDate.substring(17,19)));
    String val1 = null;
    String val2 = null;
    int cnt = 0;
    for(int i=0; i<6; i++){
      if((tlist.get(i)-ilist.get(i))!=0){
        val1 = String.valueOf((tlist.get(i)-ilist.get(i)));
        break;
      }
      cnt++;
    }
    if(cnt == 0){
      val2 = "년 전";
    }else if(cnt == 1){
      val2 = "달 전";
    }else if(cnt == 2){
      val2 = "일 전";
    }else if(cnt == 3){
      val2 = "시간 전";
    }else if(cnt == 4){
      val2 = "분 전";
    }else if(cnt == 5){
      val2 = "초 전";
    }
    String time = val1+val2;
    
    return time;
  }
  
  public ItemDetailDTO itemDetail(int itemboard_no) {
    ItemDetailDTO itemDetail = new ItemDetailDTO();
    itemDetail = dao.itemDetail(itemboard_no);
    
    itemDetail.setHits(itemDetail.getHits()+1);
    itemDetail.setItemboard_date(time(itemDetail.getItemboard_date()));

    //태그쪼개서 태그리스트 처리
    if (itemDetail.getTag() == null) {
      return itemDetail;
    } else {
      List<String> strList = new ArrayList<String>();
      StringTokenizer st = new StringTokenizer(itemDetail.getTag(), ",");

      while (st.hasMoreTokens()) {
        strList.add(st.nextToken());
      }
      itemDetail.setTagList(strList);

      return itemDetail;
    }
  }

  // 큰 카테고리 서비스 목록에 인기상품 리스트를 큰카테고리에 맞게 리스트로 나눠서 각각 분류하는 메소드
  public List<HotListDTO> hotList() {
    List<HotListDTO> hotList = new ArrayList<HotListDTO>();
    hotList = dao.hotList();
    List<HotItemDTO> hotItemList = new ArrayList<HotItemDTO>();
    hotItemList = dao.hotItemList();
    
    for(int i=0; i<hotItemList.size(); i++){
      hotItemList.get(i).setImgList(dao.itemImgList(hotItemList.get(i).getItemboard_no()));
    }
    
    for (int i = 0; i < hotList.size(); i++) {
      List<HotItemDTO> list = new ArrayList<HotItemDTO>();
      for (int j = 0; j < hotItemList.size(); j++) {
        if (hotList.get(i).getCategory_title().equals(hotItemList.get(j).getCategory_title())) {
          hotItemList.get(j).setItemboard_date(time(hotItemList.get(j).getItemboard_date()));
          list.add(hotItemList.get(j));
        }
      }
      hotList.get(i).setHotItemList(list);
    }
    return hotList;
  }

  public StoreInfoDTO storeInfo(int itemboard_no) {
    StoreInfoDTO storeInfo = new StoreInfoDTO();
    storeInfo = dao.storeInfo(itemboard_no);
    List<ItemDetailDTO> storeItemList = new ArrayList<ItemDetailDTO>();
    storeItemList = dao.storeItemList(storeInfo.getStore_no(), itemboard_no);
    storeInfo.setItemList(storeItemList);
    storeInfo.setItemCount(storeItemList.size());
    
    for(int i=0; i<storeItemList.size(); i++){
      storeItemList.get(i).setImgList(dao.itemImgList(storeItemList.get(i).getItemboard_no()));
    }
    
    
    return storeInfo;
  }

  public List<ItemQnaDTO> itemQnaList(int itemboard_no) {
    List<ItemQnaDTO> listQna = new ArrayList<ItemQnaDTO>();
    listQna = dao.listQna(itemboard_no);

    for (int i = 0; i < listQna.size(); i++) {
      ItemQnaDTO storeNoInfo = new ItemQnaDTO();
      
      storeNoInfo = dao.storeNoInfo(listQna.get(i).getEmail());
      listQna.get(i).setStore_no(storeNoInfo.getStore_no());
      listQna.get(i).setstore_name(storeNoInfo.getstore_name());
    }
    return listQna;
  }

  public int insertQna(HttpServletRequest request) throws Exception {
    ItemQnaDTO itemQna = new ItemQnaDTO();
    
    System.out.println(request.getParameter("contents"));
    System.out.println(request.getParameter("email"));
    System.out.println(request.getParameter("itemboard_no"));
    
    itemQna.setContents(request.getParameter("contents"));
    itemQna.setEmail(request.getParameter("email"));
    String str = request.getParameter("itemboard_no");
    int itemboard_no = 0;
    if (str != null) {
      itemboard_no = Integer.parseInt(str);
    }
    itemQna.setItemboard_no(itemboard_no);

    return dao.insertQna(itemQna);
  }

  public int deleteQna(HttpServletRequest request) throws Exception {
    return dao.deleteQna(Integer.parseInt(request.getParameter("item_qna_no")));
  }

  public List<ItemDetailDTO> categoryItemList(int category_no) {
    List<ItemDetailDTO> categoryItemList = new ArrayList<ItemDetailDTO>();
    categoryItemList = dao.categoryItemList(category_no);
    
    for(int i=0; i<categoryItemList.size(); i++){
      categoryItemList.get(i).setImgList(dao.itemImgList(categoryItemList.get(i).getItemboard_no()));
    }
    
    return categoryItemList;
  }

}
