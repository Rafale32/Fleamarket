package com.fleamarket.bean;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Action {
	//코드에 일관성에 도움이 되는 인터페이스
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
	
}
