package com.web.gjg.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.web.gjg.service.UserService;
import com.web.gjg.service.impl.UserServiceImpl;

public class RemoveUserServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RemoveUserServlet() {
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
		UserService us=new UserServiceImpl();
		//接受来自admin/admin.jsp中删除超链接后的参数id
		String id=request.getParameter("id");
		if(us.remove(Integer.parseInt(id)))
		{
			// 先跳到分页查询再通过分页查询的servlet跳到admin/admin.jsp
			response.sendRedirect("userPagination");
		}else{
			response.sendRedirect("admin/admin.jsp");
		}
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
