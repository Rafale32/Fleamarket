<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
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
	<a href="" class="btn">판매하기</a>
	<a href="/Fleamarket/product/productlist.do" class="btn">내 상점</a>
	<a href="" class="btn">내 정보보기</a>
	<c:if test="${member != null }">
		<a href="/Fleamarket/product/productlist.do?email=${member.email }" class="btn">My Store</a>
		<a href="" class="btn">내 정보보기</a>
	</c:if>

</body>
</html>