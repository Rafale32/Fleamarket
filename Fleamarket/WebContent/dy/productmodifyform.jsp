<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
    <script type="text/javascript" src="/Fleamarket/dy/jquery-3.1.0.js" charset="utf-8"></script>
    <script type="text/javascript" src="/Fleamarket/dy/imgadd.js" charset="utf-8"></script>
      
    <style type="text/css">
        .imgs_wrap {
            width: 600px;
            margin-top: 50px;
        }
        .imgs_wrap img {
            max-width: 200px;
            max-height: 200px;
        }
    </style>
    
</head>

<body>
	<br>
	
		<form action="/Fleamarket/product/addproduct.do" method="post" enctype="multipart/form-data" name="multipleUpload">
		
 		   
 		       <p class="title">업로드할 이미지를 선택해 주세요</p>
 		       
 		       
		      <div id="imgfiles">
		       		<input type="file" id="inputimgs0" name="inputimgs0"/>
		       		<input type="file" id="inputimgs1" name="inputimgs1"/>
		       		<input type="file" id="inputimgs2" name="inputimgs2"/>
		       		<input type="file" id="inputimgs3" name="inputimgs3"/>
		       		<input type="file" id="inputimgs4" name="inputimgs4"/>
		       </div>
		   <div>
		       <div class="imgs_wrap">
		           
		       </div>
		   </div>
			
			<div>
				<label >카테고리:</label>
				<div>
					<select name="subname" id="subname">
						<option>-- 카테고리를 선택해주세요 --</option>
						<c:forEach var="tmp" items="${bean.cateList }">
							<c:choose>
								<c:when test="${tmp == bean.itemDTO.category_Title }">
									<option value="${tmp }" selected="selected">${tmp }</option>
								</c:when>
								<c:otherwise>
									<option value="${tmp }">${tmp }</option>
								</c:otherwise>								
							</c:choose>
						</c:forEach>
					</select>
				</div>
				<div id="cate">
					<select name="subsubname" id="subsubname">
						<c:forEach var="tmp2" items="${bean.sub_cateList }">
							<c:if test="${tmp2 == bean.itemDTO.sub_Title }">
								<option value="${tmp2 }" selected="selected">${tmp2 }</option>
							</c:if>	
							<c:if test="${tmp2 != bean.itemDTO.sub_Title }">
								<option value="${tmp2 }">${tmp2 }</option>
							</c:if>	
						</c:forEach>
					</select>
				</div>
			</div>
			<div >
				<label>거래지역:</label>

				<div>
					<input type="text" placeholder="선호 거래 지역" autocomplete="on" value="${bean.itemDTO.local }" name="local"/>

				</div>
				<div>
					<button>지역 검색</button>
				</div>
			</div>
			<div>
				<label>상태:</label>

				<div >
					<select name="item_state">
						<c:choose>
							<c:when test="${bean.itemDTO.item_State == 0 }">
								<option selected="selected">새상품</option>
								<option >상</option>
								<option >중</option>
								<option >하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 1 }">
								<option >새상품</option>
								<option selected="selected">상</option>
								<option >중</option>
								<option >하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 2 }">
								<option >새상품</option>
								<option >상</option>
								<option selected="selected">중</option>
								<option >하</option>
							</c:when>
							<c:when test="${bean.itemDTO.item_State == 3 }">
								<option >새상품</option>
								<option >상</option>
								<option >중</option>
								<option selected="selected">하</option>
							</c:when>
						</c:choose>
					</select>
				</div>
			</div>
			<div>
				<label >제목(상품명):</label>

				<div>
					<input type="text" class="form-control" id="input_name" placeholder="제목 (최대 100자)" autocomplete="on" 
					name="title" value="${bean.itemDTO.itemboard_Contents }"/>
				</div>
			</div>
			<div>
				<label>가격:</label>

				<div >
					<input type="number" placeholder="10000 (가격은 숫자로 만 입력)" value="${bean.itemDTO.price }"  name="price">

					<div>
						<label> 
							<c:if test="${bean.itemDTO.delivery_Fee == 1 }">
								<input type="checkbox" name="delivery_fee" checked="checked">
							</c:if>
							<c:if test="${bean.itemDTO.delivery_Fee == 0 }">
								<input type="checkbox" name="delivery_fee">
							</c:if>
						택배비포함 </label>
					</div>
					<div >
						<label> 
							<c:if test="${bean.itemDTO.change_Ornot == 1 }">
								<input id="input_exchg" type="checkbox" name="change_ornot" checked="checked"> 
							</c:if>
							<c:if test="${bean.itemDTO.change_Ornot == 0 }">
								<input id="input_exchg" type="checkbox" name="change_ornot"> 
							</c:if>
						교환가능</label> 
					</div>
				</div>
			</div>
			<div>
				<label>상품 설명:</label>

				<div>
					<textarea class="form-control" rows="30" cols="100"
						placeholder="상품설명은 2000자까지 가능합니다." name="itemboard_contents">
						${bean.itemDTO.itemboard_Contents }</textarea>
				</div>
			</div>
			<div>
				<label>연관태그:</label>
				
				<div>
					<input type="text" placeholder="선택 사항 (예: 아이폰, 케이스)" value="${bean.itemDTO.tag }" width="140px" name="tag"/>
				</div>
			</div>
				<label>수량:</label>
				<input type="number" placeholder="1" value="${bean.itemDTO.amount }" name="amount"/>
				
				<br>
				<input type="submit" value="등록">
		</form>

</body>
</html>