package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.payment.model.DeliveryDTO_gy;
import com.fleamarket.payment.model.PaymentPagingDTO_gy;
import com.fleamarket.payment.model.PuerchaseDAO_gy;

public class changeDeliverySellAction_gy implements Action{
// 구매 확정 같은거 누른뒤에 나오는 액션
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String pageNum = request.getParameter("pageNo");
		if (pageNum == null) {
			pageNum = "1";
		}else if(pageNum == "0") {
			pageNum = "1";
		}
		System.out.println(pageNum + "  페이지 no");
		
		int requestPage = Integer.parseInt(pageNum);
		PaymentPagingService_gy daoservice = PaymentPagingService_gy.getInstance();
		//로직처리 완료
		String item_no1 = request.getParameter("item_no");
		
		System.out.println(item_no1 + "  아이템 no");
		
		int item_no = Integer.parseInt(item_no1);

		DeliveryDTO_gy drv = new DeliveryDTO_gy();

		//확정된 아이템 넘버를 이용해서 사용합니다.
		drv.setItem_no(item_no);
		System.out.println(item_no + " : 액션안 아이템 no 22");
		System.out.println(" 액션안 제대로 왔습니다.");

		//구매 DAO에 배달 변경 메소드를 넣었으니 거기껄 씁시다
		PuerchaseDAO_gy dao3 = PuerchaseDAO_gy.getInstance();

		System.out.println("액션안 제대로 왔습니다.2222");
		dao3.changeDeliverySell(drv);
		System.out.println("메소드 가즈아~!");
		
		//데이터 처리
		ActionForward forward = new ActionForward();
		forward.setPath("PaymentPagingSellController_gy.gg?pageNum="+pageNum);
		forward.setRedirect(false);
		
		return forward;
	}
	

}
