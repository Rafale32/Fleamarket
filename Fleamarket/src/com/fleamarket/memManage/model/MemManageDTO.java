package com.fleamarket.memManage.model;

import java.io.Serializable;
import java.util.List;

public class MemManageDTO implements Serializable { // 마이바티스는 DTO 로 사용하는 객체 무조건
													// 시리얼라이즈 필수적으로 해줘야함
	private String email; // 이메일
	private String password; // 패스워드
	private String name; // 이름
	private String phone; // 전화번호
	private String address; // 주소
	private String address2; // 상세주소
	private int point; // 포인트
	private String state; // 회원 상태
	private String stop_start; // 정지 시작일
	private String stop_end; // 정지 종료일
	private int admin; // 관리자 상태확인

	public MemManageDTO() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStop_start() {
		return stop_start;
	}

	public void setStop_start(String stop_start) {
		this.stop_start = stop_start;
	}

	public String getStop_end() {
		return stop_end;
	}

	public void setStop_end(String stop_end) {
		this.stop_end = stop_end;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}

}
