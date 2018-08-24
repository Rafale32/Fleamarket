<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원가입 화면</title>

	<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
	<script>
    function Postcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullAddr = ''; // 최종 주소 변수
                var extraAddr = ''; // 조합형 주소 변수

                // 사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    fullAddr = data.roadAddress;

                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    fullAddr = data.jibunAddress;
                }

                // 사용자가 선택한 주소가 도로명 타입일때 조합한다.
                if(data.userSelectedType === 'R'){
                    //법정동명이 있을 경우 추가한다.
                    if(data.bname !== ''){
                        extraAddr += data.bname;
                    }
                    // 건물명이 있을 경우 추가한다.
                    if(data.buildingName !== ''){
                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                    }
                    // 조합형주소의 유무에 따라 양쪽에 괄호를 추가하여 최종 주소를 만든다.
                    fullAddr += (extraAddr !== '' ? ' ('+ extraAddr +')' : '');
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('address').value = fullAddr;

                // 커서를 상세주소 필드로 이동한다.
                document.getElementById('address2').focus();
            }
        }).open();
    }
</script>

<script type="text/javascript" src="/Fleamarket/jw/Check.js"></script>
<script type="text/javascript">

</script>


</head>
<body>

	<!-- div 왼쪽, 오른쪽 바깥여백을 auto로 주면 중앙정렬된다.  -->
	<div id="warp_jw">
		<br><br>
		<b><font size="6"color="gray">회원가입</font></b>
		<br><br><br>
		
	<!-- 입력한 값을 전송하기 위해 form 태그를 사용  -->
	<!-- 값 전송은 post방식, 전송할 페이지는 login페이지 -->
	
	<form action="/Fleamarket/memmanage/joinAction.do" method="post" name="frm" >
	
	EMAIL : <input type="email" id="email" name="email">
			<input type="button" value="중복 확인">
			<input type="hidden" name="emailDuplication">
			<br><br>
	비밀번호 : <input type="password" id="pass1" name="password" onkeyup="passwordCheckFunction();">
	<br><br>
	비밀번호 확인 : <input type="password" id="pass2" name="password2" onkeyup="passwordCheckFunction();">
	<h5 style="color: red;"  id="passwordCheckMessage"></h5>

  	<br> 
	이름 : <input type="text" name="name"/><br><br>
	전화번호 : <input type="text" name="phone"/><br><br>
	
	<input type="button" onclick="Postcode()" value="주소 찾기"><br>
	<input type="text" id="address" name="address" placeholder="주소">
	<input type="text" id="address2" name="address2" placeholder="상세주소">
	<br><br>
	
	<input type="submit" value="회원가입">
	<input type="reset" value="다시입력">
	<a href="/Fleamarket/maindetail/main.do"><input type="button" value="메인"></a>
	
	</form>
	
	

	
	</div>

</body>
</html>