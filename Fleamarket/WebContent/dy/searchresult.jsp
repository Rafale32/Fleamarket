<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<script type="text/javascript" src="/Fleamarket/dy/jquery-3.1.0.js" charset="utf-8"></script>
<script type="text/javascript">
$(function() {
	var searchSubj = '';
	var cnt = 0;
	
	//파라미터값에 있는 걸 잘라서 값으로 반환 해주는 함수 $.urlParam('searchSubj') 원하는 파람 쓰면 그 파람의 값넘어옴
	$.urlParam = function(name){
	    var results = new RegExp('[\?&]' + name + '=([^&#]*)').exec(window.location.href);
	    if (results==null){
	       return null;
	    }
	    else{
	       return results[1] || 0;
	    }
	}
	
	
 	$(window).bind('scroll', function() {
	    if($(window).scrollTop() >= $('.posts').offset().top + $('.posts').outerHeight() - window.innerHeight) {
	        searchSubj = $.urlParam('searchSubj');
	        
	        
 	        $.ajax({
				url: "/Fleamarket/product/searchall.do?searchSubj="+searchSubj+"&aja=yes",
				type: "post",
				dataType: "json",
				success: function(data){
					var cnt = 1;
					$.each(data,function(key,value) {
						
					//	$("#subsubname").empty();
					//	alert('key:'+key+', name:'+value.cate);
					//$("#subsubname").append( "<option value='"+ value.cate +"'>"+ value.cate +"</option>" );
						$.each(value, function(i, value2) {
							if(cnt == 1 || cnt%5==1){
								$(".itemtab").append("<tr>");
							}
							
							//alert(value2.thum_img);
							//"itemboard_No":16,"thum_img":"88441820_2_1534756574_w4341_small.jpg","price":2040,"title":"aaa","local":"신촌"
							var all = "<td>"+ "<a href=/Fleamarket/maindetail/detailAction.do?itemboard_no="+ value2.itemboard_No +">"+
									+ "<img src=/Fleamarket/productimg/"+value2.thum_img+"><br>" +
									+ value2.title + "<br>" + 
									+ value2.price + "<br>" +
									+ value2.local + "<br>" +
									+"</td>";
							
							
							$(".itemtab").append(all);
							
							if(cnt%5 == 0){
								$(".itemtab").append("</tr>");
							}
						});
						
					});
					
					
				}
			});
	        
	    }
	});
});

</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="posts" id="flux" style="text-align: center; vertical-align: middle;">
		<table style="undefined;table-layout: fixed; width: 1020px" class="itemtab">
			<colgroup>
				<col style="width: 61.005682px">
				<col style="width: 61.005682px">
				<col style="width: 61.005682px">
				<col style="width: 65.005682px">
				<col style="width: 66.005682px">
			</colgroup>
		  <tr>
		    <th colspan="5">검색된 상품<br><br><br><br><br></th>
		  </tr>
		  
		  <c:forEach items="${bean.itemList }" var="tmp" varStatus="sta">
		  		<c:if test="${sta.count == 1 || sta.count%5 == 1  }"><tr></c:if>
			  	<td>
			  		<a href="/Fleamarket/maindetail/detailAction.do?itemboard_no=${tmp.itemboard_No }">
			  			<img src="/Fleamarket/productimg/${tmp.itemboard_Contents }"> <br>
			  			${tmp.title } <br>
			  			${tmp.price }원<br>
			  			거래지역:${tmp.local }
			  		</a>
			  	</td>
			  <!--   <td>이미지1</td>
			    <td>이미지2</td>
			    <td>이미지3</td>
			    <td>이미지4</td>
			    <td>이미지5</td> -->
			    
			 	<c:if test="${sta.count%5 == 0  }"><tr><br></c:if>
		  </c:forEach>
		</table>
	
	</div>
</body>
</html>