package com.fleamarket.product.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ItemDTO implements Serializable { // 마이바티스는 DTO 로 사용하는 객체 무조건
                                               // 시리얼라이즈 필수적으로 해줘야함

  // 이미지 여러게 담는곳
  List<ItemImg> itemImgList;

  private String email;// 현재 사용자 아이디
  private int sub_No; // 섭카테고리 넘버
  private String cateName; // 대 카테고리 이름
  private String subName; // 소 카테고리 이름
  private Date itemboard_Date; // 등록일자
  private String local; // 거래지역
  private String title; // 상품게시판 의 상품 제목
  private String itemboard_Contents; // 상품게시판의 상품설명
  private String tag;// 태그
  private int hits; // 조회수
  private String recommend_Ornot; // 추천상품 구현안할듯 지금은
  private String change_Ornot; // 교환 가능 여부
  private int item_No; // 상품 번호
  private int itemboard_No = 0; // 게시판글 번호
  private int store_no; // 상점 번호

  private int price; // 물품 가격

  private int favCount; // 다른사람이 찜 한 횟수

  private int itemQnaCount; // 상품문의 리플 수

  // 20180818 재헌 상점이름, 배송 유무
  private String store_name;
  private String delivery_fee;
  // 20180818 재헌 배송진행상태
  private int delivery_state;

  public ItemDTO() {
  }

  public int getItemQnaCount() {
    return itemQnaCount;
  }

  public void setItemQnaCount(int itemQnaCount) {
    this.itemQnaCount = itemQnaCount;
  }

  public int getFavCount() {
    return favCount;
  }

  public void setFavCount(int favCount) {
    this.favCount = favCount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public List<ItemImg> getItemImgList() {
    return itemImgList;
  }

  public void setItemImgList(List<ItemImg> itemImgList) {
    this.itemImgList = itemImgList;
  }

  public int getSub_No() {
    return sub_No;
  }

  public void setSub_No(int sub_No) {
    this.sub_No = sub_No;
  }

  public String getCateName() {
    return cateName;
  }

  public void setCateName(String cateName) {
    this.cateName = cateName;
  }

  public String getSubName() {
    return subName;
  }

  public void setSubName(String subName) {
    this.subName = subName;
  }

  public Date getItemboard_Date() {
    return itemboard_Date;
  }

  public void setItemboard_Date(Date itemboard_Date) {
    this.itemboard_Date = itemboard_Date;
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

  public String getItemboard_Contents() {
    return itemboard_Contents;
  }

  public void setItemboard_Contents(String itemboard_Contents) {
    this.itemboard_Contents = itemboard_Contents;
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

  public String getRecommend_Ornot() {
    return recommend_Ornot;
  }

  public void setRecommend_Ornot(String recommend_Ornot) {
    this.recommend_Ornot = recommend_Ornot;
  }

  public String getChange_Ornot() {
    return change_Ornot;
  }

  public void setChange_Ornot(String change_Ornot) {
    this.change_Ornot = change_Ornot;
  }

  public int getItem_No() {
    return item_No;
  }

  public void setItem_No(int item_No) {
    this.item_No = item_No;
  }

  public int getItemboard_No() {
    return itemboard_No;
  }

  public void setItemboard_No(int itemboard_No) {
    this.itemboard_No = itemboard_No;
  }

  public int getStore_no() {
    return store_no;
  }

  public void setStore_no(int store_no) {
    this.store_no = store_no;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getStore_name() {
    return store_name;
  }

  public void setStore_name(String store_name) {
    this.store_name = store_name;
  }

  public String getDelivery_fee() {
    return delivery_fee;
  }

  public void setDelivery_fee(String delivery_fee) {
    this.delivery_fee = delivery_fee;
  }

  public int getDelivery_state() {
    return delivery_state;
  }

  public void setDelivery_state(int delivery_state) {
    this.delivery_state = delivery_state;
  }
  
  

}
