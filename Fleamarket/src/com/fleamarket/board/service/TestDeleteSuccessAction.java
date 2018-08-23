package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.TestBoardDao;



public class TestDeleteSuccessAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TestBoardDao DaoDelSuccess = TestBoardDao.getInstance();
		
		

		return null;
	}

}
