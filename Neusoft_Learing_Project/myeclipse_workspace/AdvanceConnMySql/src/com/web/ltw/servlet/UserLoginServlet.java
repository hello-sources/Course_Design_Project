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
		System.out.println("Ĭ�Ϲ���");
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		System.out.println("���������ر�ʱ�������ٵ�ǰ���һ������");
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
		response.setCharacterEncoding("utf-8");//����jsp����
		PrintWriter out = response.getWriter();
		/*
		 * �����ǵ�html����jsp����ҳ�Գ����ӻ��߱��ķ�ʽ�ύʱһ��ִ�е���
		 */
		//���ú�̨dao,bean ....
		UserService us = new UserServiceImpl();
		//����ǰ̨��html����isp����
		
		String name = request.getParameter("username");
		String pwd = request.getParameter("password");
		String r = request.getParameter("role");
		System.out.println("�û���:"+name);
		System.out.println("���� :"+pwd);
		System.out.println("��ɫ"+r);
		User user = new User();
		user.setName(name);user.setPwd(pwd);user.setRole(Integer.parseInt(r));
		if(us.login(user)){
			//�����������һ������:username
			request.getSession().setAttribute("username", name);
			//��תҳ��
			out.print("<script>alert('��½�ɹ�')</script>");
			out.print("<script>location.href ='ok.jsp'</script>");
		}else{
			out.print("<script>alert('��½ʧ��')</script>");
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

		doGet(request,response);//һ����doGet�ϱߵķ���
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
