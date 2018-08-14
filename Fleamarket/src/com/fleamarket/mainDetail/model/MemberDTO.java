package com.fleamarket.mainDetail.model;

public class MemberDTO {
	private int authority; //로그인 한 사람이 관리자인지 일반 사용자 인지 구분 0 은 일반 사용자 1은 관리자
	private String id; // 현재 로그인 중인 ID 로그인중이 아니라면 null 이겠지
	private String nickname; // 현재 로그인중인 회원의 닉네임 로그인 중이 아니면 null 이겠지
	
	public MemberDTO() {	}
	
	
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public MemberDTO(int authority, String id, String nickname) {
		super();
		this.authority = authority;
		this.id = id;
		this.nickname = nickname;
	}
	
	
}
