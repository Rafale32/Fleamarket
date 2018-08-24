package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;


public class TestDeleteAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TestBoardDao DaoDel = TestBoardDao.getInstance();
		
		String str = request.getParameter("notice_no");
		
		int no_del = 0;
		if(str != null){
			no_del = Integer.parseInt(str);
		}

		MyBoard myBoard = DaoDel.delete(no_del);
		request.setAttribute("delete", myBoard);
		
		TestActionForward turn = new TestActionForward();
		turn.setPath("delSuccess.do");
		turn.setRedirect(false);
		
		return turn;
	}

}
