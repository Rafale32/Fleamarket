<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
<script type="text/javascript" src="/Fleamarket/jw/Check.js"></script>
<script type="text/javascript">

function loginCheck(){
	   if(document.frm.email.value.length == 0){
	      alert("Email을 입력하세요");
	      frm.email.focus();
	      return false;
	   }
	   if(document.frm.password.value ==""){
	      alert("패스워드를 입력하세요");
	      frm.password.focus();
	      return false;
	   }
	   return true;
	}


</script>

</head>
<body>
	<div id = login>
		<acricle class="login">
			<header>
				<h2>로그인</h2>
			</header>
		</acricle>
	<form action="/Fleamarket/memmanage/checklogin.do" method="post" name="frm">
		<table>
			<tr> 
			<td>아이디</td>
			<td><input type="email" id="#uId" name="email" value="${email }"></td>
			</tr>
			<tr>
			<td>비번 </td>
			<td><input type="password" name="password"></td>
			</tr>
			<tr>
			<td colspan="2" aling="center">
			<input type="submit" value="로그인" onclick="return loginCheck() ">
			</td>
			</tr>
		</table>
	</form>
	</div>
</body>
</html>