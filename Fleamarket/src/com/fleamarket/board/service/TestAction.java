package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TestAction { 
	public TestActionForward execute(HttpServletRequest request,
			HttpServletResponse response)throws Exception;
	
	
}
