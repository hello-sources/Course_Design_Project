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

public class UserRegisterServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserRegisterServlet() {
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

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String name=request.getParameter("name");
		//将原来的乱码《jsp默认编码为iso-8859-1),通过字符码以字符串的形式转换为需要的
		String pwd=request.getParameter("pwd");
		String realname=request.getParameter("realname");
		realname = new String(realname.getBytes("iso-8859-1"),"utf-8");
		String phone=request.getParameter("phone");
		String mark=request.getParameter("mark"); 
		mark = new String(mark.getBytes("iso-8859-1"),"utf-8");
		User user=new User();
		user.setName(name);
		user.setPwd(pwd);
		user.setRealname(realname);
		user.setPhone(phone);
		user.setMark(mark);
		UserService us=new UserServiceImpl();
		us.register(user);
		response.sendRedirect("login.jsp");
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
