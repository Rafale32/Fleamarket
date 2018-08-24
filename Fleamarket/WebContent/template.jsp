<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="jquery.js"></script> -->
<link rel="stylesheet" href="/Fleamarket/css/template.css" type="text/css">

<!-- 폰트 -->

<title>Insert title here</title>
</head>
<body>

	<div id="wrap">
   <!-- 전체 레이아웃 시작 -->
	   <div id="header">
       <jsp:include page="./header.jsp"/>
     </div> <!-- header -->
     
	   <!-- container 시작 -->
	   <div id="container"> 
	   <div>
       <jsp:include page="${forward.conPath }"/> </div>
	   </div> <!-- container 끝 -->
     
    <!-- 	   푸터 -->
	   <div id="footer">
       <jsp:include page="./footer.jsp"/>
     </div> <!-- footer -->
	</div> <!-- 전체 레이아웃 끝 -->

</body>
</html>