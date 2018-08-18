package com.fleamarket.mainDetail.model;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable{
  private int category_no;
  private String category_title;
  private List<HotItemDTO> hotItemList;
  
  public CategoryDTO(){}

  public CategoryDTO(int category_no, String category_title, List<HotItemDTO> hotItemList) {
    super();
    this.category_no = category_no;
    this.category_title = category_title;
    this.hotItemList = hotItemList;
  }

  public int getCategory_no() {
    return category_no;
  }

  public void setCategory_no(int category_no) {
    this.category_no = category_no;
  }

  public String getCategory_title() {
    return category_title;
  }

  public void setCategory_title(String category_title) {
    this.category_title = category_title;
  }

  public List<HotItemDTO> getHotItemList() {
    return hotItemList;
  }

  public void setHotItemList(List<HotItemDTO> hotItemList) {
    this.hotItemList = hotItemList;
  }

  
  
}
