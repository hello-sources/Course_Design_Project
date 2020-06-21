<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.online.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>成绩查询</title>
		<style type="text/css">
li {
	float: left;
	margin-right: 10px;
}
</style>
	</head>
<body style="background: url(./images/timg3.jpg) ;background-position:50% 50%; background-repeat:no-repeat">
	<h1 align="center" >
		查询成绩
	</h1>
			<table align="center" border="1">
				<tr>
					<th>用户id</th>
					<th>用户名</th>
					<th>真实姓名</th>							
				</tr>
				<c:forEach items="${queryinfobyid}" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.name }</td>
						<td>${user.realname }</td>
					</tr>
				</c:forEach>
		</table>		
		<table align="center">
			<th>C语言成绩</th>
			<c:forEach items="${querycgradebyid}" var="user">					
				<th>${user.cgrade }</th>						
			</c:forEach>		
		</table>
		<table align="center" >
			<th>C++成绩</th>
			<c:forEach items="${querycppgradebyid}" var="user">					
				<th>${user.cppgrade }</th>					
			</c:forEach>	
		</table>
		<table align="center" >
			<th>Java成绩</th>
			<c:forEach items="${queryjavagradebyid}" var="user">				
				<th>${user.javagrade }</th>						
			</c:forEach>
		</table>
		<table align="center" >
			<th>.Net成绩</th>
			<c:forEach items="${querynetgradebyid}" var="user">					
				<th>${user.netgrade }</th>						
			</c:forEach>	
		</table>
		<table align="center" >
			<th>Python成绩</th>
			<c:forEach items="${querypythongradebyid}" var="user">				
				<th>${user.pythongrade }</th>						
			</c:forEach>		
		</table>
	</body>
</html>
