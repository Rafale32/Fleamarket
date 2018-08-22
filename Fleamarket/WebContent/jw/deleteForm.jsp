<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>탈퇴 화면</title>
<script type="text/javascript">
	//비밀번호 미입력시 경고창
	function checkValue(){
		if(!document.deleform.password.value){
			alert("비밀번호를 입력하지 않습니다.");
			return false;
		}
	}
</script>
</head>
<body>

    <br><br>
    <b><font size="6" color="gray">내 정보</font></b>
    <br><br><br>
 
    <form name="deleteform" method="post" action="/Fleamarket/memmanage/deleteAction.do" onsubmit="return checkValue()">
 
		<div> 회원탈퇴 화면입니다. 탈퇴하실 경우 탈퇴버튼을 눌러주세요 	</div> 
        
        <br><br>
        <a href="/maindetail/mainAction.do"><input type="submit" value="탈퇴" onclick="return checkValue()"></a>
        <a href="detailForm.jsp"> <input type="button" value="취소"> </a>
        
    </form>
</body>
</html>