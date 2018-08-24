<%@page import="com.fleamarket.memManage.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    
    MemberService service = MemberService.getInstance();
    int re = service.joinBoardService(request);
    
    System.out.print(re);
    
    if(re == 1){
    	response.sendRedirect("joinForm.jsp");
    	
    	System.out.print("asdfasdfasdf");
    }
    
    %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	 회원가입이 완료되었습니다.
</body>
</html>