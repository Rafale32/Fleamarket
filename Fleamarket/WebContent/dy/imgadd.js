/*var sel_files = [];

$(document).ready(function() {
	$("#input_imgs").on("change", handleImgsFilesSelect);
});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);

	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\" />";
			$(".imgs_wrap").append(img_html);
		}
		reader.readAsDataURL(f);
	});
}*/



/*var sel_files = [];
var cnt = 0;

$(document).ready(function() {
	$("#imgfiles").on("change", handleImgsFilesSelect);
	
	$(".imgs_wrap").on("click", function() {
		alert("ASdf");
	});
	
	
	$("#subname").on("change", function(e) {
		
		var tmp = $("#subname").val();
		$("#cate").empty();
		
		$.ajax({
			url: "/Fleamarket/product/addproductform.do?catename="+tmp,
			type: "post",
			dataType: "json",
			success: function(data){
				$("#cate").append("<select name='subsubname' id='subsubname'>");
				$.each(data,function(key,value) {
					
				//	$("#subsubname").empty();
				//	alert('key:'+key+', name:'+value.cate);
					$("#subsubname").append( "<option value='"+ value.cate +"'>"+ value.cate +"</option>" );
					
				});
				$("#cate").append("</select>");
			}
		});
		
	});
	
	
});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	
	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\"" +  'id=img'+ cnt + "/>";
			$(".imgs_wrap").append(img_html);
			
			cnt++;
			var img_input = "<input type='file' id='inputimgs"+ cnt +"' name='inputimgs"+cnt+"'/>";
			$("#imgfiles").append(img_input);
			
			//disabled="disabled"
			//var inputName = "inputimgs"+(cnt-1);
			//$("#"+inputName).attr("disabled","disabled");
			
		}
		reader.readAsDataURL(f);
	});
}*/


var sel_files = [];
var cnt = 0;

$(document).ready(function() {
	$("#imgfiles").on("change", handleImgsFilesSelect);
	
/*	$(".imgs_wrap").on("click", function() {
		alert("ASdf");
	});*/
	
	$("#subname").on("change", function(e) {
		
		var tmp = $("#subname").val();
		$("#cate").empty();
		
		$.ajax({
			url: "/Fleamarket/product/addproductform.do?catename="+tmp,
			type: "post",
			dataType: "json",
			success: function(data){
				$("#cate").append("<select name='subsubname' id='subsubname'>");
				$.each(data,function(key,value) {
					
				//	$("#subsubname").empty();
				//	alert('key:'+key+', name:'+value.cate);
					$("#subsubname").append( "<option value='"+ value.cate +"'>"+ value.cate +"</option>" );
					
				});
				$("#cate").append("</select>");
			}
		});
		
	});
	

});

function handleImgsFilesSelect(e) {
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	
	
	filesArr.forEach(function(f) {
		if (!f.type.match("image.*")) {
			alert("확장자는 이미지 확장자만 가능합니다.");
			return;
		}

		sel_files.push(f);

		var reader = new FileReader();
		reader.onload = function(e) {
			var img_html = "<img src=\"" + e.target.result + "\"" +  'id=img'+ cnt + "/>";
			$(".imgs_wrap").append(img_html);
			
			cnt++;
//			var img_input = "<input type='file' id='inputimgs"+ cnt +"' name='inputimgs"+cnt+"'/>";
//			$("#imgfiles").append(img_input);
			
			//disabled="disabled"
			//var inputName = "inputimgs"+(cnt-1);
			//$("#"+inputName).attr("disabled","disabled");
			
		}
		reader.readAsDataURL(f);
	});
}

//아작스로 그림파일 지우고 디비값도 지우기
$(function() {
	
	/*$('.imgs_wrap.btn').on('click', function(e) {
		var a = this.attr('type');
		alert(a);
		return false;
	});*/

	$('body').on('click','.imgs_wrap_now .btn', function(){
		var img = $(this).val();
		var b =img.split('/');
		var big_Img , thum_Img, index;
		var cnt=0;
		for (let tmp of b) {
			if(cnt==0){
				thum_Img=tmp;
			}
			if(cnt==1){
				big_Img=tmp;
			}
			if(cnt==2){
				index=tmp;
			}
			cnt++;
		}
		
		alert(big_Img+":::::::::"+thum_Img);
		
		if(confirm("이미지를 삭제 하시겠습니까?")){
			$.ajax({
				url: "/Fleamarket/product/imgdelete.do?big_Img="+big_Img+"&thum_Img="+thum_Img,
				type: "post",
				success: function(){
					$(".img"+index).remove();
					$("#btn"+index).remove();
				}
			});
		}
		
		//기본이벤트 취소
		return false;
	});
})
