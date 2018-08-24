package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestWriteViewAction implements TestAction {

	@Override
	public TestActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		TestActionForward returnWrite = new TestActionForward();
		returnWrite.setPath("/sy/notice_Write_View.jsp");
		System.out.println("공지 작성 이동");
		returnWrite.setRedirect(false);
		System.out.println("리다이렉트: False >디스패치: ture");
		System.out.println("--Return 디테일 액션--");
		return returnWrite;
		
	}
	
}
