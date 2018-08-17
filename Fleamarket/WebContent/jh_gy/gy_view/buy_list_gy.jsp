<%@page import="com.fleamarket.payment.model.PuerchaseDTO_gy"%>

<%@page import="java.util.List"%>
<%@page import="com.fleamarket.payment.model.PuerchaseDAO_gy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<% 
request.setCharacterEncoding("utf-8");
PuerchaseDAO_gy dao = PuerchaseDAO_gy.getInstance();
List<PuerchaseDTO_gy> list = dao.listBoard();
request.setAttribute("purchaseModel", list);
%>



<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">

</head>
<body>


	<table id="sell_list_table">
		<c:forEach var = "p" items="${purchaseModel}">
		<tr>
			<td colspan="3" class="date">날자부 :${p.pay_date }</td>
		</tr>

		
			<!-- 테이블 내용-->
			<tr>
				<td>왼쪽이미지 ${p.thum_img}</td>

				<td>
					<h2>제목(상품명) ${p.title}</h2>
					<h2>구매상점 ${p.store_name }</h2>

				</td>

				<td>
					<h2>판매확정버튼</h2>

					<h2>리뷰확인버튼</h2>

				</td>
			</tr>

	</c:forEach>


	</table>

</body>
</html>