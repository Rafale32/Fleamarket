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
	<c:choose>
		<c:when test="${member.nickname == null }">
			<a href="/Fleamarket/memmanage/login.do">로그인</a>
		</c:when>
		<c:when test="${member.nickname != null }">
			${member.nickname } 님 환영합니다.
			<a href="/Fleamarket/memmanage/logout.do">로그아웃</a>
		</c:when>
	</c:choose>
</body>
</html>