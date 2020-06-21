<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.zcg.bean.*"%>
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
	
	
	<body>
	<br/>
	<h1 align="center">
		查询成绩
	</h1>
		<form
			action="${pageContext.request.contextPath}/queryGrade.action"
			method="post">
			<table align="center" border="1">
				<tr>
					<th>
						用户id
					</th>
					<td>
						<input type="text" name="id" placeholder="输入自己的id"
							style="height: 20px; width: 300px;" />
					</td>
				</tr>
				<tr align="center">
					<td colspan=5>
						<input type="submit" name="role" value="查询" />
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
						<input type="reset" name="role" value="取消" />
					</td>
				</tr>
			</table>
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
						C成绩
					</th>
					<th>
						C++成绩
					</th>
					<th>
						Python成绩
					</th>
					<th>
						.Net成绩
					</th>
					<th>
						Java成绩
					</th>
					
				</tr>
				<c:forEach items="${querygrade}" var="user">
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
							${user.cppgrade }
						</td>
						<td>
							${user.cgrade }
						</td>
						<td>
							${user.pythongrade }
						</td>
						<td>
							${user.netgrade }
						</td>
						<td>
							${user.javagrade }
						</td>
					</tr>

				</c:forEach>
		</table>
		</form>
	</body>
</html>
