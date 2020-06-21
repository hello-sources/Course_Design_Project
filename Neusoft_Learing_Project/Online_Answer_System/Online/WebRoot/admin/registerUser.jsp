<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML>
<html>
  <head> 
    <title>注册页</title> 
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
     <form action="${pageContext.request.contextPath}/register.action" method="post">
       <input type="hidden" name="role" value="1">
       <table bgcolor="pink" align="center" border="0" width="30%">
          <caption>用户注册</caption>
          <tr>
            <th>用户:</th><td><input type="text"
            class="solid"
             placeholder="请输入用户名"
             name="name" id="name" /></td>
          </tr>
          <tr>
            <th>密码:</th><td><input type="password" class="solid" placeholder="请输入密码"
             name="pwd" id="pwd" /></td>
          </tr>
          
          <tr>
            <th>真实姓名:</th><td>
            <input  name="realname" /></td>
          </tr>
          <tr>
            <th>手机号码:</th><td>
            <input  name="phone" /></td>
          </tr>
          <tr>
            <th>备注:</th><td>
            <input  name="mark" /></td>
          </tr>
           <tr align="center"> 
             <td colspan="2"> 
            <input type="submit"  value="注册"/>
            <input type="reset"  value="取消"/></td>
          </tr>
       </table>     
     </form>
  </body>
</html>
