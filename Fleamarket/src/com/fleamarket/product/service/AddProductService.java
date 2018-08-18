package com.fleamarket.product.service;

import java.io.File;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddProductService {
	

/*String subName; // 소 카테고리 이름
String local; //거래지역
int item_state; // 상품의 상태 새상품 상중하
String change_Ornot; //교환 가능 여부
private int delivery_Fee;// 배송비 포함 여부
String itemboard_Contents; / 상품게시판의 상품설명
String tag;// 태그
int amount; //상품 수량
*/
	
	public AddProductService(HttpServletRequest request, HttpServletResponse response) {
		
		MultipartRequest multi = null;
		File file = null;

		String savePath = request.getRealPath("/dy/test").replaceAll("\\\\", "/"); // 저장할
																					// 디렉토리
		System.out.println("파일 시스템 들어옴?");
		
		int sizeLimit = 20 * 1024 * 1024; // 용량제한

		String formName = "";
		String fileName = "";

		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if (multi == null) { //파일이 없으면 그냥 디비에 넣지 않고 종료
//			response.setContentType("text/html; charset=UTF-8");
			//response.setCharacterEncoding("UTF-8");
			//response.getWriter().write("<script>alert('업로드실패'); location.href='/';</script>");
			System.out.println("널이냐?");
			return;
		}

		Enumeration forms = multi.getFileNames();
		// getFileNames() : input태그 중 속성이 file로 된
		// 파라미터 이름 모두 반환, 벡터에 넣은 순서대로 생성
		System.out.println("2번 들어옴?");
		System.out.println(forms.toString());
		while (forms.hasMoreElements()) { // 업로드 파일의 정보를 받기 위해서 반복문으로 업로드 파일의
			// 엘레먼트를 받는다.
			// hasMoreElements() : 커서가 있는 위치 다음에 데이타가 존재하는지

			formName = (String) forms.nextElement();
			// nextElement() : 첫번째 객체가 리턴되고
			// 실행 후의 커서는 첫번째 데이타를 지나 두번째 데이타가 있는 곳을 가리킴.
			
			
			fileName = multi.getFilesystemName(formName);// 실제 업로드된 파일명
			
			System.out.println("폼이름?? : "+formName);
			System.out.println("파일명 : " + fileName);

			if (fileName != null) // 파일이 업로드 되면
			{
				file = multi.getFile(formName); // 파일 객체 생성
			}
			// ---- 이하 생략 ----
		}

	}

}
