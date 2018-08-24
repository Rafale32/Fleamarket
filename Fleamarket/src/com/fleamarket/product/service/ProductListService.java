package com.fleamarket.product.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.fleamarket.bean.Bean;
import com.fleamarket.product.model.ItemDTO;
import com.fleamarket.product.model.PageModel;
import com.fleamarket.product.model.ProductDAO;

public class ProductListService {
	
	public static final int PAGE_SIZE = 4;//페이지당 2개씩 나중에 값늘어나면 5개씩
	
	private static ProductListService service = new ProductListService();
	private static ProductDAO dao;
	
	public static ProductListService getInstance(){
		
		dao = ProductDAO.getInstance();
		
		return service;
	}
	
	
	public List<ItemDTO> productListService(String email, String storeName, int requestPage , HttpServletRequest request){
		
		//로그인 상태 일때는 email 이 있고 로그인 아닐때는 상점 이름으로 찾아야하는대 클릭 했을때 파람으로 가지고 와야함 
		
/*		if(storeName != null){
			return dao.productListByStore(storeName);
		}else if(email != null){
			return dao.productList(email);
		}*/
		
		
		
/*		Search search = new Search();

		//검색시
		if(request.getParameterValues("area") != null){//area 가 null 이 아닐때 작동 즉 검색을 했을때만 작동
			
			session.removeAttribute("search");//세션 검색 할때마다 지워도 되지 
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%" +request.getParameter("searchKey") + "%");
			
			session.setAttribute("search", search);
		}else if((Search)session.getAttribute("search") != null){//검색한적이 있으면 세션에 search 객체가 있겠지
			
			//검색후 페이징을 클릭
			search = (Search)session.getAttribute("search");
			
		}*/
		
		

	    
	    PageModel pageModel ;
	    Bean bean = (Bean)request.getAttribute("bean");
		if(storeName != null){
			
			//상점이름 으로 검색한 전체 갯수
			int totalCount = dao.countItemBoardByStore(storeName);
			//총페이지수 구하기
			int totalPageCount = totalCount / PAGE_SIZE;
			
			//남은 나머지가 있으면 페이지가 하나 더 있어야하니까 
		    if (totalCount % PAGE_SIZE > 0) {
		        totalPageCount++;
		      }
		    
			//표시되는 시작 페이지 구하기      시작페이지 = 현재페이지  - (현재페이지 - 1 ) %5
			int startPage = requestPage -(requestPage - 1) % 5;
			
			//표시되는 끝 페이지
			int endPage = startPage + 4;
			System.out.println("startpage =   " + startPage +"endpage= "+endPage);
			
			//끝페이지가 넘치지 않게 해줘야지
		    if(endPage > totalPageCount) {
		        endPage = totalPageCount;
		      }
			
			//시작글 구하기 : (현재페이지 -1) * 페이지당 글 갯수
		    int startRow = (requestPage-1) * PAGE_SIZE;
		    
			List<ItemDTO> list = dao.productListByStore(storeName, startRow);
			pageModel = new PageModel( requestPage, totalPageCount, startPage, endPage);
			bean.setPageModel(pageModel);
			
			if(list != null){
				ItemDTO item = new ItemDTO();
				item.setStore_name(list.get(0).getStore_name());
				System.out.println(item.getStore_name());
				bean.setItemDTO(item);
			}
			
			return list;
		}else if(email != null){
			//이메일로 검색한 전체 갯수
			int totalCount = dao.countItemBoard(email);
			
			//총페이지수 구하기
			int totalPageCount = totalCount / PAGE_SIZE;
			
			//남은 나머지가 있으면 페이지가 하나 더 있어야하니까 
		    if (totalCount % PAGE_SIZE > 0) {
		        totalPageCount++;
		      }
		    
			//표시되는 시작 페이지 구하기      시작페이지 = 현재페이지  - (현재페이지 - 1 ) %5
			int startPage = requestPage -(requestPage - 1) % 5;
			
			//표시되는 끝 페이지
			int endPage = startPage + 4;
			System.out.println("startpage =   " + startPage +"endpage= "+endPage);
			
			//끝페이지가 넘치지 않게 해줘야지
		    if(endPage > totalPageCount) {
		        endPage = totalPageCount;
		      }
			
			//시작글 구하기 : (현재페이지 -1) * 페이지당 글 갯수
		    int startRow = (requestPage-1) * PAGE_SIZE;
			
			List<ItemDTO> list = dao.productList(email , startRow);
			pageModel = new PageModel( requestPage, totalPageCount, startPage, endPage);
			bean.setPageModel(pageModel);
			
			return list;
		}
	    
		return null;
	}
	
}
