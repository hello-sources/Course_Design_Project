package com.web.ltw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		//����index.jsp�г����Ӻ�Ĳ���
		String id=request.getParameter("id");
		System.out.println("id="+id);
		
		ModelAndView  mav=new ModelAndView();
		mav.addObject("msg","���磬����:"+id);//���������������
		//request.getSession().setAttribute("msg","���磬����:"+id );
		mav.setViewName("ok.jsp");//ҳ����ת���ĸ�·��
		return mav;
	}

}
