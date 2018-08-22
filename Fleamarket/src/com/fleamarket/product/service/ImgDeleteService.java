package com.fleamarket.product.service;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fleamarket.bean.Action;
import com.fleamarket.bean.ActionForward;
import com.fleamarket.product.model.ItemImg;
import com.fleamarket.product.model.ProductDAO;

public class ImgDeleteService implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
//		imgdelete.do?big_Img="+big_Img+"&thum_Img"+thum_Img
		
		ProductDAO dao = ProductDAO.getInstance();
		
		ItemImg itemimg = new ItemImg();
		itemimg.setThum_Img(request.getParameter("thum_Img"));
		itemimg.setBig_Img(request.getParameter("big_Img"));
		
		int a = dao.deleteImg(itemimg);
		System.out.println("asdfsadfasdfasdfa::::::::::::::"+a);
		if(a>0){
			String realPath = request.getRealPath("/productimg");
			File img = new File(realPath+"/"+itemimg.getBig_Img());
			File thImg = new File(realPath+"/"+itemimg.getThum_Img());
			img.delete();
			thImg.delete();
		}
		
		return null;
	}

}
