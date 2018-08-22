package com.fleamarket.payment.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.fleamarket.mapper.PaymentMapper;
import com.fleamarket.payment.model.PaymentPagingDTO_gy;
import com.fleamarket.payment.model.PuerchaseDAO_gy;
import com.fleamarket.payment.model.PuerchaseDTO_gy;


public class PaymentPagingService_gy {
	
	private static final int PAGE_SIZE =2;
	private static PaymentPagingService_gy service = new PaymentPagingService_gy();
	private static PuerchaseDAO_gy dao = new PuerchaseDAO_gy();
	
	public static PaymentPagingService_gy getInstance(){
		dao = PuerchaseDAO_gy.getInstance();
		return service;
	}
	
	

	public List<PuerchaseDTO_gy> listBoard(int startRow){
		
		SqlSession sqlSession = dao.getSqlSessionFactory().openSession(); // sql 세션 객체를 구할수 있게 되었답니다.
		List<PuerchaseDTO_gy>  list = null;
		
		try {
			//마이바 티스 문법
			list = sqlSession.getMapper(PaymentMapper.class).listBoardService(new RowBounds(startRow,2)); // 스타트 로우에서 2개
			//list = sqlSession.selectList("kosta.mapper.BoardMapper.listBoard");
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			sqlSession.close();
		}
		
		return list;
		
	}
	
	
	
	public PaymentPagingDTO_gy listBoardService(int requestPage, HttpServletRequest request){
		//페이지 당 글 갯수, 총글갯수, 총페이지 수, 현재 페이지, 시작페이지. 마지막 페이지
		//startRow, endRow => 데이터 출력(List)
		HttpSession session = request.getSession(); //검색후 다른 페이지 넘어갈때 전체 페이지 뜨는것 방지하기 위한 두가지 방법중 1)javascript 2)session 중 session이용방법
		Search_gy search = new Search_gy();
		//총글갯수 구하기
		int totalCount = dao.countBoard(); 
		//총 페이지수 구하기
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE >0){
			totalPageCount++;
		}
		
		//시작페이지 구하기 : 시작페이지 = 현재페이지 - (현재페이지 -1)%5 (10개씩 원하면 %10)
		int startPage = requestPage - (requestPage-1) % 5;
		
		//마지막페이지 구하기
		int endPage = startPage +4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		//시작글 구하기 : (현재페이지 -1) * 페이지당 글갯수
		int startRow = (requestPage-1) * PAGE_SIZE;
		List<PuerchaseDTO_gy> list = dao.listBoard(startRow);
		PaymentPagingDTO_gy listModel = new PaymentPagingDTO_gy(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
	}
	
	public PaymentPagingDTO_gy listBoardService2(int requestPage, HttpServletRequest request){
		//페이지 당 글 갯수, 총글갯수, 총페이지 수, 현재 페이지, 시작페이지. 마지막 페이지
		//startRow, endRow => 데이터 출력(List)
		HttpSession session = request.getSession(); //검색후 다른 페이지 넘어갈때 전체 페이지 뜨는것 방지하기 위한 두가지 방법중 1)javascript 2)session 중 session이용방법
		Search_gy search = new Search_gy();
		//총글갯수 구하기
		int totalCount = dao.countBoard(); 
		//총 페이지수 구하기
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE >0){
			totalPageCount++;
		}
		
		//시작페이지 구하기 : 시작페이지 = 현재페이지 - (현재페이지 -1)%5 (10개씩 원하면 %10)
		int startPage = requestPage - (requestPage-1) % 5;
		
		//마지막페이지 구하기
		int endPage = startPage +4;
		if(endPage > totalPageCount){
			endPage = totalPageCount;
		}
		
		//시작글 구하기 : (현재페이지 -1) * 페이지당 글갯수
		int startRow = (requestPage-1) * PAGE_SIZE;
		List<PuerchaseDTO_gy> list = dao.listBoard2(startRow);
		PaymentPagingDTO_gy listModel = new PaymentPagingDTO_gy(list, requestPage, totalPageCount, startPage, endPage);
		
		return listModel;
	}

	

}
