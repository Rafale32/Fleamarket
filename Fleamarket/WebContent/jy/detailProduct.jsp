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
			<li>${itemDetail.title}</li>
			<li>${itemDetail.title}</li>
			<li>${itemDetail.title}</li>
		</ul>
	</div>
</body>
</html>