package com.fleamarket.product.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.memManage.model.MemManageDTO;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.ItemImg;
import com.fleamarket.product.service.ProductListService;

public class ProductListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
		forward.setRedirect(false); //완전 새로운 페이지로 갈거냐 안갈거냐
		//원하는 container 파일 경로
		forward.setConPath("./subtemplate_mystore.jsp");
		//내상점의 원하는 화면
		forward.setSubConPath("./dy/productlist.jsp");
		
		request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
		
		
		
		ProductListService plService = ProductListService.getInstance();
		
		String storeName =  request.getParameter("store_name");
		
		HttpSession session = request.getSession();
		MemManageDTO mmDTO = (MemManageDTO)session.getAttribute("member");
		
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int requestPage = Integer.parseInt(pageNum);
		
		List<ItemDTO> resultList;
		if(mmDTO == null){
			resultList = plService.productListService(null, storeName,requestPage ,request);
		}else{
			resultList = plService.productListService(mmDTO.getEmail(), storeName,requestPage ,request);
		}
		
		//이미지 경로는 이렇게 전체 리얼패스를 쓰는게 아니라 프로젝트 상의 경로로 써야함  /Fleamarket/productimg/${tmp2.thum_Img } 이런식으로
/*		String realPath = request.getRealPath("/productimg");
		for(ItemDTO tmp : resultList){
			for(ItemImg tmp2 : tmp.getItemImgList()){
				tmp2.setRealThumImg(realPath+"\\"+tmp2.getThum_Img());
			}
		}*/
		
		Bean bean = (Bean)request.getAttribute("bean");
		bean.setItemList(resultList);
		
		return forward;
		
	}

}
