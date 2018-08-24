<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="com.fleamarket.board.model.MyBoard"%>
<%@page import="com.fleamarket.board.model.TestBoardDao"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	TestBoardDao DaoList = TestBoardDao.getInstance();
	List<MyBoard> list = DaoList.testlistBoard();
	//2 setattribute
	request.setAttribute("Listview", list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div>
		<h3>고객센터</h3>
		<div>
			<a href="">공지사항</a>
		</div>
		<div>
			<a href="">판매관련</a>
		</div>
		<div>
			<a href="">구매관련</a>
		</div>
		<div>
			<a href="">이벤트</a>
		</div>
		<div>
			<a href="">1:1문의</a>
		</div>
	</div>

	<div class="noticelist">

		<h3><a href="go_notice">공지사항</a></h3>
		<a href="TestWriteViewAction.do">공지 작성</a>
		<table width="500" border="1" cellpadding="0" cellspacing="0">
			<thead>
				<tr>
					<td>순서</td>
					<td>작성일</td>
					<td>제목</td>
				</tr>
			</thead>
			<c:forEach var="p" items="${Listview }">
				<tr>
					<td><input type="hidden" name="notice_no" value="${p.notice_no }" /> ${p.notice_no }</td>
					<td><input type="hidden" name="date" value="${p.notice_date }" />${p.notice_date }</td>
					<strong>
					<td><a href="detail.do?notice_no=${p.notice_no } "> ${p.title}</a></td>
					</strong>
				</tr>
			</c:forEach>
		</table>
</body>
</html>