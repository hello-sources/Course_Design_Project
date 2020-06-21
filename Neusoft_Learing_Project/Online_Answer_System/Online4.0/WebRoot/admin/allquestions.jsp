<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>


		<title>题库页</title>
		<style type="text/css">
			li {
				float: left;
				margin-right: 10px;
			}
		</style>

	</head>

	<body>
		<li>
		<a href="${pageContext.request.contextPath}/admin/admin.jsp">返回管理员首页</a>
		</li>
		<br/>
		<h1 align="center">
			题库
		</h1>
		
		<table align="center" border="1">
			<tr>
				<th>
					题目id
				</th>
				<th>
					内容
				</th>
				<th>
					级别
				</th>
				<th>
					答案
				</th>
				<th>
					选项
				</th>
				<th>
					得分
				</th>
			</tr>
			<c:forEach items="${allquestions}" var="q">
				<tr>
					<td>
						${q.q_id }
					</td>
					<td>
						${q.q_title }
					</td>
					<td>
						${q.q_level }
					</td>
					<td>
						${q.q_answer }
					</td>
					<td>
						${q.q_options }
					</td>
					<td>
						${q.q_score }
					</td>
				</tr>

			</c:forEach>
		</table>
	</body>
</html>
