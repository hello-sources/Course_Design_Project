<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>


		<title>题库页</title>
	<style type="text/css">
* {
	margin: 0;
	padding: 0
}

#left {
	float: left;
	width: 50px;
	height: 80%;
	background: url("../images/bg.jpg");
}

#main {
	background-color: white;
	height: 100%;
}

/*为了使菜单居中*/
body { /* padding-top:100px;*/
	text-align: center;
}

/* -------------菜单css代码----------begin---------- */
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

table {
	margin: auto;
	background-color: #ffffff;
	border: solid 1px #f1f1f1;
}

thead {
	background-color: #f5f6fa;
	border: solid 1px #f1f1f1;
}

th {
	font-family: "CircularStd", sans-serif;
	font-size: 16px;
	font-weight: 600;
	line-height: 2.14;
	color: #121f3e;
	text-align: center;
}

td,.table>tbody>tr>td {
	color: #838ca1;
	font-family: "CircularStd-Book", sans-serif;
	font-size: 14px;
	border-top: solid 1px #f1f1f1;
	padding: 11px;
	text-align: center;
}
</style>

	</head>

	<body>
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
		<h1 align="center">
			题库
		</h1>
		
		<table align="center" border="1">
			<tr>
				<th width="99">
					题目id
				</th>
				<th width="99">
					内容
				</th>
				<th width="99">
					级别
				</th>
				<th width="99">
					答案
				</th>
				<th width="99">
					选项A
				</th>
				<th width="99">
					选项B
				</th>
				<th width="99">
					选项C
				</th>
				<th width="99">
					选项D
				</th>
				<th width="99">
					得分
				</th width="99">
			</tr>
			<c:forEach items="${allquestions}" var="q">
				<tr>
					<td>
						${q.qid }
					</td>
					<td>
						${q.title }
					</td>
					<td>
						${q.level }
					</td>
					<td>
						${q.answer }
					</td>
					<td>
						${q.optionA }
					</td>
					<td>
						${q.optionB }
					</td>
					<td>
						${q.optionC }
					</td>
					<td>
						${q.optionD }
					</td>
					<td>
						${q.score }
					</td>
				</tr>

			</c:forEach>
		</table>
	</body>
</html>
