<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
  /* $(function() {
    $('').click(function(){
  		$.ajax({
  			url:'/Fleamarket/maindetail/favaction.do',
  			type:'post',
  			dataType:'json',
  			success:successHandler
  		});
  }) */
</script>
<style type="text/css">
.tg {
	border-collapse: collapse;
	border-spacing: 0;
}

.tg td {
	font-family: Arial, sans-serif;
	font-size: 14px;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: black;
}

.tg th {
	font-family: Arial, sans-serif;
	font-size: 14px;
	font-weight: normal;
	padding: 10px 5px;
	border-style: solid;
	border-width: 1px;
	overflow: hidden;
	word-break: normal;
	border-color: black;
}

.tg .tg-0pky {
	border-color: inherit;
	text-align: left;
	vertical-align: top
}

.tg .tg-0lax {
	text-align: left;
	vertical-align: top
}
</style>
</head>
<body>
	<div class="category">
		<h3>카테고리목록</h3>
		<c:forEach var="list" items="${bean.categoryList}">
			<a href="">${list.category_title }</a>
			<c:forEach var="subList" items="${list.subCategory}">
				<a href="">${subList.sub_title }</a>
			</c:forEach>
		</c:forEach>
	</div>
	<div class="itemDetail">
		<h3>상품정보</h3>
			<table class="tg">
				<tr>
					<th class="tg-0pky" rowspan="8"><c:forEach var="imgList"
							items="${bean.itemImgList}" begin="0" end="0" step="1" ><img alt="" src="../productimg/${imgList.thum_img}">
						</c:forEach></th>
					<th class="tg-0pky" colspan="4">${bean.itemDetail.title}</th>
				</tr>
				<tr>
					<td class="tg-0pky" colspan="4">${bean.itemDetail.price}</td>
				</tr>
				<tr>
					<td class="tg-0pky">${bean.itemDetail.fav_no}</td>
					<td class="tg-0pky">${bean.itemDetail.hits}</td>
					<td class="tg-0pky">${bean.itemDetail.itemboard_date}</td>
<!-- 					<td class="tg-0lax"></td> -->
				</tr>
				<tr>
					<td class="tg-0pky">상품상태</td>
					<td class="tg-0pky">
						<c:choose>
							<c:when test="${bean.itemDetail.item_state eq 0}">새상품</c:when>
							<c:when test="${bean.itemDetail.item_state eq 1}">중고(상)</c:when>
							<c:when test="${bean.itemDetail.item_state eq 2}">중고(중)</c:when>
							<c:when test="${bean.itemDetail.item_state eq 3}">중고(하)</c:when>
						</c:choose>
					</td>
					<td class="tg-0pky"></td>
<!-- 					<td class="tg-0lax"></td> -->
				</tr>
				<tr>
					<td class="tg-0pky">교환여부</td>
					<td class="tg-0pky">
						<c:choose>
							<c:when test="${bean.itemDetail.change_ornot eq 0}">교환불가</c:when>
							<c:when test="${bean.itemDetail.change_ornot eq 1}">교환가능</c:when>
						</c:choose>
					</td>
					<td class="tg-0pky"></td>
<!-- 					<td class="tg-0lax"></td> -->
				</tr>
				<tr>
					<td class="tg-0pky">배송비</td>
					<td class="tg-0pky">
						<c:choose>
							<c:when test="${bean.itemDetail.delivery_fee eq 0}">배송비 별도</c:when>
							<c:when test="${bean.itemDetail.delivery_fee eq 1}">무료배송</c:when>
						</c:choose>
					</td>
					<td class="tg-0pky"></td>
<!-- 					<td class="tg-0lax"></td> -->
				</tr>
				<tr>
					<td class="tg-0pky">거래지역</td>
					<td class="tg-0pky">${bean.itemDetail.local}</td>
					<td class="tg-0pky"></td>
<!-- 					<td class="tg-0lax"></td> -->
				</tr>
				<tr>
					<td class="tg-0pky" colspan="2">찜</td>
					<td class="tg-0pky" colspan="2">안심결제</td>
				</tr>
			</table>
			상품정보
			<li>${bean.itemDetail.itemboard_contents}</li> 카테고리
			<li>${bean.itemDetail.category_title}</li>
			<li>${bean.itemDetail.sub_title}</li> 상품태그
			<!-- 해시태그 목록 -->
			<c:if test="${bean.itemDetail.tagList ne null}">
				<c:forEach var="list" items="${bean.itemDetail.tagList}">
					<a href="">${list }</a>
				</c:forEach>
			</c:if>
		</ul>
	</div>
	<c:if test="${member.name ne null}">
		<a
			href="/Fleamarket/payment/payment.do?item_no=${bean.itemDetail.item_no }">안심결제</a>
	</c:if>
	<br>
	<div class="storeInfo">
		<h3>상점정보</h3>
		<a
			href="/Fleamarket/product/productlist.do?store_name=${bean.storeInfo.store_name }">${bean.storeInfo.store_name }</a>
		<h4>상점 내 다른 아이템</h4>
		<c:forEach var="itemList" items="${bean.storeInfo.itemList}">
			<a href="detailAction.do?itemboard_no=${itemList.itemboard_no}">${itemList.title}</a>
		</c:forEach>
	</div>

	<div class="itemQna">
		<h3>상품문의</h3>
		<c:if test="${member.name ne null}">
			<form action="qnaAction.do" method="post">
				<input type="hidden" name="itemboard_no"
					value="${bean.itemDetail.itemboard_no}"> <input
					type="hidden" name="email" value="${member.email}"> 내용 <br>
				<textarea rows="6" cols="70" name="contents"></textarea>
				<br> <input class="insertQnaBtn" type="submit" value="등록">
				<br>
			</form>
		</c:if>

		<c:forEach var="qnaList" items="${bean.itemQnaList}">
			<a href="">${qnaList.store_name }</a>
			<a href="">${qnaList.store_no }</a>
			<c:if test="${member.email eq qnaList.email }">
				<a
					href="deleteQnaAction.do?item_qna_no=${qnaList.item_qna_no}&itemboard_no=${bean.itemDetail.itemboard_no}">삭제하기</a>
			</c:if>
			<br>
			${qnaList.contents}<br>
		</c:forEach>
	</div>
</body>
</html>