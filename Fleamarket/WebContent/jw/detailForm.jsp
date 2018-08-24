<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.fleamarket.memManage.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 정보보기</title>
<script type="text/javascript">
	
function deleteCheck(e){
	if (confirm("삭제 하시겠습니까?")) {
		var url = "/Fleamarket/memmanage/deleteAction.do?email="+email;
		location.href = url;
		return true;
	} else {
		alert("삭제 취소 되었습니다.");	
		return false;
	}
}

</script>
</head>
<body>
	<form action="/Fleamarket/memmanage/detailAciont.do" method="post" name="frm" >
	<h3>상세보기</h3>
	<table width="500" border="2" cellpadding="0.5" cellspacing="0">
		<tr> 
			<th>이메일</th>	
		 	<td>${bean.memManageDTO.email }</td>
		</tr>
		<tr>
			<th> 이   름</th> 
		 	<td> ${bean.memManageDTO.name}</td>
		</tr>
		<tr> 
			<th>전화번호</th>
			<td> ${bean.memManageDTO.phone }</td>
		</tr>
		<tr> 
			<th>주소</th>
		 	<td>${bean.memManageDTO.address }</td>
		</tr>
		<tr> 
			<th>상세주소</th>
		 	<td>${bean.memManageDTO.address2 }</td>
		</tr> 
	</table>
	
	
	<a href="/Fleamarket/maindetail/main.do"><input type="button" value="메인" ></a>
 	<a href="/Fleamarket/memmanage/updateFormAction.do?email=${bean.memManageDTO.email }"> 
<!-- 	<a href="./updateForm.jsp"> -->
	<input type="button" value="회원정보수정 "></a>
	<a href="/Fleamarket/memmanage/deleteAction.do?email=${bean.memManageDTO.email }" onclick="return deleteCheck();">
	<input type="button" value="회원탈퇴"> </a>

	</form> 
	

	
</body>
</html>