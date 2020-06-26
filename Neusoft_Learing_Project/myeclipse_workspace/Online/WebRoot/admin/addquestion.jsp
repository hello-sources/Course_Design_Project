<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.zcg.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>加题页</title>
		<style type="text/css">
		.bground{background-color:e0f2fe ;}
		.font1{font-size="20px"}
		</style>
	</head>
	<body  bgcolor="e0f2fe">
		<li>
		<a href="${pageContext.request.contextPath}/admin/admin.jsp">返回管理员首页</a>
		</li>
		<br>
		<h1 align="center">加题页</h1>
		
		<br>
		<br>	
		<form action="${pageContext.request.contextPath}/addQuestion.action" method="post">
  	<table align="center" border="2" width="30%">
  		<tr>
  			<th >题目内容</th><td colspan=4><input type="text" placeholder="题目内容" name = "q_title" 
  			id="question" 
  			class = "solid"
  			style="height:50px;width:600px;"/></td>
  		</tr>
  		<tr><th>题目难度</th>		<td><input type="radio" name="q_level" value="1"/>简单</td>
						  		<td><input type="radio" name="q_level" value="2"/>一般</td>
						  		<td><input type="radio" name="q_level" value="3"/>困难</td></tr>
  		<tr><th>题目选项：</th>	<td>A:<input type="text" placeholder="A" name ="q_options"/></td>
  								<td>B:<input type="text" placeholder="B" name ="q_options"/></td>
  								<td>C:<input type="text" placeholder="C" name ="q_options"/></td>
  								<td>D:<input type="text" placeholder="D" name ="q_options"/></td></tr>
  		<tr><th>题目答案</th>		<td><input type="radio" name="q_answer" value="A"/>A</td>
						  		<td><input type="radio" name="q_answer" value="B"/>B</td>
						  		<td><input type="radio" name="q_answer" value="C"/>C</td>
						 		<td><input type="radio" name="q_answer" value="D"/>D</td></tr>
  		<tr><th>题目分数</th><td><input type="text" name="q_score"></td></tr>
  		
  		<tr align="center">
  			<td colspan=5>
  			<input type="submit" name="role" value="加题"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="reset" name="role" value="取消"/></td>
  		</tr>
  	</table>
  	</form>
		
		
	</body>
</html>
