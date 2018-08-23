package com.fleamarket.product.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;
import com.fleamarket.product.model.ProductDAO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class ProductModifyService {
	
	private static ProductModifyService service = new ProductModifyService();
	private static ProductDAO dao;

	public static ProductModifyService getInstance(){
		dao = ProductDAO.getInstance();
		return service;
	}
	
	public void productModify(HttpServletRequest request) throws IOException{
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
		
		if (multi == null) {
			System.out.println("널이냐?");
			return;
		}else{
			itemImgList = new ArrayList<ItemImg>();
		}
		
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
		item.setItemboard_No(Integer.parseInt(multi.getParameter("itemboard_No")));
		item.setItemboard_Contents(multi.getParameter("itemboard_contents"));
		item.setTag(multi.getParameter("tag"));//태그 들어오는거 , 으로 구분 해줘야함
		item.setAmount(Integer.parseInt(multi.getParameter("amount")));
		item.setSub_Title(multi.getParameter("subsubname"));
		item.setPrice(Integer.parseInt(multi.getParameter("price")));
		HttpSession session = request.getSession();
		item.setEmail( ((MemManageDTO)session.getAttribute("member")).getEmail() );
		item.setCategory_Title(multi.getParameter("subname"));//대 카테고리명 
		
		Enumeration forms = multi.getFileNames();
		
		while (forms.hasMoreElements()) { 
			
			
			formName = (String) forms.nextElement();

			
			fileName = multi.getFilesystemName(formName);// 실제 업로드된 파일명
			
			if (fileName != null)
			{
				String pattern = fileName.substring(fileName.indexOf(".")+1); //확장자명
				String headName = fileName.substring(0, fileName.indexOf("."));//확장자 뺀 파일명

				String imagePath = savePath + "\\" + fileName; 
				File src = new File(imagePath);
				
				String thumImagePath = savePath + "\\"+ headName + "_small." + pattern;
				File dest = new File(thumImagePath);
				
				ImageUtil.resize(src, dest, 200, ImageUtil.RATIO);
				
				
				ItemImg itemImg = new ItemImg();
				itemImg.setBig_Img(fileName);
				itemImg.setThum_Img(headName + "_small." + pattern);
				itemImgList.add(itemImg);
				
			}
			
		}
		item.setItemImgList(itemImgList);
		
		dao.updateProduct(item);
		
		
	}
}
