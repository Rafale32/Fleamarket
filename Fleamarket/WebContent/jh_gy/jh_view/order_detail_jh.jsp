<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 상세 내역</title>
</head>
<body>
<h1>주문 상세 내역</h1>
<!-- 주문정보 -->
	<div>
  <hr><h2>주문정보</h2><hr>
    <div>
      <table border="1">
        <tr><td>주문상태</td><td>거래완료</td></tr>
        <tr><td>결제방법</td><td>신용카드</td></tr>
        <tr><td>주문번호</td><td>1321</td></tr>
        <tr><td>주문일시</td><td>2018-08-09</td></tr>
      </table>
    </div>
    <div>
      <hr><h3>상점이름</h3><hr>
        구매물품
    </div>
  </div>
  
<!--   결제정보 -->
  <div>
  <hr><h2>결제정보</h2><hr>
    <table border="1">
      <tr><td>상품금액</td><td>200</td></tr>
      <tr><td>배송비</td><td>무료배송</td></tr>
      <tr><td>번개포인트</td><td>-200원</td></tr>
      <tr><td>최종결제금액</td><td>1000원</td></tr>
    </table>
  </div>
  
<!--   배송지 -->
  <div>
  <hr><h2>배송지</h2><hr>
    <table border="1">
      <tr><td>수령인</td><td>홍길동</td></tr>
      <tr><td>연락처</td><td>01012345678</td></tr>
      <tr><td>배송지</td><td>서울특별시 구로구 새말로18길 64</td></tr>
      <tr><td></td><td>address2</td></tr>
      <tr><td>요청사항</td><td>직접수령하겠습니다.</td></tr>
    </table>
  </div>
  <hr>
  
<!--   버튼 -->
  <div>
    <input type="button" value="배송조회">
    <input type="button" value="리뷰쓰기">
  </div>
  
</body>
</html>