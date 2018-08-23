<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style type="text/css">
.search-box-input {
	width: 392px;
	height: 34px;
	padding-left: 14px;
	padding-right: 48px;
	border: 2px solid #3C5A91;
	display: inline;
	/* position : relative; */
}
.icon-search {
	width: 40px;
	height: 22px;
	margin-top: 4px;
	/* margin-left: 213px; */
	position: relative;
	top: 3px;
	left: -55px;
	text-align: center;
}
</style>
</head>
<body>
	<a href="http://localhost:8081/Fleamarket/maindetail/main.do">Fleamarket</a>
	<c:choose>
		<c:when test="${member.name == null }">
			<a href="/Fleamarket/memmanage/login.do">로그인</a>
			<a href="/Fleamarket/memmanage/joinform.do">회원가입</a>
		</c:when>
		<c:when test="${member.name != null }">
			${member.name } 님 환영합니다.
			<a href="/Fleamarket/memmanage/logout.do">로그아웃</a>
		</c:when>
	</c:choose>
	
	<c:if test="${member != null }">
		<a href="/Fleamarket/product/productlist.do?email=${member.email }" class="btn">My Store</a>
		<a href="/Fleamarket/memmanage/detailAction.do?email=${member.email }" class="btn">내 정보보기</a>
	</c:if>
	<br><br>
	<form action="">
	<input type="text" placeholder="상품명" class="search-box-input">
	<input type="submit" value="검색" class="icon-search">
	</form>
</body>
</html>