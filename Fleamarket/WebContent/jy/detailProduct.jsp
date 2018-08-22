<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  $(function() {
    $('.insertQnaBtn').click(function() {

    });
  });
</script>
</head>
<body>
	<div class="category">
		<h3>카테고리목록</h3>
		<c:forEach var="list" items="${bean.categoryList}">
			<a href="">${list.category_title }</a>
			<c:forEach var="subList" items="${list.subCategory}">
				<a href="">${subList.sub_title }</a>
			</c:forEach>
		</c:forEach>
	</div>
	<div class="itemDetail">
		<h3>상품정보</h3>
		<ul>
			이미지
			<c:forEach var="imgList" items="${bean.itemImgList}">
				<li>${imgList.thum_img}</li>
			</c:forEach>
			상품명
			<li>${bean.itemDetail.title}</li> 가격
			<li>${bean.itemDetail.price}</li> 찜
			<li>${bean.itemDetail.fav_no}</li> 조회수
			<li>${bean.itemDetail.hits}</li> 작성시간
			<li>${bean.itemDetail.itemboard_date}</li> 상품상태
			<li>${bean.itemDetail.item_state}</li> 교환여부
			<li>${bean.itemDetail.change_ornot}</li> 배송비
			<li>${bean.itemDetail.delivery_fee}</li> 거래지역
			<li>${bean.itemDetail.local}</li> 상품정보
			<li>${bean.itemDetail.itemboard_contents}</li> 카테고리
			<li>${bean.itemDetail.category_title}</li>
			<li>${bean.itemDetail.sub_title}</li> 상품태그
			<!-- 해시태그 목록 -->
			<c:if test="${bean.itemDetail.tagList ne null}">
				<c:forEach var="list" items="${bean.itemDetail.tagList}">
					<a href="">${list }</a>
				</c:forEach>
			</c:if>
		</ul>
	</div>
  <!-- 연결 물품번호 넘김 20180822 재헌 -->
	<a href="/Fleamarket/payment/payment.do?item_no=${bean.itemDetail.item_no }">안심결제</a>
	<br>
	<div class="storeInfo">
		<h3>상점정보</h3>
		<a href="/Fleamarket/product/productlist.do?store_name=${bean.storeInfo.store_name }">${bean.storeInfo.store_name }</a>
		<h4>상점 내 다른 아이템</h4>
		<c:forEach var="itemList" items="${bean.storeInfo.itemList}">
			<a href="">${itemList.thum_img }</a>
		</c:forEach>
	</div>

	<div class="itemQna">
		<h3>상품문의</h3>
		<c:if test="${member.name ne null}">
			<form action="qnaAction.do" method="post">
				<input type="hidden" name="itemboard_no"
					value="${bean.itemDetail.itemboard_no}"> <input
					type="hidden" name="name" value="${member.name}"> 내용 <br>
				<textarea rows="6" cols="70" name="contents"></textarea>
				<br> <input class="insertQnaBtn" type="submit" value="등록">
				<br>
			</form>
		</c:if>

		<c:forEach var="qnaList" items="${bean.itemQnaList}">
			<a href="">${qnaList.name }</a>
			<a href="">${qnaList.store_no }</a>
			<a
				href="deleteQnaAction.do?item_qna_no=${qnaList.item_qna_no}&itemboard_no=${bean.itemDetail.itemboard_no}">삭제하기</a>

			<br>
			${qnaList.contents}<br>
		</c:forEach>
	</div>
</body>
</html>