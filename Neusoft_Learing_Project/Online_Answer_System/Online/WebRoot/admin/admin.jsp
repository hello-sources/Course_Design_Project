<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%--  利用jsp三大指令之一 taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<html>

	<head>
		<title>管理员的首页</title>
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
	width: 306px;
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
/* -------------菜单css代码----------end---------- */
<!--
style


.css--
>
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
		<c:if test="${not empty users}">
			<table align="center" border="1" width="100%">
				<tr>
					<th width="99">
						用户名
					</th>
					<th width="99">
						真实姓名
					</th>
					<th width="99">
						电话
					</th>
					<th width="303">
						注册日期
					</th>
					<th width="99">
						备注
					</th>

					<th width="303">
						辅助功能
					</th>
				</tr>
				<c:forEach items="${users}" var="user">
					<tr>
						<td>
							${user.name }
						</td>
						<td>
							${user.realname }
						</td>
						<td>
							${user.phone }
						</td>
						<td>
							${user.regdt }
						</td>
						<td>
							${user.mark }
						</td>
						<td>
							<a
								href="${pageContext.request.contextPath}/remove.action?id=${user.id }"
								onclick="return confirm('您确定删除吗,谢谢！')">删除当前行</a>

							<a
								href="${pageContext.request.contextPath}/queryUserById.action?id=${user.id }">修改前的查询</a>
						</td>
					</tr>
				</c:forEach>
			</table>
			<hr color="#6069f3" size="5px" />
			<center>
				第${pageIndex }页/共${totalPages}页
				<c:if test="${pageIndex>1 }">
					<a
						href="${pageContext.request.contextPath}/userPagination.action?pageIndex=1">首页</a>
					<a
						href="${pageContext.request.contextPath}/userPagination.action?pageIndex=${pageIndex-1 }">上一页</a>
				</c:if>
				<c:if test="${pageIndex<totalPages }">
					<a
						href="${pageContext.request.contextPath}/userPagination.action?pageIndex=${pageIndex+1 }">下一页</a>
					<a
						href="${pageContext.request.contextPath}/userPagination.action?pageIndex=${totalPages}">末页</a>

					<!--/.table-responsive-->

				</c:if>
			</center>
		</c:if>

	</body>
</html>
