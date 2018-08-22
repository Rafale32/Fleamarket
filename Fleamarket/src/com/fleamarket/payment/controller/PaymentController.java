package com.fleamarket.payment.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.bean.Bean;
import com.fleamarket.payment.service.DetailOrderAction_jh;
import com.fleamarket.payment.service.InsertPaymentAction_jh;
import com.fleamarket.payment.service.PaymentAction;

//경로관련된 문자는 모두 무조건 소문자로  /맡은페이지경로/원하는작업.do  식으로 처리하기
@WebServlet("/payment/*")
public class PaymentController extends HttpServlet {
  private static final long serialVersionUID = 1L;

  public PaymentController() {
    super();
  }

  public void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    String requestURI = request.getRequestURI();
    String contextPath = request.getContextPath();
    // System.out.println(contextPath);
    contextPath += "payment/";
    String command = requestURI.substring(contextPath.length() + 1);
    // System.out.println(command);

    Action action = null;
    ActionForward forward = null;

    if (request.getAttribute("bean") == null) {
      Bean bean = new Bean(request);
      request.setAttribute("bean", bean);
    }

    // payment.do => 결제페이지, 필요한 정보 가져오기
    if (command.equals("payment.do")) {
      action = new PaymentAction();
      try {
        forward = action.execute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
      
      // 결제페이지 값들 입력
    } else if (command.equals("insertpayment.do")) {
      action = new InsertPaymentAction_jh();
      try {
        forward = action.execute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    
       // detailPayment.do => 주문상세내역페이지로 이동
    } else if (command.equals("detailpayment.do")) {
      action = new DetailOrderAction_jh();
      try {
        forward = action.execute(request, response);
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
    
    


  

    if (forward != null) {
      if (forward.isRedirect()) {
        response.sendRedirect(forward.getPath());
      } else {

        RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
        dispatcher.forward(request, response);

      }
    }

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doProcess(request, response);
  }
}
