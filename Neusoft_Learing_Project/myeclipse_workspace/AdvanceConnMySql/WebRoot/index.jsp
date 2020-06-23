<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>这是首页</title>
		
  </head>
  
  <body >
  	<form action = "login"  method = "post">
  	<p>用户名:<input name = "username" value = "admin"/></p>
  	<p>密   码:<input name = "password" type = "password" value = "admin"/></p>
  	<p>角   色:<input type = "radio" name = "role" value = "0" checked = "checked"/>管理员
  	<input type = "radio" name = "role" value = "1"/>用户</p>
  	<p><input type = "submit" value = "登陆"/></p>
  	</form>
  </body>
</html>
