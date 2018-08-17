package com.fleamarket.memManage.controller;

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
import com.fleamarket.memManage.service.CheckloginAction;
import com.fleamarket.memManage.service.JoinAction;
import com.fleamarket.memManage.service.LoginAction;
import com.fleamarket.memManage.service.LogoutAction;

//경로관련된 문자는 모두 무조건 소문자로  /맡은페이지경로/원하는작업.do  식으로 처리하기
@WebServlet("/memmanage/*")
public class MemManageController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	public MemManageController() {
		
        super();
        
    }
    
	
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	request.setCharacterEncoding("utf-8");
    	
    	String requestURI = request.getRequestURI();
    	
    	
    	String contextPath = request.getContextPath();
    	System.out.println(contextPath); 
    	contextPath += "memmanage/";
    	String command = requestURI.substring(contextPath.length()+1); 
    	System.out.println(command);
    	
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	
    	if(request.getAttribute("bean") == null){
    		Bean bean = new Bean(request);
    		request.setAttribute("bean", bean);
    	}
    	
    	
    	if(command.equals("login.do")){
    		action  = new LoginAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("checklogin.do")){
    			action  = new CheckloginAction();
    		try {
    			forward = action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
    	}else if(command.equals("logout.do")){
			action  = new LogoutAction();
		try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("join.do")){
    		action = new JoinAction();
    	}try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
