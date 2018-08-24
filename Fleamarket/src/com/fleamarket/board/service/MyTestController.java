package com.fleamarket.board.service;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class MyTestController extends HttpServlet {
	// serialversionUID를 확인합니다.
	public static final long serialversionUID = 1L;

	public MyTestController() {
		super();
		System.out.println("");
		System.out.println("--컨트롤러--");
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("");
		System.out.println("-doprocess-");
		
		String requestURI = request.getRequestURI();
		System.out.println("grURI : " + requestURI);
		
		String contextPath = request.getContextPath() + "/sy";
		System.out.println("gcPAth : " + contextPath);

		String command = requestURI.substring(contextPath.length() + 1);
		System.out.println("진행프로세스 : " + command);
		
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
		} else{
			
		}

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

}
