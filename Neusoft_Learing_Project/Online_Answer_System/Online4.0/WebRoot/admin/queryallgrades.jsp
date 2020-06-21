<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.zcg.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>成绩总览</title>
		<style type="text/css">
li {
	float: left;
	margin-right: 10px;
}
</style>
<script type="text/javascript">
	var subject="";
	function recordSubject(i){
		subject = i;
	}
	function getSubject(){
		return subject;
	}


</script>
	</head>
	<body>
	<li>
			<a href="${pageContext.request.contextPath}/admin/admin.jsp">返回管理员首页</a>
		</li>
		<br/>
		<h1 align="center">
			查询所有成绩
		</h1>
		

		<%-- 无序列表菜单 --%>
		<ul></ul>
		<br/>
		<form
			action="${pageContext.request.contextPath}/queryAllGrades.action"
			method="post">
			<table align="center" border="1">
				<th>
					选择科目
					<td>
						<input type="radio" name="subject" value="cgrade" />
						C
					</td>
					<td>
						<input type="radio" name="subject" value="cppgrade" />
						C++
					</td>
					<td>
						<input type="radio" name="subject" value="pyhtongrade" />
						Python
					</td>
					<td>
						<input type="radio" name="subject" value="netgrade" />
						.Net
					</td>
					<td>
						<input type="radio" name="subject" value="javagrade" />
						Java
					</td>
				</th>
				<tr align="center">
					<td colspan=6>
						<input type="submit" name="role" value="确定" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" name="role" value="取消" />
					</td>
				</tr>
			</table>
		</form>
		<br/>
		<br/>
		<br/>
		<br/>
		<table align="center" border="1">
			<tr>
				<th>
					用户id
				</th>
				<th>
					用户名
				</th>
				<th>
					真实姓名
				</th>
				<th>
					成绩
				</th>
			</tr>
			<c:forEach items="${queryallgrades}" var="user">
				<tr>
					<td>
						${user.id }
					</td>
					<td>
						${user.name }
					</td>
					<td>
						${user.realname }
					</td>
					<td>
						${user.grade }
					</td>
				</tr>

			</c:forEach>
		</table>
	</body>
</html>
