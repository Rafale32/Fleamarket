package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;

public class UpSuccessAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TestBoardDao DaoSuccess = TestBoardDao.getInstance();
		
		String nom = request.getParameter("notice_no");
		String cate = request.getParameter("category");
		String ti = request.getParameter("title");
		String con = request.getParameter("contents");
		/////////
		String date = request.getParameter("notice_date");
		///
		
		int us= 0;
		if(nom != null){
			us = Integer.parseInt(nom);
		}	
		MyBoard myboard = new MyBoard();
		
		myboard.setNotice_no(us);
		System.out.println("notice_no값: "+us);
		
		myboard.setCategory(cate);
		System.out.println("category값: "+cate);
		
		myboard.setTitle(ti);
		System.out.println("title값: "+ti);
		
		myboard.setContents(con);
		System.out.println("content값: "+con);
		
		DaoSuccess.update(myboard);
		///////////////
		
		TestActionForward testaction = new TestActionForward();
		testaction.setPath("customerCenterList.do");
		testaction.setRedirect(true);
		
		
		return testaction;
	}

}
