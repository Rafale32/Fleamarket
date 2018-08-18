<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!-- 20180818 재헌 가격에 .0빼려고 jstl fmt 추가 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<!-- 20180818 재헌 payment.js => 필요한 메서드 담아둠 -->
<script src="./jh_js/payment.js"></script>
<!-- <script src="../jh_js/payment.js"></script> -->
<script>
  //20180816 천재헌
  //결제페이지 주소검색
  function search_address() {
    new daum.Postcode({
      oncomplete : function(data) {
        // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

        // 각 주소의 노출 규칙에 따라 주소를 조합한다.
        // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
        var fullAddr = ''; // 최종 주소 변수
        var extraAddr = ''; // 조합형 주소 변수

        // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
        if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
          fullAddr = data.roadAddress;

        } else { // 사용자가 지번 주소를 선택했을 경우(J)
          fullAddr = data.jibunAddress;
        }

        // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
        if (data.userSelectedType === 'R') {
          // 법정동명이 있을 경우 추가한다.
          if (data.bname !== '') {
            extraAddr += data.bname;
          }
          // 건물명이 있을 경우 추가한다.
          if (data.buildingName !== '') {
            extraAddr += (extraAddr !== '' ? ', ' + data.buildingName
                : data.buildingName);
          }
          // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
          fullAddr += (extraAddr !== '' ? ' (' + extraAddr + ')' : '');
        }

        // 우편번호와 주소 정보를 해당 필드에 넣는다.
        document.getElementById('delivery_address').value = fullAddr;

        // 커서를 상세주소 필드로 이동한다.
        document.getElementById('delivery_address2').focus();
      }
    }).open();
  }// search_address
  
  //20180818 재헌 포인트전액사용
  function allPoint(point) {
    document.getElementById('setUsePoint').value = point;
  }
  //20180818 재헌 포인트 적용
//   function inputPoint(use) {
//     $('#getUsePoint').text(use);
//   }
  
</script>



<script>
$(function(){
  var total=0;
  $('#allUseButton').click(function() {
//     alert(1);
    var allPoint = parseInt($(this).find('#havePoint').text().replace(/^[^\d.]/,''));
    alert(allPoint);
//     document.getElementById('#usePoint').value = document.getElementById('#havePoint').value;
  });
  
//   $('#setUsePoint').change(function() {
    
    
//   });
  
  
  
});
</script>
<title>주문/결제</title>
</head>

<body>
  <h1>주문/결제</h1>
  <!-- 	주문결제 -->
  <div>
    <!--    enctype="multipart/form-data"> -->
    <form action="insertDelivery.do" method="post">
      수령인 <input type="text" name="delivery_name"
        value="${bean.memManageDTO.name}"><br> 연락처 <input
        type="text" name="delivery_ph"
        value="${bean.memManageDTO.phone}"><br>
      <!--   다음 api getElementById 때문에 id추가 -20180817 천재헌 -->
      배송지 <input type="text" name="delivery_address"
        id="delivery_address" value="${bean.memManageDTO.address}"
        placeholder="주소" size="50"><input type="button"
        value="주소검색" onclick="search_address()"><br> 배송지 <input
        type="text" name="delivery_address2" id="delivery_address2"
        value="${bean.memManageDTO.address2}" placeholder="상세주소"><br>
      배송요청사항 <br> <input type="text" name="contents"
        placeholder="경비실에 맡겨주세요" size="80"><br>
    </form>
  </div>

  <!-- 주문상품   -->
  <div>
    <hr>
    <h2>주문상품</h2>
    <hr>
    <c:set var="price" value="${bean.itemDTO.price}"></c:set>
    <table border="1">
      <tr>
        <td>상점</td>
        <td>${bean.itemDTO.store_name}</td>
      </tr>
      <tr>
        <td>상품명</td>
        <td>${bean.itemDTO.title}</td>
      </tr>
      <tr>
        <td>가격</td>
        <td><fmt:formatNumber value="${price}" />원</td>
      </tr>
    </table>
  </div>

  <!-- 포인트 -->
  <div>

    <hr>
    <h2>포인트</h2>
    <hr>
    <table border="1">
      <tr>
        <td>잔여포인트</td>
        <td id="havePoint">${bean.memManageDTO.point}</td>
      </tr>
      <tr>
        <td>사용</td>
        <td>
<%--           <input type="text" id="usePoint" value="${use}" --%>
<!--                  onchange="inputPoint(value)"> -->
          <input type="text"  id="usePoint" value="${use}">
        </td>
      </tr>
    </table>
    <%--     <c:set var="point" value="${bean.memManageDTO.point}"></c:set> --%>
    <%--     잔여포인트 : <fmt:formatNumber value="${point}" />원<br> --%>
    <%--     <c:set var="use" value="0"></c:set> --%>
    <%--     사용 <input type="text" id="setUsePoint" value="${use}" onchange="inputPoint(value)"> --%>
    <!--         버튼 클릭시 포인트 보이는 부분 변경 20180818 재헌 -->
    <input type="button" id="allUseButton" value="전액 사용">
<%--     <input type="button" value="전액 사용" onclick="allPoint(${point})"> --%>
  </div>

  <!-- 결제금액 -->
  <div>
    <hr>
    <h2>결제금액</h2>
    <hr>
    <table border="1">
      <tr>
        <td>상품금액</td>
        <td id="price">
          <%--         <fmt:formatNumber value="${price}" />원 --%>

        </td>
      </tr>
      <tr>
        <td>배송비</td>
        <td id="delivery_fee">
          <!--  배송 유무 확인 --> <%--           <c:choose> --%> <%--             <c:when test="${bean.itemDTO.delivery_fee == '1'}"> --%>
          <%--               <c:set var="deli_fee" value="2500"></c:set> --%>
          <%--               <fmt:formatNumber value="${deli_fee}" />원 --%>
          <%--           </c:when> --%> <%--             <c:otherwise> --%>
          <%--               <c:set var="deli_fee" value="0"></c:set> --%>
          <!--               무료배송 --> <%--           </c:otherwise> --%>
          <%--           </c:choose> --%>

        </td>
      </tr>

      <tr>
        <td>포인트</td>
        <td id="point">0원</td>
      </tr>
      <tr>
        <td>수수료</td>
        <%--         <td id="fee"><fmt:formatNumber value="1000" />원</td> --%>
        <td id="fee"></td>
      </tr>
      <tr>
        <td>최종결제금액</td>
        <%--         <td id="total"><fmt:formatNumber --%>
        <%--             value="${price+1000+deli_fee}" />원</td> --%>
        <td id="total"></td>
      </tr>
    </table>
  </div>

  <!-- 결제 하단 -->
  <div>
    <input type="checkbox"> 주문 상품정보 및 서비스 이용약관에 모두 동의합니다. <input
      type="submit" value="결제하기" />
  </div>
</body>
</html>