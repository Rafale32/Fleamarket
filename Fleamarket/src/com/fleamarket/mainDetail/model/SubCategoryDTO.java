package com.fleamarket.mainDetail.model;

public class SubCategoryDTO {
  private int sub_no;
  private String sub_title;
  
  public SubCategoryDTO(){}

  public SubCategoryDTO(int sub_no, String sub_title) {
    super();
    this.sub_no = sub_no;
    this.sub_title = sub_title;
  }

  public int getSub_no() {
    return sub_no;
  }

  public void setSub_no(int sub_no) {
    this.sub_no = sub_no;
  }

  public String getSub_title() {
    return sub_title;
  }

  public void setSub_title(String sub_title) {
    this.sub_title = sub_title;
  }
  
  
}
