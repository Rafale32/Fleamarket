package com.fleamarket.bean;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.mainDetail.model.MemberDTO;

public class Bean {
	
	HttpServletRequest request;
	MemberDTO memberDTO;//회원 정보 가지고 있는객체
	
	
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
	
	
}
