package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;



public class TestInsertAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("");
		System.out.println("--Insert_Action_--");
		MyBoard myboard = new MyBoard();
		
		myboard.setCategory(request.getParameter("category"));
		myboard.setTitle(request.getParameter("title"));
		myboard.setContents(request.getParameter("contents"));
		
		TestBoardDao testdao = TestBoardDao.getInstance();
		
		testdao.insertBoard(myboard);
		
		TestActionForward Actionforward = new TestActionForward();
		Actionforward.setPath("customerCenterList.do");
		System.out.println("경로: "+Actionforward.getPath());
		Actionforward.setRedirect(true);
		
		System.out.println("-Insert_Action_RETURN-");
		return Actionforward;
	}

}
