package com.fleamarket.product.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class ItemDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	
	//이미지 여러게 담는곳 
	List<ItemImg> itemImgList;
	
	private String email;// 현재 사용자 아이디
	private int sub_No; //섭카테고리 넘버
	private String category_Title; //대 카테고리 이름 CATEGORY_TITLE
	private String sub_Title; // 소 카테고리 이름
	private Date itemboard_Date; //등록일자
	private String local; //거래지역
	private String title; // 상품게시판 의 상품 제목
	private String itemboard_Contents; // 상품게시판의 상품설명 //여기에 잠시 담자 썸네일 이미지 하나짜리
	private String tag;// 태그
	private int hits; //조회수
	private int recommend_Ornot; //추천상품  구현안할듯 지금은 
	private int change_Ornot; //교환 가능 여부
	private int item_No; // 상품 번호
	private int itemboard_No = 0; // 게시판글 번호
	private int store_no; // 상점 번호
	
	private int price; //물품 가격
	
	private int favCount; // 다른사람이 찜 한 횟수
	
	private int itemQnaCount; //상품문의 리플 수
	
	private int item_State; // 상품의 상태 새상품 상중하
	private int delivery_Fee;// 배송비 포함 여부
	private int amount; //상품 수량

	// 20180818 재헌 상점이름, 배송 유무
	private String store_name;
//	private String delivery_fee;
	// 20180818 재헌 배송진행상태
	private int delivery_state;
	
	
	
	public ItemDTO() { }
	
	
	
	
	public List<ItemImg> getItemImgList() {
		return itemImgList;
	}



	public void setItemImgList(List<ItemImg> itemImgList) {
		this.itemImgList = itemImgList;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public int getSub_No() {
		return sub_No;
	}



	public void setSub_No(int sub_No) {
		this.sub_No = sub_No;
	}



	public String getCategory_Title() {
		return category_Title;
	}



	public void setCategory_Title(String category_Title) {
		this.category_Title = category_Title;
	}



	public String getSub_Title() {
		return sub_Title;
	}



	public void setSub_Title(String sub_Title) {
		this.sub_Title = sub_Title;
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



	public int getRecommend_Ornot() {
		return recommend_Ornot;
	}



	public void setRecommend_Ornot(int recommend_Ornot) {
		this.recommend_Ornot = recommend_Ornot;
	}



	public int getChange_Ornot() {
		return change_Ornot;
	}



	public void setChange_Ornot(int change_Ornot) {
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



	public int getPrice() {
		return price;
	}



	public void setPrice(int price) {
		this.price = price;
	}



	public int getFavCount() {
		return favCount;
	}



	public void setFavCount(int favCount) {
		this.favCount = favCount;
	}



	public int getItemQnaCount() {
		return itemQnaCount;
	}



	public void setItemQnaCount(int itemQnaCount) {
		this.itemQnaCount = itemQnaCount;
	}



	public int getItem_State() {
		return item_State;
	}



	public void setItem_State(int item_State) {
		this.item_State = item_State;
	}



	public int getDelivery_Fee() {
		return delivery_Fee;
	}



	public void setDelivery_Fee(int delivery_Fee) {
		this.delivery_Fee = delivery_Fee;
	}



	public int getAmount() {
		return amount;
	}



	public void setAmount(int amount) {
		this.amount = amount;
	}



	public String getStore_name() {
		return store_name;
	}



	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}



	public int getDelivery_state() {
		return delivery_state;
	}



	public void setDelivery_state(int delivery_state) {
		this.delivery_state = delivery_state;
	}
	
	
	
	
	@Override
	public String toString() {
		return "ItemDTO [itemImgList=" + itemImgList + ", email=" + email + ", sub_No=" + sub_No + ", category_Title="
				+ category_Title + ", sub_Title=" + sub_Title + ", itemboard_Date=" + itemboard_Date + ", local="
				+ local + ", title=" + title + ", itemboard_Contents=" + itemboard_Contents + ", tag=" + tag + ", hits="
				+ hits + ", recommend_Ornot=" + recommend_Ornot + ", change_Ornot=" + change_Ornot + ", item_No="
				+ item_No + ", itemboard_No=" + itemboard_No + ", store_no=" + store_no + ", price=" + price
				+ ", favCount=" + favCount + ", itemQnaCount=" + itemQnaCount + ", item_State=" + item_State
				+ ", delivery_Fee=" + delivery_Fee + ", amount=" + amount + ", store_name=" + store_name
				+ ", delivery_state=" + delivery_state + "]";
	}
	
	
	
	
}

