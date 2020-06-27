package com.web.ltw.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.web.ltw.service.impl.SubjectServiceImpl;

public class SubjectServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public SubjectServlet() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		SubjectServiceImpl ssi=ac.getBean(SubjectServiceImpl.class);
		request.getSession().setAttribute("subjects", ssi.querySubjects());
		response.sendRedirect("user/user.jsp");
		out.flush();
		out.close();
	}
    ApplicationContext ac=null;
	public void init() throws ServletException {
		//当前类的静态方法getWebApplicationContext里的参数
		//直接通过web.xml的监听器找到spring配置文件
		ac=WebApplicationContextUtils.
		getWebApplicationContext(this.getServletContext());
	}

}
