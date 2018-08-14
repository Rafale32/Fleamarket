package com.fleamarket.board.service;

import javax.servlet.http.HttpServletRequest;

import com.fleamarket.board.model.BoardDAO;

public class BoardService {
	
	private static BoardService service = new BoardService();
	private static BoardDAO dao;
	
	public static BoardService getInstance(){
		dao = BoardDAO.getInstance();
		return service;
	}
	
	
	public int insertBoardService(HttpServletRequest request) throws Exception{
		
		
		//리턴값이 필요없는 경우는 int 반환해서 정상적으로 디비 처리가 되었는지(0 -1 1) 를 리턴해준다.  
		return 0;
	}

}
