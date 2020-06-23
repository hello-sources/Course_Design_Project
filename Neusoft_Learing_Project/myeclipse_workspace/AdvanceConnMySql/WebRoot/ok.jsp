<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆成功后的界面</title>
		
  </head>
  
  <body >
  <%--这是jsp的动态注释,查询源码不显示${}EL==表达式语言 --%>
  <h1>欢迎您${username }</h1>
  <h1>欢迎您<%=session.getAttribute("username") %></h1>
  </body>
</html>
