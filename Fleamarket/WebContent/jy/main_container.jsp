<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.home-recommend-item {
	width: 1024px;
	height: 472.8px;
	padding-bottom: 30px;
}

.recommend-title {
	width: 1024px;
	height: 36px;
	padding-top: 50px;
	padding-bottom: 22px;
}

.carousel {
	width: 1024px;
	height: 364.8px;
}

.title {
	font-size: 23px;
	font-weight: bolder;
}

.item-wrapper {
	width: 244px;
	height: 360px;
	margin-right: 16px;
}
.recomend-item{
	width : 244px;
	height : 330px;
	padding-top: 30px;
}
</style>
</head>
<body>
	<div class="home">
		<div class="home-recommend-item">
			<div class="recommend-title">
				<div class="title">플리마켓 추천상품</div>
			</div>
			<div class="carousel">
				<div class="carousel-helper"></div>
				<div class="item-wrapper">
					<div class="recomend-item">
						<c:forEach var="reList" items="${bean.recommend}">
						${reList.thum_img}
						<a href="detailAction.do?itemboard_no=${reList.itemboard_no}">${reList.title}</a>
						${reList.price}
							${reList.itemboard_date}
						${reList.delivery_fee}
						<br>
						</c:forEach>
					</div>
				</div>
			</div>
			<br>
		</div>

		<div class="category-list">
			<h3>카테고리 목록</h3>
			<c:forEach var="categoryList" items="${bean.hotList}">
			${categoryList.category_title}
			<a
					href="categoryItemListAction.do?category_no=${categoryList.category_no}">전체보기</a>
			</c:forEach>
		</div>

		<div class="hot-title">
			<h3>카테고리별 인기 상품</h3>
		</div>
		<c:forEach var="list" items="${bean.hotList}">
			<a href="">${list.category_title}</a>
			<br>
			<c:forEach var="itemList" items="${list.hotList}">
			${itemList.thum_img }
			<a href="detailAction.do?itemboard_no=${itemList.itemboard_no}">${itemList.title}</a>
			</c:forEach>
			<br>
		</c:forEach>
	</div>
</body>
</html>