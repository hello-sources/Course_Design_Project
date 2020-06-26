<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML>
<html>
	<head>

		<title>错误页</title>
		<script type="text/javascript">
		function eorror(){
			alert('出错');
		}
		</script>
		


	</head>

	<body>
	<div align="center">
		<li>
			<a href="${pageContext.request.contextPath}/admin/admin.jsp">返回管理员首页</a>
		</li>
	</div>
		
		<br />
		<h1 align="center">
			出现错误
		</h1>
		
	</body>
</html>
