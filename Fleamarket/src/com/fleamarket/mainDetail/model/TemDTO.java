package com.fleamarket.mainDetail.model;

import java.io.Serializable;

public class TemDTO implements Serializable{
  private int item_no;
  private int price;
  private int amount;
  private String delivery_fee;
  private int delivery_no;
  private int delivery_state;
  private int item_state;
  
  public TemDTO(){}

  public TemDTO(int item_no, int price, int amount, String delivery_fee, int delivery_no, int delivery_state,
      int item_state) {
    super();
    this.item_no = item_no;
    this.price = price;
    this.amount = amount;
    this.delivery_fee = delivery_fee;
    this.delivery_no = delivery_no;
    this.delivery_state = delivery_state;
    this.item_state = item_state;
  }

  public int getItem_no() {
    return item_no;
  }

  public void setItem_no(int item_no) {
    this.item_no = item_no;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public String getDelivery_fee() {
    return delivery_fee;
  }

  public void setDelivery_fee(String delivery_fee) {
    this.delivery_fee = delivery_fee;
  }

  public int getDelivery_no() {
    return delivery_no;
  }

  public void setDelivery_no(int delivery_no) {
    this.delivery_no = delivery_no;
  }

  public int getDelivery_state() {
    return delivery_state;
  }

  public void setDelivery_state(int delivery_state) {
    this.delivery_state = delivery_state;
  }

  public int getItem_state() {
    return item_state;
  }

  public void setItem_state(int item_state) {
    this.item_state = item_state;
  }
  
}
