package com.fleamarket.board.model;

import java.io.InputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.swing.GroupLayout.SequentialGroup;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;import com.fleamarket.mapper.BoardMapper;
import com.fleamarket.mapper.MyBoardMapper;


public class TestBoardDao {
	private static TestBoardDao tdao = new TestBoardDao();
		
	// getinstance = 인스턴스가 한개이다.
	public static TestBoardDao getInstance() {
		System.out.println("");
		System.out.println("--Dao Instance--");
		
		return tdao;
	}

	
	public SqlSessionFactory getSqlSessionFactory(){
		System.out.println("-Dao SqlSessionFactory-");
		String resource = "TestMybatis-config.xml";
		System.out.println("resource : "+resource);
		InputStream in = null;
		try {
			System.out.println("-Session Factory *TRY*-");
			in = Resources.getResourceAsStream(resource);
			System.out.println("펙토리 트라이안 22");
		} catch (Exception e) {
			e.printStackTrace();
		}
			System.out.println("SqlSession 리턴 ");
		return new SqlSessionFactoryBuilder().build(in);
	}

	public int insertBoard(MyBoard MyBoard) {
		int re = -1;
		System.out.println("-Dao inserBoard-");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		System.out.println("인서트 보드객체 안");
		try {												//id를 가지고 접근한다.
			re = sqlSession.getMapper(MyBoardMapper.class).insertBoard(MyBoard);
			System.out.println("인서트 보드객체 try");
			if (re > 0) {
				System.out.println(" : 커밋됨");
				sqlSession.commit();
			} else {
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("sqlsession 닫음");
			sqlSession.close();
		}

		return re;
	}
	
	public List<MyBoard> testlistBoard(){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<MyBoard> list = null;
		
		try {
			list = sqlSession.getMapper(MyBoardMapper.class).ListBoard();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
	public MyBoard detail(int notice_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MyBoard myBoard = null;
		
		try {
			myBoard = sqlSession.getMapper(MyBoardMapper.class).detail(notice_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return myBoard;
	}
	
	public MyBoard update(MyBoard myBoard){
		int re = -1; 
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MyBoardMapper.class).update(myBoard);
			
			if(re > 0) { 
				sqlSession.commit(); 
				System.out.println("커밋 성공");
			}
			else { 
				sqlSession.rollback(); 
				System.out.println("커밋 실패");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return myBoard;
	}
	
	public MyBoard delete(int notice_no){
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MyBoard myBoard = null;
		try {
			myBoard = sqlSession.getMapper(MyBoardMapper.class).delete(notice_no);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return myBoard;
	}
	
	

}
