package com.fleamarket.payment.model;

import java.io.Serializable;
import java.util.List;

public class PuerchaseDTO_gy implements Serializable {


	
	String title =""; // 판매 물품의 제목
	String store_name =""; // 어떤 상점인지
	String thum_img =""; // 썸네일 이미지.
	String pay_date= ""; //날자
	
	public PuerchaseDTO_gy(){}

	public PuerchaseDTO_gy(String title, String store_name, String thum_img, String pay_date) {
		super();
		this.title = title;
		this.store_name = store_name;
		this.thum_img = thum_img;
		this.pay_date = pay_date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStore_name() {
		return store_name;
	}

	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}

	public String getThum_img() {
		return thum_img;
	}

	public void setThum_img(String thum_img) {
		this.thum_img = thum_img;
	}

	public String getPay_date() {
		return pay_date;
	}

	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}

	
	
	

}
