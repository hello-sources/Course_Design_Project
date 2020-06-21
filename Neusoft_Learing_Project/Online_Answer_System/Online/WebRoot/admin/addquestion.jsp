<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.online.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>加题页</title>
		<style type="text/css">
		.bground{background-color:e0f2fe ;}
		.font1{font-size="20px"}
		.menuDiv {
	border: 2px solid #aac;
	overflow: hidden;
	width: 100%;
	display: inline-block;
}

/* 去掉a标签的下划线 */
.menuDiv a {
	text-decoration: none;
}

/* 设置ul和li的样式 */
.menuDiv ul,.menuDiv li {
	list-style: none;
	margin: 0;
	padding: 0;
	float: left;
}

/* 设置二级菜单绝对定位，并隐藏 */
.menuDiv>ul>li>ul {
	position: absolute;
	display: none;
}

/* 设置二级菜单的li的样式 */
.menuDiv>ul>li>ul>li {
	float: none;
}

/* 鼠标放在一级菜单上，显示二级菜单 */
.menuDiv>ul>li:hover ul {
	display: block;
}

/* 一级菜单 */
.menuDiv>ul>li>a {
	font-family: monospace, monospace;
	width: 303px;
	line-height: 40px;
	color: white;
	background-color: #3d68cf;
	text-align: center;
	border-left: 1px solid #bbf;
	display: block;
}

/* 在一级菜单中，第一个不设置左边框 */
.menuDiv>ul>li:first-child>a {
	border-left: none;
}

/* 在一级菜单中，鼠标放上去的样式 字的颜色*/
.menuDiv>ul>li>a:hover {
	color: #7867e7;
	background-color: #bcf;
}

/* 二级菜单 */
.menuDiv>ul>li>ul>li>a {
	width: 303px;
	line-height: 36px;
	color: #456;
	background-color: #eff;
	text-align: center;
	border: 1px solid #ccc;
	border-top: none;
	display: block;
}

/* 在二级菜单中，第一个设置顶边框 */
.menuDiv>ul>li>ul>li:first-child>a {
	border-top: 1px solid #ccc;
}

/* 在二级菜单中，鼠标放上去的样式 */
.menuDiv>ul>li>ul>li>a:hover {
	color: #a4f;
	background-color: #cdf;
}
		</style>
	</head>
	<body  bgcolor="e0f2fe">
		<div id="main">

			<!-- -------菜单html代码---------begin------- -->
			<div class="menuDiv">
				<ul>
					<li>
						<a title="点我进入注册管理员" href="#"
							onclick="document.getElementById('admin').style.display='block'">用户管理</a>
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/userPagination.action?pageIndex=1">分页查询用户</a>
							</li>
							
							<li>
								<a href="${pageContext.request.contextPath}/admin/registerUser.jsp">注册用户</a>
							</li>
							<li>
								<a
									href="${pageContext.request.contextPath}/admin/deleteuser.jsp">删除用户</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">成绩管理</a>
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/admin/querygradebyid.jsp">查询成绩</a>
							</li>
							<li>
								<a
									href="${pageContext.request.contextPath}/admin/insertgrade.jsp">增加成绩</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">题库管理</a>
						<ul>
							<li>
								<a
									href="${pageContext.request.contextPath}/admin/addquestion.jsp">添加题库</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/allQuestions.action">查询题库</a>
							</li>
							<li>
								<a
									href="${pageContext.request.contextPath}/admin/deletequestion.jsp">删除题目</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#">管理员管理</a>
							<ul>
							<li>
								<a href="${pageContext.request.contextPath}/admin/registerAdmin.jsp">注册管理员</a>
							</li>
							<li>
								<a href="${pageContext.request.contextPath}/admin/deleteuser.jsp">删除管理员</a>
							</li>
							
						</ul>
					</li>
					<li>
						<a href="${pageContext.request.contextPath}/zhuxiao.action">注销登入</a>
						
					</li>
				</ul>
			</div>

			<!-- -------菜单html代码---------end------- -->
		</div>
		<h1 align="center">加题页</h1>
		
		<br>
		<br>	
		<form action="${pageContext.request.contextPath}/addQuestion.action" method="post" >
  	<table align="center" border="2" width="30%">
  		<tr>
  			<th >题目内容</th><td colspan=4><input type="text" placeholder="题目内容" name = "title" 
  			id="question" 
  			class = "solid"
  			style="height:50px;width:600px;"/></td>
  		</tr>
  		<tr><th>题目难度</th>		<td><input type="radio" name="level" value="1"/>简单</td>
						  		<td><input type="radio" name="level" value="2"/>一般</td>
						  		<td><input type="radio" name="level" value="3"/>困难</td></tr>
  		<tr><th>题目选项：</th>	<td colspan=4>请按“A.***；B.***；C.***；D.***”格式添加选项,若无该选项，要写abcd和.以及中文分号</td></tr>
  		<tr><th>题目选项：</th>	<td colspan=4><input type="text" name="options" style="height:20px;width:600px;"></td></tr>
  		<tr><th>题目答案</th>		<td><input type="radio" name="answer" value="A"/>A</td>
						  		<td><input type="radio" name="answer" value="B"/>B</td>
						  		<td><input type="radio" name="answer" value="C"/>C</td>
						 		<td><input type="radio" name="answer" value="D"/>D</td></tr>
  		<tr><th>题目分数</th><td><input type="text" name="score"></td></tr>
  		
  		<tr align="center">
  			<td colspan=5>
  			<input type="submit" name="role" value="加题" />&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="reset" name="role" value="取消"/></td>
  		</tr>
  	</table>
  	</form>
		
		
	</body>
</html>
