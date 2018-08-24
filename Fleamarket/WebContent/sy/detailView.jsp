<?xml version="1.0" encoding="UTF-8" ?>

<%@ page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %> 
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

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
		
		<div>
			<h5>내용 확인</h5>
			
		</div>
		<form action="update.do">
		<div>번 호 : <input type="hidden" name="node_no" value="${sede.notice_no }">${sede.notice_no }</input></div>
		<div>구 분 : <input type="hidden" name="catede" value="${sede.category }">${sede.category }</input></div>
		<div>제 목 : <input type="hidden" name="tide" value="${sede.title }">${sede.title }</input></div>
		<div>생성일 : <input type="hidden" name="dade" value="${sede.notice_date }">${sede.notice_date }</input></div>
		<div>내 용 : <input type="hidden" name="code" value="${sede.contents }">${sede.contents }</input></div>
		<input type="submit" value="글 수정"/>
		</form>
		<button id="declick" onclick="">글 삭제</button>
		
	</div>
</body>
</html>