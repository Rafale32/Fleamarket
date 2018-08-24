package com.fleamarket.memManage.model;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.fleamarket.mapper.BoardMapper;
import com.fleamarket.mapper.MemManageMapper;

public class MemManageDAO {
	
	private static MemManageDAO dao = new MemManageDAO();
	
	public static MemManageDAO getInstance(){
		
		return dao;
		
	}//MemManageDAO
	
	public SqlSessionFactory getSqlSessionFactory(){
		String resource = "mybatis-config-memManage.xml";//dao와 mybatis-config를 불러오는 값
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource); 
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}//SqlSessionFactory getSqlSessionFactory()
	
	//로그인멤버
	public MemManageDTO loginMember(String email, String password){
	  SqlSession sqlSession = getSqlSessionFactory().openSession();
	  MemManageDTO member = null;
	  try {
	    member = sqlSession.getMapper(MemManageMapper.class).loginMember(email, password);
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      sqlSession.close();
    }
	  return member;
	}//loginMember
	
	//회원가입
	public int joinBoard(MemManageDTO dto){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MemManageMapper.class).joinMember(dto);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return re;
	}//joinBoard
	
	//스토어 생성
	public int joinStore(StoreDTO dto){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MemManageMapper.class).joinStore(dto);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return re;
	}
	//랜덤번호 생성
	public int randomStore(StoreDTO dto){
		int re = -1;
		System.out.println("렌덤 넘버 스토어 db업데이트");
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(MemManageMapper.class).randomStore(dto);
			if(re > 0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return re;
	}
	//중복된 번호 찾기
	public List<StoreDTO> listStore(){
		List<StoreDTO> list = new ArrayList<StoreDTO>();
		
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			list = sqlSession.getMapper(MemManageMapper.class).listStore();
			System.out.println(list.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
	
		return list;
	}
	//중복 아이디 체크
	public List<MemManageDTO> idCheck(){
		List<MemManageDTO> idCheck = new ArrayList<MemManageDTO>();
		
	SqlSession sqlSession = getSqlSessionFactory().openSession();
		
		try {
			idCheck = sqlSession.getMapper(MemManageMapper.class).idCheck();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return idCheck;
	}
	
	//회원 상세 보기
	public MemManageDTO detailMember(String email){ 
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		MemManageDTO dto = null;
		
		try {
			dto = sqlSession.getMapper(MemManageMapper.class).detailMember(email);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		return dto;
	}//detailMember
	
	//업데이트
	public int updateMember(MemManageDTO dto){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		try {
			re = sqlSession.getMapper(MemManageMapper.class).updateMember(dto);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
				}
			}catch (Exception e) {
				e.printStackTrace();	
			}finally {
				sqlSession.close();
			}	
		return re;
	}//updateMember
	
	//회원삭제
	public int deleteMember(String email){
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession();		
		try {
			re = sqlSession.getMapper(MemManageMapper.class).deleteMember(email);
			if(re>0){
				sqlSession.commit();
			}else{
				sqlSession.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}//deleteMember
}
