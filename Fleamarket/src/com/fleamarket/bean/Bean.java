package com.fleamarket.bean;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.mainDetail.model.HotItemDTO;
import com.fleamarket.mainDetail.model.MemberDTO;
import com.fleamarket.mainDetail.model.RecommendDTO;

public class Bean {
	
	private HttpServletRequest request;
	private MemberDTO memberDTO;
	//추천상품리스트 추가(주영)
	private List<RecommendDTO> recommend;
	//인기상품리스트 추가(주영)
	private List<HotItemDTO> hotItemList;
	private List<CategoryDTO> categoryList;
	
	public Bean(HttpServletRequest request) {
		this.request = request;
	}
	
	public Bean() { }

  public Bean(HttpServletRequest request, MemberDTO memberDTO,
      List<RecommendDTO> recommend, List<HotItemDTO> hotItemList,
      List<CategoryDTO> categoryList) {
    super();
    this.request = request;
    this.memberDTO = memberDTO;
    this.recommend = recommend;
    this.hotItemList = hotItemList;
    this.categoryList = categoryList;
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
	
	
}
