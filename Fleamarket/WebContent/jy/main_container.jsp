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
	<div class="recommend-title">
		<h3>플리마켓 추천상품</h3>
	</div>
	<div class="recomend-item">
		<c:forEach var="reList" items="${bean.recommend}">
			<a href="">${reList.thum_img}</a>
			<a href="">${reList.title}</a>
			<a href="">${reList.price}</a>
			<a href="">${reList.itemboard_date}</a>
			<a href="">${reList.delivery_fee}</a>
			<br>
		</c:forEach>
	</div>
	<br>

	<%-- <div class="category-list">
		<h3>카테고리 목록</h3>
		<c:forEach var="categoryList" items="${bean.categoryList}">
			<a href="">${categoryList.category_title}</a>
		</c:forEach>
	</div> --%>

	<%-- <div class="category-list">
		<h3>카테고리 목록</h3>
		<c:forEach var="list" items="${bean.categoryList}">
			<a href="">${list.category_title}</a>
			<c:forEach var="itemList" items="${bean.categoryList.hotItemList}">
				<a href="">${itemList.title}</a>
			</c:forEach>
		</c:forEach>
	</div> --%>


	<div class="hot-title">
		<h3>카테고리별 인기 상품</h3>
	</div>
	<div class="hot-item">
		<c:forEach var="hotList" items="${bean.hotItemList}" begin="0" end="2"
			step="1">
			<a href="">${hotList.category_title}</a>
		</c:forEach>
	</div>
</body>
</html>