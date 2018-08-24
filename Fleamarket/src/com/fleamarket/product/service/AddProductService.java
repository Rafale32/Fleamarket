package com.fleamarket.product.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;
import com.fleamarket.product.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class AddProductService {
	
	private static AddProductService service = new AddProductService();
	private static ProductDAO dao;
	
	
	public AddProductService() {	}
	
	public static AddProductService getInstance(){
		dao = ProductDAO.getInstance();
		
		return service;
	}
	

	
	
	public void insertItemNBoard(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ItemDTO item = new ItemDTO();
		List<ItemImg> itemImgList;
		
		MultipartRequest multi = null;
		File file = null;

		String savePath = request.getRealPath("/productimg").replaceAll("\\\\", "/"); // 저장할
																					// 디렉토리
		
		int  sizeLimit = 20 * 1024 * 1024; // 용량제한

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
			return;
		}else{
			itemImgList = new ArrayList<ItemImg>();
		}
		
		/*String subName; // 소 카테고리 이름
		String local; //거래지역
		int item_state; // 상품의 상태 새상품 상중하  0 1 2 3 4  새상품 상 중 하 
		String change_Ornot; //교환 가능 여부
		private int delivery_Fee;// 배송비 포함 여부
		String itemboard_Contents; / 상품게시판의 상품설명
		String tag;// 태그
		int amount; //상품 수량
		*/
		
		item.setTitle(multi.getParameter("title"));
		item.setLocal(multi.getParameter("local"));
		switch (multi.getParameter("item_state")) {
			case "새상품":
				item.setItem_State(0);
			break;
			case "상":
				item.setItem_State(1);
			break;
			case "중":
				item.setItem_State(2);
			break;
			case "하":
				item.setItem_State(3);
			break;
		}
		if(multi.getParameter("change_ornot") == null){
			item.setChange_Ornot(0);
		}else{
			item.setChange_Ornot(1);
		}
		if(multi.getParameter("delivery_fee") == null){
			item.setDelivery_Fee(0);
		}else{
			item.setDelivery_Fee(1);
		}
		item.setItemboard_Contents(multi.getParameter("itemboard_contents"));
		item.setTag(multi.getParameter("tag"));//태그 들어오는거 , 으로 구분 해줘야함
		item.setAmount(Integer.parseInt(multi.getParameter("amount")));
		item.setSub_Title(multi.getParameter("subsubname"));
		item.setPrice(Integer.parseInt(multi.getParameter("price")));
		HttpSession session = request.getSession();
		item.setEmail( ((MemManageDTO)session.getAttribute("member")).getEmail() );
		item.setCategory_Title(multi.getParameter("subname"));//대 카테고리명 
		
		
		Enumeration forms = multi.getFileNames();
		// getFileNames() : input태그 중 속성이 file로 된
		// 파라미터 이름 모두 반환, 벡터에 넣은 순서대로 생성
		
		//System.out.println("2번 들어옴?");
		//System.out.println(forms.toString());
		
		while (forms.hasMoreElements()) { // 업로드 파일의 정보를 받기 위해서 반복문으로 업로드 파일의
			// 엘레먼트를 받는다.
			// hasMoreElements() : 커서가 있는 위치 다음에 데이타가 존재하는지
			
			
			formName = (String) forms.nextElement();
			// nextElement() : 첫번째 객체가 리턴되고
			// 실행 후의 커서는 첫번째 데이타를 지나 두번째 데이타가 있는 곳을 가리킴.
			
			
			fileName = multi.getFilesystemName(formName);// 실제 업로드된 파일명
			
			//System.out.println("폼이름?? : "+formName);
			//System.out.println("파일명 : " + fileName);
			
			
			
			if (fileName != null) // 큰파일 리사이즈 및  큰파일과 썸네일 저장
			{
				String pattern = fileName.substring(fileName.indexOf(".")+1); //확장자명
				String headName = fileName.substring(0, fileName.indexOf("."));//확장자 뺀 파일명
				
				/*썸네일과 큰이미지 저장경로 다르게 하려했지만 멀티파트가 실행될때 savePath 에 워본 이미지가 먼저 저장이
				되고 그 상태에서 원본이지미  가지고 와서 리 사이즈 하기 때문에 경로 다르게 저장이안됨 
				나중에 따로 알아봐야할듯함
				String imagePath = savePath + "\\"+ "bigimg"+ "\\" + fileName;

				String thumImagePath = savePath + "\\" + "thumimg" + "\\" + headName + "_small." + pattern;*/
				
				
				//원본 파일 객체
				String imagePath = savePath + "\\" + fileName; 
				File src = new File(imagePath);
				
				//썸네일 이미지 File객체
				String thumImagePath = savePath + "\\"+ headName + "_small." + pattern;
				File dest = new File(thumImagePath);
				//file = multi.getFile(formName); // 파일 객체 생성
				
				ImageUtil.resize(src, dest, 200, ImageUtil.RATIO);
				
				
				ItemImg itemImg = new ItemImg();
				itemImg.setBig_Img(fileName);
				itemImg.setThum_Img(headName + "_small." + pattern);
				itemImgList.add(itemImg);
				
			}
			
		}
		item.setItemImgList(itemImgList);
		
		//--------------------------------------------------------------------------------------------
		//  디비에 값넣을시 고려할것  
		//서브카테고리 번호	/	등록일자 = sysdate / 조회수 0 으로 생성/내상점의 상점번호 /상품의 상품번호
		//파일이름 _small 붙음 이거 비교 해서 
		//--------------------------------------------------------------------------------------------
		
		//1 아이템 로우 생성  2. 아이템보드 로우 생성 3. 이미지 로우 넣기 3. 커밋 아니면 롤백  4. 세션 close
		dao.insertItemNBoard(item);
		
		
	}

}
