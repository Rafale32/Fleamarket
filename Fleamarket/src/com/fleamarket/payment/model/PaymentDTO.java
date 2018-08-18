package com.fleamarket.payment.model;

import java.io.Serializable;

public class PaymentDTO implements Serializable{ //마이바티스는 DTO 로 사용하는 객체 무조건 시리얼라이즈 필수적으로 해줘야함  
	private int pay_no;
	private String pay_date;
	private int pay_price;
	private int spell_no;

	PaymentDTO(){}
	
  public PaymentDTO(int pay_no, String pay_date, int pay_price, int spell_no) {
    super();
    this.pay_no = pay_no;
    this.pay_date = pay_date;
    this.pay_price = pay_price;
    this.spell_no = spell_no;
  }

  public int getPay_no() {
    return pay_no;
  }

  public void setPay_no(int pay_no) {
    this.pay_no = pay_no;
  }

  public String getPay_date() {
    return pay_date;
  }

  public void setPay_date(String pay_date) {
    this.pay_date = pay_date;
  }

  public int getPay_price() {
    return pay_price;
  }

  public void setPay_price(int pay_price) {
    this.pay_price = pay_price;
  }

  public int getSpell_no() {
    return spell_no;
  }

  public void setSpell_no(int spell_no) {
    this.spell_no = spell_no;
  }
  
 
	
}
