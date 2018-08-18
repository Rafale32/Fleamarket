package com.fleamarket.mainDetail.model;

import java.io.Serializable;
import java.util.List;

import com.fleamarket.product.model.ItemDTO;


public class ItemDetailDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	private String title;
	private int price;
	private int fav_no;
	private int hits;
	private String itemboard_date;
	private int item_state;
	private int change_ornot;
	private int delivery_fee;
	private String local;
	private String itemboard_contents;
	private String category_title;
	private String sub_title;
	private String tag;
	private List<ItemImgDTO> imgList;
	
	public ItemDetailDTO(){}

  public ItemDetailDTO(String title, int price, int fav_no, int hits, String itemboard_date, int item_state,
      int change_ornot, int delivery_fee, String local, String itemboard_contents, String category_title,
      String sub_title, String tag, List<ItemImgDTO> imgList) {
    super();
    this.title = title;
    this.price = price;
    this.fav_no = fav_no;
    this.hits = hits;
    this.itemboard_date = itemboard_date;
    this.item_state = item_state;
    this.change_ornot = change_ornot;
    this.delivery_fee = delivery_fee;
    this.local = local;
    this.itemboard_contents = itemboard_contents;
    this.category_title = category_title;
    this.sub_title = sub_title;
    this.tag = tag;
    this.imgList = imgList;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getFav_no() {
    return fav_no;
  }

  public void setFav_no(int fav_no) {
    this.fav_no = fav_no;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public String getItemboard_date() {
    return itemboard_date;
  }

  public void setItemboard_date(String itemboard_date) {
    this.itemboard_date = itemboard_date;
  }

  public int getItem_state() {
    return item_state;
  }

  public void setItem_state(int item_state) {
    this.item_state = item_state;
  }

  public int getChange_ornot() {
    return change_ornot;
  }

  public void setChange_ornot(int change_ornot) {
    this.change_ornot = change_ornot;
  }

  public int getDelivery_fee() {
    return delivery_fee;
  }

  public void setDelivery_fee(int delivery_fee) {
    this.delivery_fee = delivery_fee;
  }

  public String getLocal() {
    return local;
  }

  public void setLocal(String local) {
    this.local = local;
  }

  public String getItemboard_contents() {
    return itemboard_contents;
  }

  public void setItemboard_contents(String itemboard_contents) {
    this.itemboard_contents = itemboard_contents;
  }

  public String getCategory_title() {
    return category_title;
  }

  public void setCategory_title(String category_title) {
    this.category_title = category_title;
  }

  public String getSub_title() {
    return sub_title;
  }

  public void setSub_title(String sub_title) {
    this.sub_title = sub_title;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(String tag) {
    this.tag = tag;
  }

  public List<ItemImgDTO> getImgList() {
    return imgList;
  }

  public void setImgList(List<ItemImgDTO> imgList) {
    this.imgList = imgList;
  }
	
	
	
}
