<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/Fleamarket/jy/detail.css" type="text/css">
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
</style>
</head>
<body>
	<div class="main">
		<div class="category">
			<h3>카테고리목록</h3>
			<div role="menu" class="category-menu"></div>
			<c:forEach var="list" items="${bean.categoryList}">
				<div class="cate">
					<a class="cate-btn" href="">${list.category_title }</a>
				</div>
				<%-- <c:forEach var="subList" items="${list.subCategory}">
				<a href="">${subList.sub_title }</a>
			</c:forEach>  --%>
			</c:forEach>
		</div>
		<div class="itemDetail">
			<div class="item-detail-wrapper">
				<div class="product-summary-wrapper">
					<div class="product-image-slide">
						<c:forEach var="imgList" items="${bean.itemImgList}" begin="0"
							end="0" step="1">
							<img class="image" alt="" src="../productimg/${imgList.thum_img}">
						</c:forEach>
					</div>
					<div class="product-summary">
						<div class="product-summary">
							<div class="product-summary__title">
								<h2>${bean.itemDetail.title }</h2>
								<h3>
									<fmt:formatNumber value="${bean.itemDetail.price}" />
									<small>원</small>
								</h3>
							</div>
							<div class="product-summary__assistant">
								<span class="text-pick"><div class="icon icon pick"></div>
									찜 ${bean.itemDetail.fav_no} </span> <span class="split"></span> <span
									class="text-eye"><div class="icon icon eye"></div> 조회수
									${bean.itemDetail.hits } </span> <span class="split"></span> <span
									class="text-time"><div class="icon icon time"></div>
									${bean.itemDetail.itemboard_date } </span>
							</div>
							<ul class="product-summary__assistant-2nd">
								<li class="status"><strong>상품상태</strong> <span
									class="value"> <c:choose>
											<c:when test="${bean.itemDetail.item_state eq 0}">새상품</c:when>
											<c:when test="${bean.itemDetail.item_state eq 1}">중고(상)</c:when>
											<c:when test="${bean.itemDetail.item_state eq 2}">중고(중)</c:when>
											<c:when test="${bean.itemDetail.item_state eq 3}">중고(하)</c:when>
										</c:choose>
								</span></li>
								<li class="exchange"><strong>교환여부</strong> <span
									class="value"> <c:choose>
											<c:when test="${bean.itemDetail.change_ornot eq 0}">교환불가</c:when>
											<c:when test="${bean.itemDetail.change_ornot eq 1}">교환가능</c:when>
										</c:choose>
								</span></li>
								<li class="shipping"><strong>배송비</strong> <span
									class="value"> <c:choose>
											<c:when test="${bean.itemDetail.delivery_fee eq 0}">배송비 별도</c:when>
											<c:when test="${bean.itemDetail.delivery_fee eq 1}">무료배송</c:when>
										</c:choose>
								</span></li>
								<li class="location"><strong>거래지역</strong> <span
									class="value"><div class="icon location-sm"></div>
										${bean.itemDetail.local}</span></li>
							</ul>
							<div class="button-container">
								<button class="btn-faved">
									<div class="icon icon-faved pick-white"></div>
									찜 <span class="faved-cnt">23</span>
									<!---->
								</button>

								<c:choose>
									<c:when test="${bean.itemDetail.delivery_state eq 1 }">
										<c:choose>
											<c:when test="${member.name ne null}">
												<button
													onclick="location.href = '/Fleamarket/payment/payment.do?item_no=${bean.itemDetail.item_no }'"
													class="btn-call">안심결제</button>
											</c:when>
											<c:otherwise>
												<button
													onclick="location.href = '/Fleamarket/memmanage/login.do'"
													class="btn-call">안심결제</button>
											</c:otherwise>
										</c:choose>
									</c:when>
									<c:otherwise>
										<button class="btn-call">판매완료</button>
									</c:otherwise>
								</c:choose>

								<!---->
							</div>
							<!---->
						</div>
					</div>
					<!-- 				</div> -->
				</div>

				<br> <br>
				<div class="itemDetail2">
					<div class="detail-tab-content-wrapper">
						<div class="product-content">
							<div class="product-info-wrapper">
								<div class="product-info">
									<div class="title">상품정보</div>
									<div class="description">${bean.itemDetail.itemboard_contents}</div>
									<ul class="assistant-list">
										<li class="assistant"><strong>거래지역</strong><br> <span
											class="value">${bean.itemDetail.local}</span></li>
										<li class="assistant"><strong>카테고리</strong>
											<div>${bean.itemDetail.category_title}</div></li>
										<li class="assistant"><strong>상품태그</strong>
											<div>
												<c:if test="${bean.itemDetail.tagList ne null}">
													<c:forEach var="list" items="${bean.itemDetail.tagList}">
														<a href="">${list }</a>
													</c:forEach>
												</c:if>
											</div></li>
									</ul>
								</div>
							</div>
							<div class="product-comments-wrapper">
								<div class="product-comments">
									<div class="title">
										상품문의 <span class="comments-count"></span>
									</div>
									<div class="comments-input-wrapper">
										<div class="comment-input">
											<div class="input-wrapper">
												<c:if test="${member.name ne null}">
													<form action="qnaAction.do" method="post">
														<input type="hidden" name="itemboard_no"
															value="${bean.itemDetail.itemboard_no}"> <input
															type="hidden" name="email" value="${member.email}">
														<textarea name="contents" placeholder="문의 내용을 입력해주세요"
															rows="2"></textarea>
														<input class="write-btn" type="submit" value="등록">
													</form>
												</c:if>
											</div>
										</div>
									</div>
									<div class="comments-wrapper">
										<div class="comment-item">
											<c:forEach var="qnaList" items="${bean.itemQnaList}">
												<div class="comment-item-wrapper">
													<div class="comment-info-wrapper">
														<div class="comment-info-header">
															<div class="comment-writer-name">
																<a href="">${qnaList.store_name }</a>
															</div>
														</div>
														<div class="comment-content">${qnaList.contents}</div>
														<c:if test="${member.email eq qnaList.email }">
															<a
																href="deleteQnaAction.do?item_qna_no=${qnaList.item_qna_no}&itemboard_no=${bean.itemDetail.itemboard_no}">
																<div class="delete-qna">삭제하기</div>
															</a>
														</c:if>
														<div class="split"></div>
													</div>
												</div>
											</c:forEach>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="seller-content">
							<div class="product-seller-wrapper">
								<div class="product-seller">
									<div class="title">상점정보</div>
									<div class="product-seller-wrapper">
										<div class="seller-info">
											<div class="seller-profile">
												<div class="seller-basic-info">
													<a class="seller-name"
														href="/Fleamarket/product/productlist.do?store_name=${bean.storeInfo.store_name }">${bean.storeInfo.store_name }</a>
													<div class="seller-count">
														<a class="seller-product-count">${bean.storeInfo.itemCount }
															개 판매중</a>
													</div>
												</div>
											</div>
											<!-- 판매상품 미니 이미지 반복 -->
											<div class="seller-products">
												<div class="seller-popular-product">
													<a> <c:forEach var="itemList"
															items="${bean.storeInfo.itemList}" begin="0" end="1"
															step="1">
															<a
																href="detailAction.do?itemboard_no=${itemList.itemboard_no}">
																<div class="small-product">
																<c:forEach var="img" items="${itemList.imgList }" begin="0" end="0">
																	<img alt="" src="../productimg/${img.thum_img}">
																</c:forEach>
																	<div class="product-price">
																		<div class="seller-popular-product">
																			<span class="bold">
																				<fmt:formatNumber value="${itemList.price}" />
																				<small>원</small>
																			</span>
																		</div>
																	</div>
																</div>
															</a>
														</c:forEach>
													</a>
												</div>
												<a class="seller-name"
													href="/Fleamarket/product/productlist.do?store_name=${bean.storeInfo.store_name }">
													<div class="seller-product-more">
														<span class="product-count">${bean.storeInfo.itemCount-2}</span>개
														상품 더보기
													</div>
												</a>
											</div>
										</div>
										<div class="product-detail-btns">
											<c:choose>
												<c:when test="${bean.itemDetail.delivery_state eq 1 }">
													<c:choose>
														<c:when test="${member.name ne null}">
															<button
																onclick="location.href = '/Fleamarket/payment/payment.do?item_no=${bean.itemDetail.item_no }'"
																class="btn-call">안심결제</button>
														</c:when>
														<c:otherwise>
															<button
																onclick="location.href = '/Fleamarket/memmanage/login.do'"
																class="btn-call">안심결제</button>
														</c:otherwise>
													</c:choose>
												</c:when>
												<c:otherwise>
													<button class="btn-call">판매완료</button>
												</c:otherwise>
											</c:choose>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>