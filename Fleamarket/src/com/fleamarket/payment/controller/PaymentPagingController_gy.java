package com.fleamarket.payment.controller;

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
import com.fleamarket.payment.service.PaymentPagingAction_gy;
import com.fleamarket.payment.service.changeDeliveryPuerchaseAction_gy;
import com.fleamarket.payment.service.changeDeliverySellAction_gy;


//경로관련된 문자는 모두 무조건 소문자로  /맡은페이지경로/원하는작업.do  식으로 처리하기
@WebServlet("*.gy")
public class PaymentPagingController_gy extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public PaymentPagingController_gy() {
		
        super();
        
    }
    
	
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	request.setCharacterEncoding("utf-8");
    	
    	String requestURI = request.getRequestURI();
    	
    	
    	String contextPath = request.getContextPath();
    	System.out.println(contextPath + " : 컨텍 페스"); 
    	contextPath += "payment/_view/";
    	String command = requestURI.substring(contextPath.length()+1); 
    	System.out.println(command + " : 코멘드건엽33");
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	if(request.getAttribute("bean") == null){
    		Bean bean = new Bean(request);
    		request.setAttribute("bean", bean);
    	}
    	
    	
    	//페이먼트 체인지 한것
		if (command.equals("PaymentPagingAction_gy.gy")) {
			System.out.println("페이먼트 ");
			action = new PaymentPagingAction_gy();

			try {

				forward = action.execute(request, response); // 액션 포어들에 어떻게 갈지랑
																// 어디로 갈지가 나옴,
			} catch (Exception e) {

				e.printStackTrace();
			}

		}else if(command.equals("changeDeliveryChack_gy.gy")){
			System.out.println("gy가즈아!");
			action = new changeDeliveryPuerchaseAction_gy();
			try {
		
				forward = action.execute(request, response); // 액션 포어들에 어떻게 갈지랑
			} catch (Exception e) {

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
