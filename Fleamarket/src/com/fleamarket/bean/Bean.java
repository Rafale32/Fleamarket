package com.fleamarket.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.MemberDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.payment.model.DeliveryDTO;


public class Bean {
	
	HttpServletRequest request;
	MemberDTO memberDTO;//회원 정보 가지고 있는객체

	List<ItemDTO> itemList; //아이템 게시판의 정보

	
	// 20180816,재헌 DeliveryDTO 추가
	DeliveryDTO deliveryDTO;

	
	
	public List<ItemDTO> getItemList() {
		return itemList;
	}

	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}

	public Bean(HttpServletRequest request) {
		this.request = request;
	}
	
	public Bean(HttpServletRequest request, MemberDTO memberDTO) {
		super();
		this.request = request;
		this.memberDTO = memberDTO;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

  public DeliveryDTO getDeliveryDTO() {
    return deliveryDTO;
  }

  public void setDeliveryDTO(DeliveryDTO deliveryDTO) {
    this.deliveryDTO = deliveryDTO;
  }
	
	
	
}
