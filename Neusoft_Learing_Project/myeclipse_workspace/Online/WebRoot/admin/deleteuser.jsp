<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.zcg.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>管理员的首页</title>
		<style type="text/css">
li {
	float: left;
	margin-right: 10px;
}
</style>
	</head>
	<body>

		<%-- 无序列表菜单 --%>
		<li>
		<a href="${pageContext.request.contextPath}/admin/admin.jsp">返回管理员首页</a>
		</li>
		<form action="${pageContext.request.contextPath}/deleteUser.action" method="post">
		<table align="center" border="1">
				<tr>
					<th>用户id</th>
					<td><input type="text" name="id" placeholder="可以都填，不过要准确才能成功删除"/></td>
				</tr>
				<tr align="center">
  			<td colspan=5>
  			<input type="submit" name="role" value="删除"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
  			<input type="reset" name="role" value="取消"/></td>
  		</tr>
		</table>
		</form>
	</body>
</html>
