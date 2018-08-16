<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	프러덕트 리스트
	<table border="1">
		<tr> <td>a</td> <td>b</td> <td>c</td> </tr>
		<c:forEach items="${bean.itemList }" var="tmp">
			<tr> <td>${tmp.title }</td> <td>${tmp.hits }</td> <td>${tmp.itemboard_Contents }</td></tr>
		</c:forEach>
	</table>
	
</body>
</html>