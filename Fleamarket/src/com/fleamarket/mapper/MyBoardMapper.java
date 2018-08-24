package com.fleamarket.mapper;

import java.util.List;

import org.apache.ibatis.session.RowBounds;

import com.fleamarket.board.model.MyBoard;


public interface MyBoardMapper {
	int insertBoard(MyBoard myBoard);
	List<MyBoard> ListBoard(/*RowBounds row*/);
	MyBoard detail(int notice_no);
	int update(MyBoard myBoard);
	MyBoard delete(int notice_no);
	
	
	//List<MyBoard> ListBoard();
	
}
