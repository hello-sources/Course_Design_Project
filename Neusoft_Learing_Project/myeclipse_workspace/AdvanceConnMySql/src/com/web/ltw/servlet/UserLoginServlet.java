package com.web.ltw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.ltw.bean.User;
import com.web.ltw.service.UserService;
import com.web.ltw.service.impl.UserServiceImpl;

public class UserLoginServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserLoginServlet() {
		System.out.println("默认构造");
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		System.out.println("当服务器关闭时这是销毁当前类的一个方法");
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");//接受jsp中文
		PrintWriter out = response.getWriter();
		/*
		 * 这里是当html或者jsp等网页以超链接或者表单的方式提交时一定执行到此
		 */
		//调用后台dao,bean ....
		UserService us = new UserServiceImpl();
		//接受前台的html或者isp参数
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String r = request.getParameter("role");
		System.out.println("用户名:"+name);
		System.out.println("密码 :"+pwd);
		System.out.println("角色"+r);
		User user = new User();
		user.setName(name);user.setPwd(pwd);user.setRole(Integer.parseInt(r));
		if(us.login(user)){
			//向服务器发送一个数据:username
			request.getSession().setAttribute("username", name);
			//跳转页面
			out.print("<script>alert('登陆成功')</script>");
			out.print("<script>location.href ='ok.jsp'</script>");
		}else{
			out.print("<script>alert('登陆失败')</script>");
			out.print("<script>location.href ='index.jsp'</script>");
		}
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);//一定到doGet上边的方法
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
