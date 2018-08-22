package com.fleamarket.mainDetail.model;

import java.io.Serializable;

public class RecommendDTO implements Serializable{
  private int item_no;
  private String title;
  private int price;
  private String itemboard_date;
  private int delivery_fee;
  private String thum_img;
  private int itemboard_no;
  
  public RecommendDTO(){}

  public RecommendDTO(int item_no, String title, int price, String itemboard_date, int delivery_fee, String thum_img,
      int itemboard_no) {
    super();
    this.item_no = item_no;
    this.title = title;
    this.price = price;
    this.itemboard_date = itemboard_date;
    this.delivery_fee = delivery_fee;
    this.thum_img = thum_img;
    this.itemboard_no = itemboard_no;
  }

  public int getItem_no() {
    return item_no;
  }

  public void setItem_no(int item_no) {
    this.item_no = item_no;
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

  public String getThum_img() {
    return thum_img;
  }

  public void setThum_img(String thum_img) {
    this.thum_img = thum_img;
  }

  public int getItemboard_no() {
    return itemboard_no;
  }

  public void setItemboard_no(int itemboard_no) {
    this.itemboard_no = itemboard_no;
  }
  
}
