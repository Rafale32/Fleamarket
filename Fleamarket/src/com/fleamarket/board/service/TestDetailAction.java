package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.board.model.MyBoard;
import com.fleamarket.board.model.TestBoardDao;


public class TestDetailAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("");
		System.out.println("--디테일 액션 테스트 실행--");
		TestBoardDao DaoDetail = TestBoardDao.getInstance();
		
		String str = request.getParameter("notice_no");
		
		System.out.println("str값: "+str);
		
		int no = 0;
		
		if(str != null){
			no = Integer.parseInt(str);
		}
		System.out.println("no 확인: "+no);
		MyBoard myBoard = DaoDetail.detail(no);
		System.out.println(myBoard.toString());
		request.setAttribute("sede", myBoard);
		
		
		TestActionForward testaf = new TestActionForward();
		testaf.setPath("/sy/detailView.jsp");
		System.out.println("디테일 뷰.jsp 이동");
		testaf.setRedirect(false);
		System.out.println("리다이렉트: Falese >디스패치: ture");
		System.out.println("--Return 디테일 액션--");
		return testaf;
	}

}
