<%@page import="com.fleamarket.payment.model.PaymentPagingDTO_gy"%>
<%@page import="com.fleamarket.payment.service.PaymentPagingService_gy"%>
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
	
 	/* PaymentPagingService_gy daoservice = PaymentPagingService_gy.getInstance();
	PaymentPagingDTO_gy dao2 = new PaymentPagingDTO_gy();
	dao2 = daoservice.listBoardService2(2, request); 
	request.setAttribute("SellModel2", dao2);   */
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="../gy_css/buySellTable.css" type="text/css">

<script type="text/javascript" src="/Fleamarket/jh_gy/gy_view/check.js">


</script>

</head>
<body>


	<table id="sell_list_table">
		<c:forEach var = "p" items="${SellModel2.list}">
		<tr>
			<td colspan="4" class="date">날자부 :${p.pay_date }</td>
		</tr>

		
			<!-- 테이블 내용-->
			<tr>
			<!-- 추후 이미지 경로 src 만 수정 하면 됨 -->
				<td> <%-- ${p.thum_img} --%> <img alt="물품임시이미지" src="../img/${p.thum_img}.jpg" width="200px" height="150px"></td>
				
				<td>
				<!-- 거래 상태를 볼수 있는 코드 1~4까지 있고 설명을 적어 놓았고 나중에 이미지 파일로 변경하면 됨  -->
				 <c:choose>
						<c:when test="${p.delivery_state == 1}">
						<img alt="배송이미지" src="../img/d1.png">
						
						</c:when>
						<c:when test="${p.delivery_state == 2}">
						<img alt="배송이미지" src="../img/d2.png">
					
						</c:when>
						<c:when test="${p.delivery_state == 3}">
						<img alt="배송이미지" src="../img/d3.png">
				
						</c:when>
						<c:when test="${p.delivery_state == 4}">
						<img alt="배송이미지" src="../img/d4.png">
					
						</c:when>
					<c:otherwise>
					 제대로된 상태가 아닙니다.
					</c:otherwise>

				</c:choose>

				</td>

				<td>

				  <a href="/Fleamarket/payment/detailpayment.do?item_no=${p.item_no }"> 
					<h2>제목(상품명) ${p.title}</h2>
					<h2>판매금액 ${p.price }</h2>

				</td>

				<td>
					<form action="changeDeliverySellChack_gy.gg" onsubmit="return deleteCheck2()">
				<!-- style="display: none;"  나중에 넣어서 추가 할것-->
					<c:if test="${p.delivery_state == 2}">
					<input type="text" id="pageNo" name="pageNo" value=${SellModel2.requestPage } style="display: none;">
					<input type="text" id="item_no" name="item_no" value=${p.item_no } style="display: none;" >
					<input type="submit" id="purchaseDetermin" class="purchaseDetermin" value="판매승인버튼" >
					</c:if>
					
					<h2>리뷰확인버튼</h2>
				</form>

				</td>
			</tr>

	</c:forEach>


	</table>
	
	<!-- 5페이지 이동 바꿀수 있음 전체 페이지가 나오기위해 5보다 크면되잖아? 스타트 페이지가-->
	<c:if test="${SellModel2.startPage > 5 }">
	<a href="PaymentPagingSellController_gy.gg?pageNum=${SellModel2.requestPage-5}"> [ 이 전 페이지로...]</a>
	</c:if>
	<!-- 한페이지씩 이동 2페이지 부터 나오게 만듬 -->
		<c:if test="${SellModel2.requestPage >= 2 }">
		<a href="PaymentPagingSellController_gy.gg?pageNum=${SellModel2.requestPage-1}"> [ 이 전 ]</a>
		</c:if>
	<!-- 숫사 부분 -->
	<c:forEach var="pageNo" begin="${SellModel2.startPage }" end="${SellModel2.endPage }">
		<!-- 현제 페이지가 2 이상일때 이전이라는 글 나오게 하기-->
		<c:if test="${pageNo == SellModel2.requestPage}" > <b></c:if>
		<a href="PaymentPagingSellController_gy.gg?pageNum=${pageNo}"> ${pageNo}</a>
		<c:if test="${pageNo == SellModel2.requestPage}" > </b></c:if>
		<!-- 다음키 -->
		</c:forEach>
		<c:if test="${SellModel2.requestPage < SellModel2.endPage}">
		<a href="PaymentPagingSellController_gy.gg?pageNum=${SellModel2.requestPage+1}" > [ 다음 ]</a>
		</c:if>
		
		<!-- 엔드페이지 수가 적을때 나올수 있게끔 -->
		<c:if test="${SellModel2.totalPageCount > SellModel2.endPage }">
		<a href="PaymentPagingSellController_gy.gg?pageNum=${SellModel2.requestPage+5}"> [ 다 음 페이지로...]</a>
		</c:if>

</body>
</html>