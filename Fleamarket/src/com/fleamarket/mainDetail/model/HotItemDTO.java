package com.fleamarket.mainDetail.model;

import java.io.Serializable;

public class HotItemDTO implements Serializable{
  private String category_title;
  private String sub_title;
  private String thum_img;
  private String title;
  private int price;
  private String itemboard_date;
  private int delivery_fee;
  private int hits;
  private int ranking;
  
  public HotItemDTO(){}

  public HotItemDTO(String category_title, String sub_title, String thum_img, String title, int price,
      String itemboard_date, int delivery_fee, int hits, int ranking) {
    super();
    this.category_title = category_title;
    this.sub_title = sub_title;
    this.thum_img = thum_img;
    this.title = title;
    this.price = price;
    this.itemboard_date = itemboard_date;
    this.delivery_fee = delivery_fee;
    this.hits = hits;
    this.ranking = ranking;
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

  public String getThum_img() {
    return thum_img;
  }

  public void setThum_img(String thum_img) {
    this.thum_img = thum_img;
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

  public String getItemboard_date() {
    return itemboard_date;
  }

  public void setItemboard_date(String itemboard_date) {
    this.itemboard_date = itemboard_date;
  }

  public int getDelivery_fee() {
    return delivery_fee;
  }

  public void setDelivery_fee(int delivery_fee) {
    this.delivery_fee = delivery_fee;
  }

  public int getHits() {
    return hits;
  }

  public void setHits(int hits) {
    this.hits = hits;
  }

  public int getRanking() {
    return ranking;
  }

  public void setRanking(int ranking) {
    this.ranking = ranking;
  }
  
  
}
