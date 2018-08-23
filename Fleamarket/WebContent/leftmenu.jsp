<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
	#lemenu{
		
	}
</style>
<title>Insert title here</title>
</head>
<body>
	<div id="lemenu">
		<c:choose>
			<c:when test="${param.store_name != null}">
				<a href="/Fleamarket/product/productlist.do?store_name=${bean.itemDTO.store_name }">상품</a>
				<a href="#">상점후기</a>
			</c:when>
			<c:when test="${param.email != '' }"> 
				<a href="/Fleamarket/product/productlist.do?email=${member.email }">내 상품</a>
				<a href="/Fleamarket/product/addproductform.do">물품등록</a>
				<a href="#">찜</a><!-- 내가 찜한 상품들 일종의 장바구니 -->
				<a href="#">상점후기</a>
				<a href="">구매내역</a>
				<a href="#">판매내역</a>
				<a href="#">정산</a>
			</c:when>
		</c:choose>
	</div>
</body>
</html>