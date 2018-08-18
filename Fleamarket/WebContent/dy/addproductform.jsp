<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset="UTF-8">
    <script type="text/javascript" src="jquery-3.1.0.js" charset="utf-8"></script>
    <script type="text/javascript" src="imgadd.js" charset="utf-8"></script>

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
    
    <script type="text/javascript">
    	$("#subcate").on("change", function () {
			alert("asdf");
		});
    </script>
    
</head>

<body>
	<br>

		<form action="">
		
		   <div>
		       <p class="title">업로드할 이미지를 선택해 주세요</p>
		       <div id="imgfiles">
		       	<input type="file" id="input_imgs0" multiple/>
		       </div>
		   </div>
		   <div>
		       <div class="imgs_wrap">
		           
		       </div>
		   </div>
		
			<div>
				<label >카테고리:</label>
				<div>
					<select name="sub_cate" id="subcate">
						<option>-- 카테고리를 선택해주세요 --</option>
						<option value="310">여성의류</option>
						<option value="320">남성의류</option>
						<option value="400">패션잡화</option>
						<option value="410">뷰티/미용</option>
						<option value="500">유아동/출산</option>
						<option value="700">스포츠/레저</option>
						<option value="600">디지털/가전</option>
						<option value="900">도서/티켓/취미/애완</option>
						<option value="800">생활/문구/가구/식품</option>
						<option value="750">차량/오토바이</option>
						<option value="999">기타</option>
						<option value="910">스타굿즈</option>
						<option value="220">지역 서비스</option>
						<option value="230">원룸/함께살아요</option>
						<option value="240">구인구직</option>
						<option value="210">재능</option>
						<option value="100">커뮤니티</option>
						<option value="200">번개나눔</option>
					</select>
				</div>
			</div>
			<div >
				<label>거래지역:</label>

				<div>
					<input type="text" placeholder="선호 거래 지역" autocomplete="on" value="" disabled="">

				</div>
				<div >
					<button>최근 지역</button>
				</div>
				<div >
					<button>지하철 검색</button>
				</div>
				<div>
					<button>지역 검색</button>
				</div>
			</div>
			<div >
				<label>상태:</label>

				<div >
					<select name="pro_state">
						<option >새상품</option>
						<option >상</option>
						<option >중</option>
						<option >하</option>
					</select>
				</div>
			</div>
			<div>
				<label >제목:</label>

				<div>
					<input type="text" class="form-control" id="input_name" placeholder="제목 (최대 40자)" autocomplete="on" />
				</div>
			</div>
			<div>
				<label>가격:</label>

				<div >
					<input placeholder="10000 (가격은 숫자로 만 입력)" >

					<div>
						<label> <input type="checkbox">택배비포함
						</label>
					</div>
					<div >
						<label> <input id="input_exchg" type="checkbox" ><i></i>교환가능</label> 
					</div>
				</div>
			</div>
			<div>
				<label>상품 설명:</label>

				<div>
					<textarea class="form-control" rows="30" cols="100"
						placeholder="상품설명은 2000자까지 가능합니다."></textarea>
				</div>
			</div>
			<div>
				<label>연관태그:</label>
				
				<div>
					<input type="text" placeholder="선택 사항 (예: 아이폰, 케이스)" width="140px"/>
				</div>
			</div>
			
				<label>수량:</label>
				<input type="text" placeholder="1" value="1" name=""/>
				
				<input type="submit" value="등록">
		</form>

</body>
</html>