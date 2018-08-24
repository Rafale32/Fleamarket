/**
 * 
 */

// 구매 확정
function deleteCheck(e){
	if (confirm("구매확정 하시겠습니까?")) 
	{
		alert('ok')
		return true;
		//document.getElementById('ff').submit();
	} else {
		alert("구매 확정 안 되었습니다.");
		//e.preventDefault();
		return false;
	}	
}

// 판매 승인
function deleteCheck2(e){
	if (confirm("판매승인 하시겠습니까?")) 
	{
		alert('ok')
		return true;
		//document.getElementById('ff').submit();
	} else {
		alert("판매 승인 취소 했습니다.");
		//e.preventDefault();
		return false;
	}	
}