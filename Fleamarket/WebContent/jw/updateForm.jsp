<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>정보 수정</title>
</head>
<body>
	<h1>정보 수정</h1>
	<form action="/Fleamarket/memmanage/updateAction.do" method="post" name="frm">
	<input type="hidden" name="command" value="updateMember">
	<table>
		<tr>
			<th> 이메일  </th>
		 	<td>${bean.MemManageDTO.email }</td>
		</tr>			
		<tr>
			<th> 비밀번호</th>
			<td><input type="password" name="password"></td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td><input type="text" name="name" value= "${bean.MemManageDTO.name}"></td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td><input type="text" name="phone" value= "${bean.MemManageDTO.phone }"></td>
		</tr>
		<tr> 
			<th>주소</th>
		 	<td><input type="text" name="address" value= "${bean.MemManageDTO.address }"></td>
		</tr>
		<tr> 
			<th>상세주소</th>
		 	<td><input type="text" name="address2" value= "${bean.MemManageDTO.address2 }"></td>
		</tr> 	
	</table>
	<br>
	<input type = "submit" value = "확인" onclick="location.href='./jw/detailForm.jsp'">
	<input type="reset" value="다시 작성">
	
	</form>
</body>
</html>