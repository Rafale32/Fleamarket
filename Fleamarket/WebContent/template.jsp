<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script type="text/javascript" src="jquery.js"></script> -->

<script type="text/javascript">
/* 	$(function() {
		$("#header").click(function() {
			$.ajax({
				url: "board/",
				type: "post"
			});
			return false;
		});
	}); */
</script>

<title>Insert title here</title>
</head>
<body>

	<div id="wrap"> <!-- 전체 레이아웃 시작 -->
	   <div id="header"> <jsp:include page="./header.jsp"/> </div> <!-- header -->
	   <hr> <!--단락구분 -->
	   
	   <div id="container"> <!-- container 시작 -->
	      <div> 컨테이너 <jsp:include page="${forward.conPath }"/> </div>
        <div>
        </div>
	   </div> <!-- container 끝 -->
	   <hr>
	   
	   <div id="footer"> <jsp:include page="./footer.jsp"/> </div> <!-- footer -->
	</div> <!-- 전체 레이아웃 끝 -->
<a href="/Fleamarket/payment/payment.do">안심결제</a>
</body>
</html>