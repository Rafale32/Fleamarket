<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fleamarket.memManage.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보보기</title>
</head>
<body>
	<h3>상세보기</h3>
	<table width="500" border="2" cellpadding="0.5" cellspacing="0">
		<tr>
			<td>이메일 : ${member.email }</td>
			<td>이   름 : ${member.name}</td>
			<td>전화번호 : ${member.phone }</td>
			<td>주소 : ${member.address }</td>
			<td>상세주소 : ${member.address2 }</td>
		</tr>
	</table>
		
	<input type="button" value="뒤로" onclick="changeForm(-1)">
    <input type="button" value="회원정보 변경" onclick="changeForm(0)">
    <input type="button" value="회원탈퇴" onclick="changeForm(1)">

</body>
</html>