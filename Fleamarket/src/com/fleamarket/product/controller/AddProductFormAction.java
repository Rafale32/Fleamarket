package com.fleamarket.product.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.mainDetail.model.CategoryDTO;
import com.fleamarket.product.model.ProductDAO;

public class AddProductFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp"); //원하는 경로가 완전 새로운 페이지가 아니라면 템플릿으로 가야겟지 템플릿이 헤더및 푸터 있으니까
		forward.setRedirect(false); //완전 새로운 페이지로 갈거냐 안갈거냐
		//원하는 container 파일 경로
		forward.setConPath("./subtemplate_mystore.jsp");
		//내상점의 원하는 화면
		forward.setSubConPath("./dy/addproductform.jsp");
		
		request.setAttribute("forward", forward); // 컨테이너 경로 사용하기위한 등록
		
		String catename = request.getParameter("catename");
		System.out.println(catename);
		CategoryDTO cate = new CategoryDTO();
		cate.setCategory_title(catename);
		
		
		Bean bean = (Bean)request.getAttribute("bean");
		bean.setCateList(ProductDAO.getInstance().cateList(cate));
		System.out.println(bean.getCateList().toString());
		
		
		JSONArray ja = new JSONArray();
		if(catename !=null){
//			JSONObject json = new JSONObject();
			
			for(String tmp : bean.getCateList()){
				JSONObject json = new JSONObject();
				json.put("cate", tmp);
				ja.add(json);
			}
			
			PrintWriter out = response.getWriter();
			String jsonString = ja.toJSONString();
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.print(jsonString);
			out.flush();
			
			return null;
			
		}
		
		
		return forward;
	}

}
