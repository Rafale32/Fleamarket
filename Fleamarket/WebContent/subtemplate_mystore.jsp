<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<div id="pack">

		<div id="left_menu"> <!-- 왼쪽 소메뉴 -->
			<jsp:include page="./leftmenu.jsp" />
		</div>
		<hr>
		
		<div id="sub_container"> <!-- 소메뉴 눌렀을때 바뀌는 부분 -->
			<div>
				왼쪽메뉴 누르는거에 따른 컨테이너
				<jsp:include page="${forward.subConPath }" />
			</div>
		</div>
		<hr>

	</div>

</body>
</html>