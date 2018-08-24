package com.fleamarket.board.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.soap.Detail;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;


public class TestUpdateAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("");
		System.out.println("--UpdateAction--");
		//객체 생성하는 코드 
		TestBoardDao DaoUpdate = TestBoardDao.getInstance();
		
		//notice_no를 가져오는 것을 요청
		String str = request.getParameter("node_no");
		System.out.println("str 확인 : "+str);
		
		int ups = 0;
		if(str != null){
			ups = Integer.parseInt(str);
		}
		
		MyBoard myBoard = DaoUpdate.detail(ups);
		request.setAttribute("ups", myBoard);
		
		TestActionForward upaction = new TestActionForward();
		upaction.setPath("updateView.jsp");
		upaction.setRedirect(false);
		System.out.println("--retrun UpdateAcation--");
		return upaction;
	}

}
