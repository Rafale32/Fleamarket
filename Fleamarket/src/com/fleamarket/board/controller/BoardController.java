package com.fleamarket.board.controller;

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
import com.fleamarket.board.service.TestAction;
import com.fleamarket.board.service.TestActionForward;
import com.fleamarket.board.service.TestDeleteAction;
import com.fleamarket.board.service.TestDetailAction;
import com.fleamarket.board.service.TestInsertAction;
import com.fleamarket.board.service.TestListAction;
import com.fleamarket.board.service.TestUpdateAction;
import com.fleamarket.board.service.TestWriteViewAction;
import com.fleamarket.board.service.UpSuccessAction;

//경로관련된 문자는 모두 무조건 소문자로  /맡은페이지경로/원하는작업.do  식으로 처리하기
@WebServlet("/board/*")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public BoardController() {
		
        super();
        
    }
    
    public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	
    	request.setCharacterEncoding("utf-8");
    	
    	String requestURI = request.getRequestURI();
    	
    	
    	String contextPath = request.getContextPath();
    	System.out.println(contextPath); 
    	contextPath += "board/";
    	String command = requestURI.substring(contextPath.length()+1); 
    	System.out.println(command);
    	System.out.println("여기냐 설마");
    	
    	Action action = null;
    	ActionForward forward = null;
    	
    	if(request.getAttribute("bean") == null){
    		Bean bean = new Bean(request);
    		request.setAttribute("bean", bean);
    	}
    	
//    	if(command.equals("원하는작업.do")){
//    		//action  = new 원하는작업액션클래스();
//    		try {
//    			forward = action.execute(request, response);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//    	}
		
		TestAction testAction = null;
		TestActionForward ActionForward = null;
		
		if (command.equals("testInsertAction.do")) {
			System.out.println("--con insertAction--");
			testAction = new TestInsertAction();
			System.out.println("--con insertAction2--");
			try {
				System.out.println("--con insertAction3--");
				ActionForward = testAction.execute(request, response);
				System.out.println("--con insertAction4--");
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (command.equals("customerCenterList.do")) {
			System.out.println("-con CClist-");
			testAction = new TestListAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			// testAction = new customerCenterMainView();
		} else if (command.equals("detail.do")){
			testAction = new TestDetailAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} else if (command.equals("update.do")){
			testAction = new TestUpdateAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("upsuccess.do")){
			testAction = new UpSuccessAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("TestWriteViewAction.do")){
			testAction = new TestWriteViewAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("TestDeleteAction.do")){
			testAction = new TestDeleteAction();
			try {
				ActionForward = testAction.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		//ActionForward가 null값이 아니면 진행
		if (ActionForward != null) {
			if (ActionForward.isRedirect()) {
				response.sendRedirect(ActionForward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(ActionForward.getPath());
				dispatcher.forward(request, response);
			}
		}  	
    	
    	
    	
//    	if(forward != null){
//    		if(forward.isRedirect()){
//    			response.sendRedirect(forward.getPath());
//    		}else{
//    			
//    			RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
//    			dispatcher.forward(request, response);
//    			
//    		}
//    	}
    	
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doProcess(request, response);
	}


}
