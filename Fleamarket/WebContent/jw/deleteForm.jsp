<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>탈퇴 화면</title>
<script type="text/javascript">

	<% session.invalidate(); %>
	
</script>
</head>
<body>

    <br><br>
    <b><font size="6" color="gray">내 정보</font></b>
    <br><br><br>
 
    <form name="deleteform" method="post" action="/Fleamarket/memmanage/deleteAction.do">
 
		<div> 회원탈퇴 되었습니다. 그동안 이용해 주셔서 감사합니다.</div> 
        
        <br><br>
        
    </form>
    <a href="/Fleamarket/maindetail/main.do">
           <input type="button" value="메인화면"> 
        </a>
</body>
</html>