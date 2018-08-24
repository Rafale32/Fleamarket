<?xml version="1.0" encoding="UTF-8" ?>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<div>
		<spin>
		<h3>글 수정</h3>
		</spin>
		</br>
		<form action="upsuccess.do">
			<div>구 분 : <input type="text" name="category"  value="${ups.category }"></input></div>
			<div>제 목 : <input type="text" name="title" value="${ups.title }"></input></div>
			<div>내 용 : </br>
			<textarea rows="5" cols="20" name="contents">${ups.contents }</textarea></div>
			<input type="hidden" name="notice_no" value="${ups.notice_no }"/>
			<input type="hidden" name="notice_date" value="${ups.notice_date }"/>
			<input type="submit" value="수정완료"></input>
		</form>
	</div>
</body>
</html>