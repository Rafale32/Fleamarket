package com.fleamarket.memManage.model;

import java.io.Serializable;

public class MemManageDTO implements Serializable { // 마이바티스는 DTO 로 사용하는 객체 무조건
                                                    // 시리얼라이즈 필수적으로 해줘야함
  private String email;
  private String password;
  private String name;
  private String phone;
  private String address;
  private String address2;
  private int point;
  private String state;
  private String stop_start;
  private String stop_end;
  private int admin;

  public MemManageDTO() {
  }

  public MemManageDTO(String email, String password, String name, String phone, String address, String address2,
      int point, String state, String stop_start, String stop_end, int admin) {
    super();
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
    this.address = address;
    this.address2 = address2;
    this.point = point;
    this.state = state;
    this.stop_start = stop_start;
    this.stop_end = stop_end;
    this.admin = admin;
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
