package com.fleamarket.mainDetail.model;

import java.util.List;

public class CategoryDTO {
  private int category_no;
  private String category_title;
  private List<SubCategoryDTO> subCategoryList;
  
  public CategoryDTO(){}

  public CategoryDTO(int category_no, String category_title, List<SubCategoryDTO> subCategoryList) {
    super();
    this.category_no = category_no;
    this.category_title = category_title;
    this.subCategoryList = subCategoryList;
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

  public List<SubCategoryDTO> getSubCategoryList() {
    return subCategoryList;
  }

  public void setSubCategoryList(List<SubCategoryDTO> subCategoryList) {
    this.subCategoryList = subCategoryList;
  }
  
  
}
