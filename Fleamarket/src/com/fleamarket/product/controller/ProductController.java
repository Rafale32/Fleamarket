package com.fleamarket.product.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.product.service.ImgDeleteService;


//경로관련된 문자는 모두 무조건 소문자로  /맡은페이지경로/원하는작업.do  식으로 처리하기
@WebServlet("/product/*")
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ProductController() {
        super();
        
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	request.setCharacterEncoding("utf-8");
    	response.setCharacterEncoding("utf-8");
    	response.setContentType("text/html; charset=UTF-8");
    	
    	String requestURI = request.getRequestURI();
    	
    	
    	String contextPath = request.getContextPath();
    	System.out.println(contextPath); 
    	contextPath += "product/";
    	String command = requestURI.substring(contextPath.length()+1); 
    	System.out.println(command);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(request.getAttribute("bean") == null){
    		Bean bean = new Bean(request);
    		request.setAttribute("bean", bean);
    	}
    	
    	
    	if(command.equals("product.do")){
    		action  = new ProductAction();
    		try {
    			forward = action.execute(request, response);//포워드 리턴 해주지
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("productlist.do")){
    		action  = new ProductListAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("addproductform.do")){ // 물품 추가 폼으로
    		action  = new AddProductFormAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("addproduct.do")){ // 물품 추가 디비와 서버에 파일 넣는곳
    		action  = new AddProductAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("productdelete.do")){ //등록된 물품 삭제 
    		action  = new ProductDeleteAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("productmodifyform.do")){ //물품 수정폼 으로 가서 수정할값 디비에서 가져옴
    		action  = new ProductModifyFormAction();
    		try {
    			forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("imgdelete.do")){ //이미지 아작스로 삭제하는것
    		action  = new ImgDeleteService();
    		try {
    			forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("productmodify.do")){ //상품 수정 내용 반영 하는곳
    		action  = new ProductModifyAction();
    		try {
    			forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("searchall.do")){ //상품 전체 검색 및 아작스로 처리되는 추가 아이템
    		action  = new SearchAllAction();
    		try {
    			forward = action.execute(request, response);
			}catch (Exception e) {
				e.printStackTrace();
			}
    	}
    	
    	
    	
    	if(forward != null){
    		if(forward.isRedirect()){
    			response.sendRedirect(forward.getPath());
    		}else{
    			
    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
    			dispatcher.forward(request, response);
    			
    		}
    	}
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}

}
