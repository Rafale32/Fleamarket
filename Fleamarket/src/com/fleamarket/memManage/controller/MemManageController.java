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
import com.fleamarket.memManage.service.JoinFormAction;
import com.fleamarket.memManage.service.LoginAction;
import com.fleamarket.memManage.service.LogoutAction;
import com.fleamarket.memManage.service.deleteAction;
import com.fleamarket.memManage.service.detailAction;
import com.fleamarket.memManage.service.emailCheckAction;
import com.fleamarket.memManage.service.updateAction;
import com.fleamarket.memManage.service.updateFormAction;

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
    	}else if(command.equals("joinform.do")){
    		action = new JoinFormAction();
    	try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("joinAction.do")){
    		action = new JoinAction();
    	try {
			forward = action.execute(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("detailAction.do")){
    		action = new detailAction();
    	try{
    		forward = action.execute(request, response);
    	}catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("updateFormAction.do")){
    		
    		action = new updateFormAction();
    	try{
    		forward = action.execute(request, response);
    	}catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("updateAction.do")){
    		System.out.println("업뎃 액션 두 바로안");
    		action = new updateAction();
    	try{
    		System.out.println("업뎃 액션 두트라이 바로안");
    		forward = action.execute(request, response);
    		System.out.println("업뎃 액션 두트라이 바로안2");
    	}catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("deleteAction.do")){
    		action = new deleteAction();
    	try{
    		forward = action.execute(request, response);
    	}catch (Exception e) {
			e.printStackTrace();
			}
    	}else if(command.equals("emailCheckAction.do")){
    		action = new emailCheckAction();
    	try{
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
