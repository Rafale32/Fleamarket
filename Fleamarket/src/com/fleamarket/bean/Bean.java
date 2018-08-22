package com.fleamarket.bean;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.HotListDTO;
import com.fleamarket.mainDetail.model.ItemDetailDTO;
import com.fleamarket.mainDetail.model.ItemImgDTO;
import com.fleamarket.mainDetail.model.ItemQnaDTO;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.payment.model.DeliveryDTO_jh;
import com.fleamarket.payment.model.PaymentDTO;
import com.fleamarket.payment.model.SpellDTO_jh;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.PageModel;
import com.fleamarket.mainDetail.model.RecommendDTO;
import com.fleamarket.mainDetail.model.StoreInfoDTO;
import com.fleamarket.mainDetail.model.SubCategoryDTO;


public class Bean {
	

	// 20180816,재헌 DeliveryDTO 추가
	DeliveryDTO_jh deliveryDTO_jh; // 배송정보
	// 20180817,재헌 PaymentDTO, SpellDTO_jh 추가
	PaymentDTO paymentDTO; // 결제정보
	SpellDTO_jh spellDTO_jh; //주문정보
	ItemDTO itemDTO; // 상품정보
	MemManageDTO memManageDTO; //회원정보
	
	
	//두연
	List<ItemDTO> itemList;
	private HttpServletRequest request;
	List<String> cateList; //카테고리 리스트  //수정 폼에서는 대 카테로 쓰임
	List<String> sub_cateList; // 물품 수정폼에서 쓰기위해 만듬
	PageModel pageModel;//페이지 처리위한넘
	
	//추천상품리스트 추가
	private List<RecommendDTO> recommend;
	//인기상품리스트 추가(주영)
	private List<HotItemDTO> hotItemList;
	private List<HotListDTO> hotList;
	private List<CategoryDTO> categoryList;
	private List<SubCategoryDTO> subCategoryList;
	private List<ItemImgDTO> itemImgList;
	private ItemDetailDTO itemDetail;
	private StoreInfoDTO storeInfo;
	private List<ItemQnaDTO> itemQnaList;
	private List<ItemDetailDTO> categoryItemList;
	
	
	//--------------------------
	public Bean() {	}
	public Bean(HttpServletRequest request) {
		this.request=request;
	}
	//--------------------------
	
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
	public List<String> getCateList() {
		return cateList;
	}
	public void setCateList(List<String> cateList) {
		this.cateList = cateList;
	}
	public List<String> getSub_cateList() {
		return sub_cateList;
	}
	public void setSub_cateList(List<String> sub_cateList) {
		this.sub_cateList = sub_cateList;
	}
	public PageModel getPageModel() {
		return pageModel;
	}
	public void setPageModel(PageModel pageModel) {
		this.pageModel = pageModel;
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
	public List<HotListDTO> getHotList() {
		return hotList;
	}
	public void setHotList(List<HotListDTO> hotList) {
		this.hotList = hotList;
	}
	public List<CategoryDTO> getCategoryList() {
		return categoryList;
	}
	public void setCategoryList(List<CategoryDTO> categoryList) {
		this.categoryList = categoryList;
	}
	public List<SubCategoryDTO> getSubCategoryList() {
		return subCategoryList;
	}
	public void setSubCategoryList(List<SubCategoryDTO> subCategoryList) {
		this.subCategoryList = subCategoryList;
	}
	public List<ItemImgDTO> getItemImgList() {
		return itemImgList;
	}
	public void setItemImgList(List<ItemImgDTO> itemImgList) {
		this.itemImgList = itemImgList;
	}
	public ItemDetailDTO getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(ItemDetailDTO itemDetail) {
		this.itemDetail = itemDetail;
	}
	public StoreInfoDTO getStoreInfo() {
		return storeInfo;
	}
	public void setStoreInfo(StoreInfoDTO storeInfo) {
		this.storeInfo = storeInfo;
	}
	public List<ItemQnaDTO> getItemQnaList() {
		return itemQnaList;
	}
	public void setItemQnaList(List<ItemQnaDTO> itemQnaList) {
		this.itemQnaList = itemQnaList;
	}
	public List<ItemDetailDTO> getCategoryItemList() {
		return categoryItemList;
	}
	public void setCategoryItemList(List<ItemDetailDTO> categoryItemList) {
		this.categoryItemList = categoryItemList;
	}
	


}
