package com.fleamarket.product.controller;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.service.SearchAllService;

public class SearchAllAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		SearchAllService service = SearchAllService.getInstance();
		int start = 0 ; //시작 로우
		int size = 0 ; //한번에 몇개씩로우 가지고 올건지
		
		ActionForward forward = new ActionForward();
		forward.setPath("/template.jsp");
		forward.setRedirect(false);
		forward.setConPath("./dy/searchresult.jsp");
		
		String searchSubj = request.getParameter("searchSubj");
		String ajax = request.getParameter("aja");
		//System.out.println(ajax+":::::"+searchSubj);
		
		if(ajax != null){
			start = (Integer)session.getAttribute("searchStartpage");
			size = 2;
			List<ItemDTO> list = service.searchAll(searchSubj, start, size);
			
			
			
			
			
/*			썸네일 한개 = itemboard_Contents 여기에 임시로 씀
					가격 price 
					제목 title
					거래지역 local
					아이템 보드 넘버 itemboard_No */
			
				JSONArray ja = new JSONArray();
				for(ItemDTO tmp : list){
					JSONObject json = new JSONObject();
					json.put("itemboard_No", tmp.getItemboard_No());
					json.put("thum_img", tmp.getItemboard_Contents()); //컨텐츠는 썸네일 이미지 한개임 임시로 쓰는것임
					json.put("price", tmp.getPrice());
					json.put("local", tmp.getLocal());
					json.put("title", tmp.getTitle());
					
					JSONObject json2 = new JSONObject();
					json2.put("item", json);
					ja.add(json2);
					
				}
				
				PrintWriter out = response.getWriter(); 
				String jsonString = ja.toJSONString();
				//System.out.println(jsonString);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				out.print(jsonString);
				out.flush();
				
				
			start += size;
			session.setAttribute("searchStartpage", start);
			
			return null;
		}else{
			
			Bean bean = (Bean)request.getAttribute("bean");
			start =1;
			size = 4;
			bean.setItemList(service.searchAll(searchSubj,start,size));
			session = request.getSession();
			session.setAttribute("searchStartpage", start);
			
			request.setAttribute("forward", forward);
		}
		
		
		return forward;
	}

}
