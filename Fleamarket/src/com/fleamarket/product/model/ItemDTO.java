package com.fleamarket.product.model;

import java.io.Serializable;
import java.util.List;

public class ItemDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	
	//이미지 여러게 담는곳 
	List<ItemImg> itemImgList;
	
	private int sub_No; //섭카테고리 넘버 
	private String cateName; //대 카테고리 이름
	private String subName; // 소 카테고리 이름
	private String itemboard_Date; //등록일자
	private String local; //거래지역
	private String title; // 상품게시판 의 상품 제목
	private String itemboard_Contents; // 상품게시판의 상품설명
	private String tag;// 태그
	private int hits; //조회수
	private String recommend_Ornot; //추천상품  구현안할듯 지금은
	private String change_Ornot; //교환 가능 여부
	private int item_No; // 상품 번호
	private int itemboard_No = 0; // 게시판글 번호
	private int store_no; // 상점 번호
	
	
	
	public ItemDTO() { }
	
	public ItemDTO(List<ItemImg> itemImgList, int sub_No, String cateName, String subName, String itemboard_Date,
			String local, String title, String itemboard_Contents, String tag, int hits, String recommend_Ornot,
			String change_Ornot, int item_No, int itemboard_No, int store_no) {
		super();
		this.itemImgList = itemImgList;
		this.sub_No = sub_No;
		this.cateName = cateName;
		this.subName = subName;
		this.itemboard_Date = itemboard_Date;
		this.local = local;
		this.title = title;
		this.itemboard_Contents = itemboard_Contents;
		this.tag = tag;
		this.hits = hits;
		this.recommend_Ornot = recommend_Ornot;
		this.change_Ornot = change_Ornot;
		this.item_No = item_No;
		this.itemboard_No = itemboard_No;
		this.store_no = store_no;
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
	public String getItemboard_Date() {
		return itemboard_Date;
	}
	public void setItemboard_Date(String itemboard_Date) {
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
	
	
	
	
	
}
