<%@page import="com.fleamarket.payment.model.SellProductDTO_gy"%>
<%@page import="java.util.List"%>
<%@page import="com.fleamarket.payment.model.SellProductDAO_gy"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("utf-8");
	SellProductDAO_gy dao = SellProductDAO_gy.getInstance();
	List<SellProductDTO_gy> list = dao.listBoard();
	request.setAttribute("SellModel", list);
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">

</head>
<body>


	<table id="sell_list_table">
		<c:forEach var = "p" items="${SellModel}">
		<tr>
			<td colspan="3" class="date">날자부 :${p.pay_date }</td>
		</tr>

		
			<!-- 테이블 내용-->
			<tr>
				<td>왼쪽이미지 ${p.thum_img}</td>
				
				<td>상태이미지
				<!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  -->
				 <c:choose>
						<c:when test="${p.delivery_state == 1}">
						<img alt="배송이미지" src="../img/d1.png">
						1 = 판매중인 상태
						</c:when>
						<c:when test="${p.delivery_state == 2}">
						<img alt="배송이미지" src="../img/d2.png">
						2 = 결제완료후 준비중
						</c:when>
						<c:when test="${p.delivery_state == 3}">
						<img alt="배송이미지" src="../img/d3.png">
						3 = 배송중(판매자 판매승인)
						</c:when>
						<c:when test="${p.delivery_state == 4}">
						<img alt="배송이미지" src="../img/d4.png">
						4 = 구매자 구매완료 =거래완료
						</c:when>
					<c:otherwise>
					 제대로된 상태가 아닙니다.
					</c:otherwise>

				</c:choose>

				</td>

				<td>
					<h2>제목(상품명) ${p.title}</h2>
					<h2>판매금액 ${p.price }</h2>

				</td>

				<td>
					<form action="changeDeliverySellChack_gy.jsp">
				<!-- style="display: none;"  나중에 넣어서 추가 할것-->
					<input type="text" name="purchaseNo" value="${p.item_no}" >
					<c:if test="${p.delivery_state == 2}">
					<input type="submit" id="purchaseDetermin" class="purchaseDetermin" value="판매승인버튼" >
					</c:if>
					
					<h2>리뷰확인버튼</h2>
				</form>

				</td>
			</tr>

	</c:forEach>


	</table>

</body>
</html>