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
	<form action="/Fleamarket/memmanage/detailAciont.do" method="post" name="frm">
	<h3>상세보기</h3>
	<table width="500" border="2" cellpadding="0.5" cellspacing="0">
		<tr> 
			<th>이메일</th>	
		 	<td>${member.email }</td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td> ${member.name}</td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td> ${member.phone }</td>
		</tr>
		<tr> 
			<th>주소</th>
		 	<td>${member.address }</td>
		</tr>
		<tr> 
			<th>상세주소</th>
		 	<td>${member.address2 }</td>
		</tr> 
	</table>
		
	<input type="button" value="뒤로" >
    <input type="button" value="회원정보 변경" onclick="updateForm.jsp" >
    <a href="/Fleamarket/memmanage/updateAction.do?email=${member.email }">회원정보 </a>
    <input type="button" value="회원탈퇴" >
    
	</form>
</body>
</html>