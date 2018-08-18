<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    function search_address() {
        new daum.Postcode({
            oncomplete: function(data) {
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
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }
                

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('delivery_address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('delivery_address2').focus();
            }
        }).open();
    }
</script>
<title>주문/결제</title>
</head>

<body>
  <h1>주문/결제</h1>
  <!-- 	주문결제 -->
  <div>
<!--    enctype="multipart/form-data"> -->
    <form action="insertDelivery.do" method="post">
      수령인 <input type="text" name="delivery_name" value="${bean.memManageDTO.name}"><br>
      연락처 <input type="text" name="delivery_ph" value="${bean.memManageDTO.phone}"><br>
<!--       스크립트에 getElementById 때문에 id추가 -20180817 천재헌 -->
      배송지 <input type="text" name="delivery_address" id="delivery_address"  value="${bean.memManageDTO.address}" placeholder="주소"><input type="button" value="주소검색" onclick="search_address()"><br>
      배송지 <input type="text" name="delivery_address2" id="delivery_address2"  value="${bean.memManageDTO.address2}" placeholder="상세주소"><br>
      배송요청사항 <br>
      <textarea rows="1" cols="50" name="contents" placeholder="경비실에 맡겨주세요"></textarea><br>
    </form>

  </div>
  
  <!-- 주문상품   -->
  <div>
    <hr><h2>주문상품</h2><hr>
    판매자이름<hr>
    물품목록 보이는곳<br>
    
    가격 : ${bean.itemDTO.price}원<br><br>
  </div>
  
  <!-- 포인트 -->
  <div>
    <hr><h2>포인트</h2><hr>
    잔여포인트 : ${bean.memManageDTO.point}<br>
    사용 <input type="text"/><br>
    <input type="button" value="전액 사용" onclick="alert('앙 기모찌')"/>
  </div>
  
  <!-- 결제금액 -->
  <div>
    <hr><h2>결제금액</h2><hr>
    <table border="1">
      <tr><td>상품금액</td><td>${bean.itemDTO.price}원</td></tr>
      <tr><td>배송비</td><td>무료배송</td></tr>
      <tr><td>포인트</td><td>-0원</td></tr>
      <tr><td>수수료</td><td>1000원</td></tr>
      <tr><td>최종결제금액</td><td>${bean.itemDTO.price+1000}원</td></tr>
    </table>
  </div>
  
  <!-- 결제 하단 -->
  <div>
    <input type="checkbox"> 주문 상품정보 및 서비스 이용약관에 모두 동의합니다.
    <input type="submit" value="결제하기"/>
  </div>
</body>
</html>