package com.fleamarket.mainDetail.model;

import java.io.Serializable;

import com.fleamarket.product.model.ItemDTO;

public class MainDetailDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	private int sub_no;
	private String itemboard_date;
	private String local;
	private String title;
	private String itemboard_contents;
	private String tag;
	private int hits;
	private String recommend_ornot;
	private String change_ornot;
	private int item_no;
	private int itemboard_no;
	private int store_no;
	private ItemDTO product;
	
	public MainDetailDTO() {}

  public MainDetailDTO(int sub_no, String itemboard_date, String local, String title, String itemboard_contents,
      String tag, int hits, String recommend_ornot, String change_ornot, int item_no, int itemboard_no, int store_no,
      ItemDTO product) {
    super();
    this.sub_no = sub_no;
    this.itemboard_date = itemboard_date;
    this.local = local;
    this.title = title;
    this.itemboard_contents = itemboard_contents;
    this.tag = tag;
    this.hits = hits;
    this.recommend_ornot = recommend_ornot;
    this.change_ornot = change_ornot;
    this.item_no = item_no;
    this.itemboard_no = itemboard_no;
    this.store_no = store_no;
    this.product = product;
  }

  public int getSub_no() {
    return sub_no;
  }

  public void setSub_no(int sub_no) {
    this.sub_no = sub_no;
  }

  public String getItemboard_date() {
    return itemboard_date;
  }

  public void setItemboard_date(String itemboard_date) {
    this.itemboard_date = itemboard_date;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getItemboard_contents() {
    return itemboard_contents;
  }

  public void setItemboard_contents(String itemboard_contents) {
    this.itemboard_contents = itemboard_contents;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public String getRecommend_ornot() {
    return recommend_ornot;
  }

  public void setRecommend_ornot(String recommend_ornot) {
    this.recommend_ornot = recommend_ornot;
  }

  public String getChange_ornot() {
    return change_ornot;
  }

  public void setChange_ornot(String change_ornot) {
    this.change_ornot = change_ornot;
  }

  public int getItem_no() {
    return item_no;
  }

  public void setItem_no(int item_no) {
    this.item_no = item_no;
  }

  public int getItemboard_no() {
    return itemboard_no;
  }

  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
  }

  public int getStore_no() {
    return store_no;
  }

  public void setStore_no(int store_no) {
    this.store_no = store_no;
  }

  public ItemDTO getProduct() {
    return product;
  }

  public void setProduct(ItemDTO product) {
    this.product = product;
  }
	
	
}
