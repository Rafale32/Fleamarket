<%@page import="com.fleamarket.memManage.model.MemManageDAO"%>
<%@page import="com.fleamarket.memManage.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head><title>ID 중복확인</title>
<script type="text/javascript">
<!--
  function setid()
    {		
    	opener.document.userinput.id.value="${id}";
		self.close();
	}
		//-->	
		
</script>
</head>
<body>
<c:if test="${check == 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td height="39" >이미 사용중인 아이디입니다.</td>
  </tr>
</table>
<form name="checkForm" method="post" action="emailCheckAction.do">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr>
    <td align="center"> 
       다른 아이디를 선택하세요.<p>
       <input type="text" size="10" maxlength="12" name="id"> 
       <input type="submit" value="ID중복확인">
    </td>
  </tr>
</table>
</form>
</c:if>
<c:if test="${check != 1}">
<table width="270" border="0" cellspacing="0" cellpadding="5">
  <tr> 
    <td align="center"> 
      <p>사용하실 수 있는 EMAIL입니다. </p>
      <input type="button" value="닫기" onclick="setid()">
    </td>
  </tr>
</table>
</c:if>
</body>
</html>
