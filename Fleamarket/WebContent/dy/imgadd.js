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



var sel_files = [];
var cnt = 0;

$(document).ready(function() {
	$("#imgfiles").on("change", handleImgsFilesSelect);
	
	$(".imgs_wrap").on("click", deletefile);
	
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
			var img_input = "<input type='file' id='input_imgs"+ cnt +"' multiple/>";
			$("#imgfiles").append(img_input);
			
			//disabled="disabled"
			var inputName = "input_imgs"+(cnt-1);
			$("#"+inputName).attr("disabled","disabled");
			
		}
		reader.readAsDataURL(f);
	});
}


function deletefile(e){
	var files = e.target.files;
	var filesArr = Array.prototype.slice.call(files);
	alert("asdf");
	
}