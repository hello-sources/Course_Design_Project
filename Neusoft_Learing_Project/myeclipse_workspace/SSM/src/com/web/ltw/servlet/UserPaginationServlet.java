package com.web.ltw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.ltw.service.UserService;
import com.web.ltw.service.impl.UserServiceImpl;

public class UserPaginationServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserPaginationServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
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

		doPost(request,response);
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

		response.setContentType("text/html;charset = utf-8");
		PrintWriter out = response.getWriter();
		UserService us = new UserServiceImpl();
		String pi = request.getParameter("pageIndex");//获取分页超链接的参数
		//当第一次运行时参数不存在，一定出空，此时一定要判断
		if(pi ==null){
			pi = "1";//默认为首页
		}
		Integer pageIndex = Integer.parseInt(pi);
		Integer pageSize =2;
		//向服务器发送数据
		request.getSession().setAttribute("users", 
				us.pagination(pageIndex, pageSize));
		request.getSession().setAttribute("pageIndex",pageIndex); 
		request.getSession().setAttribute("totalPages",
				us.totalPages(pageSize)); 
		//重新跳回到主页查看分页结果
		response.sendRedirect("admin/admin.jsp");
		out.flush();
		out.close();
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
