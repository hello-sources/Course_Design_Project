package com.web.ltw.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloWorldController implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception { 
		//接收index.jsp中超链接后的参数
		String id=request.getParameter("id");
		System.out.println("id="+id);
		
		ModelAndView  mav=new ModelAndView();
		mav.addObject("msg","世界，您好:"+id);//向服务器发送数据
		//request.getSession().setAttribute("msg","世界，您好:"+id );
		mav.setViewName("ok.jsp");//页面跳转到哪个路径
		return mav;
	}

}
