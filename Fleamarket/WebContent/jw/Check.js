
function passwordCheckFunction(){
	var pass1 = $('#pass1').val();
	var pass2 = $('#pass2').val();
	if(pass1 != pass2){
		$('#passwordCheckMessage').html('비밀번호가 일치하지 않습니다.');
	}else{
		$('#passwordCheckMessage').html('');		
	}	
}

//function checkValue()
//{
//	var form = document.frm;
//
//	if(!form.id.value){
//		alert("아이디를 입력하세요.");
//		return false;
//	}
//	
//	if(form.idDuplication.value != "idCheck"){
//		alert("아이디 중복체크를 해주세요.");
//		return false;
//	}
//	
//	if(!form.password.value){
//		alert("비밀번호를 입력하세요.");
//		return false;
//	}
//	
//	if(!form.name.value){
//		alert("이름을 입력하세요.");
//		return false;
//	}
//	
//	if(!form.birthyy.value){
//		alert("년도를 입력하세요.");
//		return false;
//	}
//	
//	if(!form.phone.value){
//		alert("전화번호를 입력하세요.");
//		return false;
//	}
//	
//	if(isNaN(form.phone.value)){
//		alert("전화번호는 - 제외한 숫자만 입력해주세요.");
//		return false;
//	}
//	
//	if(!form.address.value){
//		alert("주소를 입력하세요.");
//		return false;
//	}
//}

