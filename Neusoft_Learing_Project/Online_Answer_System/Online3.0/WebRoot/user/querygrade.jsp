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
	<h1 align="center">
		ID查询成绩
	</h1>
		<form
			action="${pageContext.request.contextPath}/queryInfoById.action"
			method="post">
			<table align="center" border="1">
				<tr>
					<th>
						用户id
					</th>
					<td>
						<input type="text" name="id" placeholder="输入正确id"
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
					
					
				</tr>
				<c:forEach items="${queryinfobyid}" var="user">
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
					</tr>

				</c:forEach>
		</table>
		
		<table>
			<th>
				C成绩
			</th>
			<c:forEach items="${querycgradebyid}" var="user">
					
				<td>
					${user.cgrade }
				</td>
						
			</c:forEach>
		
		</table>
		<table>
			<th>
				C++成绩
			</th>
			<c:forEach items="${querycppgradebyid}" var="user">
					
				<td>
					${user.cppgrade }
				</td>
						
			</c:forEach>
		
		</table>
		<table>
			<th>
				Java成绩
			</th>
			<c:forEach items="${queryjavagradebyid}" var="user">
					
				<td>
					${user.javagrade }
				</td>
						
			</c:forEach>
		</table>
		<table>
			<th>
				.Net成绩
			</th>
			<c:forEach items="${querynetgradebyid}" var="user">
					
				<td>
					${user.netgrade }
				</td>
						
			</c:forEach>
		
		</table>
		<table>
			<th>
				Python成绩
			</th>
			<c:forEach items="${querypythongradebyid}" var="user">
					
				<td>
					${user.pythongrade }
				</td>
						
			</c:forEach>
		
		</table>
		</form>
	</body>
</html>
