package com.fleamarket.payment.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.payment.model.DeliveryDTO_gy;
import com.fleamarket.payment.model.PaymentPagingDTO_gy;
import com.fleamarket.payment.model.PuerchaseDAO_gy;

public class changeDeliveryPuerchaseAction_gy implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String pageNum = request.getParameter("pageNo"); // 페이지 넘버 
		if (pageNum == null) {
			pageNum = "1";
		} else if (pageNum == "0") {
			pageNum = "1";
		}
		System.out.println("제대로 왔습니다.");
		String item_no1 = request.getParameter("item_no"); // 해당 아이템 넘버
		int item_no = Integer.parseInt(item_no1);

		DeliveryDTO_gy drv = new DeliveryDTO_gy();
		System.out.println(item_no + " : 아이템 no");
		// 확정된 아이템 넘버를 이용해서 사용합니다.
		drv.setItem_no(item_no);
	
		// 구매 DAO에 배달 변경 메소드를 넣었으니 거기껄 씁시다
		PuerchaseDAO_gy dao3 = PuerchaseDAO_gy.getInstance();

		System.out.println("제대로 왔습니다.2222");
		dao3.changeDelivery(drv);
		System.out.println("메소드 가즈아~!");

		// 어디로 갈지 정하는것
		ActionForward forward = new ActionForward();
		forward.setPath("PaymentPagingAction_gy.gy?pageNum=" + pageNum);
		forward.setRedirect(false);

		return forward;

	}

}
