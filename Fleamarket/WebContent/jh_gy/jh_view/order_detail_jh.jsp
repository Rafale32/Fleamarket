<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- 20180822 재헌-->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="/Fleamarket/dy/jquery-3.1.0.js"></script>
<title>주문 상세 내역</title>
</head>
<body>
  <h1>주문 상세 내역</h1>
  <!-- 주문정보 -->
  <div>

    <hr>
    <h2>주문정보</h2>
    <hr>
    
    <div>
      <table border="1">
        <tr>
          <td>주문상태</td>
          <td>${bean.itemDTO.delivery_state}</td>
        </tr>
        <!--         <tr><td>결제방법</td><td>신용카드</td></tr> -->
        <tr>
          <td>주문번호</td>
          <td>${bean.spellDTO_jh.spell_no}</td>
        </tr>
        <tr>
          <td>주문일시</td>
          <td>${bean.spellDTO_jh.spell_date}</td>
        </tr>
      </table>
    </div>
    <!-- 물품정보 -->
    <div>
      <h3>${bean.itemDTO.store_name}</h3> <hr>
      <table border="1">
        <tr>
          <td rowspan="3">이미지</td>
          <td>상품명</td>
          <td>${bean.itemDTO.title}</td>
        </tr>
        <tr>
          <td>가격</td>
          <td>${bean.itemDTO.price}</td>
        </tr>

      </table>
    </div>
    <hr>

  </div>

  <!--   결제정보 -->
  <div>
    <hr>
    <h2>결제정보</h2>
    <hr>
    <table border="1">
      <tr>
        <td>상품금액</td>
        <td>${bean.itemDTO.price }</td>
      </tr>
      <tr>
        <td>배송비</td>
        <td>
        <!--  배송 유무 확인 -->
          <c:choose>
            <c:when test="${bean.itemDTO.delivery_fee == '1'}">
              <c:set var="deli_fee" value="2500"></c:set>
              <fmt:formatNumber value="${deli_fee}" />원
            </c:when>
            <c:otherwise>
              <c:set var="deli_fee" value="0"></c:set>
               무료배송
            </c:otherwise>
          </c:choose>
        </td>
      </tr>
      <tr>
        <td>번개포인트</td>
        <td>${bean.paymentDTO_jh.use_point }</td>
      </tr>
      <tr>
        <td>최종결제금액</td>
        <td>${bean.paymentDTO_jh.pay_price }</td>
      </tr>
    </table>
  </div>

  <!--   배송지 -->
  <div>
    <hr>
    <h2>배송지</h2>
    <hr>
    <table border="1">
      <tr>
        <td>수령인</td>
        <td>홍길동</td>
      </tr>
      <tr>
        <td>연락처</td>
        <td>01012345678</td>
      </tr>
      <tr>
        <td>배송지</td>
        <td>서울특별시 구로구 새말로18길 64</td>
      </tr>
      <tr>
        <td></td>
        <td>address2</td>
      </tr>
      <tr>
        <td>요청사항</td>
        <td>직접수령하겠습니다.</td>
      </tr>
    </table>
  </div>
  <hr>

  <!--   버튼 -->
  <div>
    <input type="button" value="배송조회"> <input type="button"
      value="리뷰쓰기">
  </div>

</body>
</html>