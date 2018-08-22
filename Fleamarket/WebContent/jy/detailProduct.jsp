<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
			<li>${bean.itemDetail.tag}</li>
		</ul>
	</div>
	<br>
	<div class="storeInfo">
		<h3>상점정보</h3>
		<a href="">${bean.storeInfo.store_name }</a>
		<h4>상점 내 다른 아이템</h4>
		<c:forEach var="itemList" items="${bean.storeInfo.itemList}">
			<a href="">${itemList.thum_img }</a>
		</c:forEach>
	</div>
</body>
</html>