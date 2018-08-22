function loginCheck(){	
	if(document.frm.email.value.length == 0){
		alert("Email을 입력하세요");
		frm.email.focus();
		return false;
	}
	if(document.frm.password.value ==""){
		alert("패스워드를 입력하세요");
		frm.password.focus();
		return false;
	}
	return true;
}
function emailCheck(){
	if(document.frm.email.value ==""){
		alert("이메일을 입력하세요")
		document.frm.email.focus();
		return;
	}
}