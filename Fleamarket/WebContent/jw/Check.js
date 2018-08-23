
function passwordCheckFunction(){
	var pass1 = $('#pass1').val();
	var pass2 = $('#pass2').val();
	if(pass1 != pass2){
		$('#passwordCheckMessage').html('비밀번호가 일치하지 않습니다.');
	}else{
		$('#passwordCheckMessage').html('');		
	}	
}
