package com.fleamarket.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;



public class TestListAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//1.비지니스 모델, 뭘할지 
		TestBoardDao DaoList = TestBoardDao.getInstance();
		List<MyBoard> list = DaoList.testlistBoard();
		//2 setattribute
		request.setAttribute("Listview", list);
		
		//어디로 어떻게 갈지 코드
		System.out.println("");
		System.out.println("--TestListAction--");
		TestActionForward testActionForward = new TestActionForward();
		testActionForward.setPath("customerCenterList.jsp");
		testActionForward.setRedirect(false);
		System.out.println("경로 in 리스트 엑션안  "+testActionForward.getPath());
		
		return testActionForward;
	}

}
