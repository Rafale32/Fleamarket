package com.fleamarket.bean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PaymentDTO;
import com.fleamarket.payment.model.SpellDTO_jh;
import com.fleamarket.product.model.ItemDTO;

import com.fleamarket.mainDetail.model.RecommendDTO;


public class Bean {
	

	// 20180816,재헌 DeliveryDTO 추가
	DeliveryDTO_jh deliveryDTO_jh; // 배송정보
	// 20180817,재헌 PaymentDTO, orderDTO 추가
	PaymentDTO paymentDTO; // 결제정보
	SpellDTO_jh spellDTO_jh; //주문정보
	ItemDTO itemDTO; // 상품정보
	MemManageDTO memManageDTO; //회원정보
	
	//두연
	List<ItemDTO> itemList;
	private HttpServletRequest request;
	
	//추천상품리스트 추가(주영)
	private List<RecommendDTO> recommend;
	//인기상품리스트 추가(주영)
	private List<HotItemDTO> hotItemList;
	private List<CategoryDTO> categoryList;
	
	
	public Bean(HttpServletRequest request) {
		this.request = request;
	}
	
	public DeliveryDTO_jh getDeliveryDTO_jh() {
		return deliveryDTO_jh;
	}
	public void setDeliveryDTO_jh(DeliveryDTO_jh deliveryDTO_jh) {
		this.deliveryDTO_jh = deliveryDTO_jh;
	}
	public PaymentDTO getPaymentDTO() {
		return paymentDTO;
	}
	public void setPaymentDTO(PaymentDTO paymentDTO) {
		this.paymentDTO = paymentDTO;
	}
	public SpellDTO_jh getSpellDTO_jh() {
		return spellDTO_jh;
	}
	public void setSpellDTO_jh(SpellDTO_jh spellDTO_jh) {
		this.spellDTO_jh = spellDTO_jh;
	}
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public MemManageDTO getMemManageDTO() {
		return memManageDTO;
	}
	public void setMemManageDTO(MemManageDTO memManageDTO) {
		this.memManageDTO = memManageDTO;
	}
	public List<ItemDTO> getItemList() {
		return itemList;
	}
	public void setItemList(List<ItemDTO> itemList) {
		this.itemList = itemList;
	}
	public HttpServletRequest getRequest() {
		return request;
	}
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}
	public List<RecommendDTO> getRecommend() {
		return recommend;
	}
	public void setRecommend(List<RecommendDTO> recommend) {
		this.recommend = recommend;
	}
	public List<HotItemDTO> getHotItemList() {
		return hotItemList;
	}
	public void setHotItemList(List<HotItemDTO> hotItemList) {
		this.hotItemList = hotItemList;
	}
	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}
	public Bean(DeliveryDTO_jh deliveryDTO_jh, PaymentDTO paymentDTO, SpellDTO_jh spellDTO_jh, ItemDTO itemDTO,
			MemManageDTO memManageDTO, List<ItemDTO> itemList, HttpServletRequest request, List<RecommendDTO> recommend,
			List<HotItemDTO> hotItemList, List<CategoryDTO> categoryList) {
		super();
		this.deliveryDTO_jh = deliveryDTO_jh;
		this.paymentDTO = paymentDTO;
		this.spellDTO_jh = spellDTO_jh;
		this.itemDTO = itemDTO;
		this.memManageDTO = memManageDTO;
		this.itemList = itemList;
		this.request = request;
		this.recommend = recommend;
		this.hotItemList = hotItemList;
		this.categoryList = categoryList;
	}


}
