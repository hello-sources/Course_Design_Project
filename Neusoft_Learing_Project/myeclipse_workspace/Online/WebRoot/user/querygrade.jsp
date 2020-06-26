<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@page import="com.web.gjg.bean.*"%>
<%--利用jsp三大指令之一taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%-- c代表前缀 --%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>成绩查询</title>
		<%--
		<style type="text/css">
li {
	float: left;
	margin-right: 10px;
}
</style>
--%>
<style type="text/css">
table.altrowstable {
font-family: verdana,arial,sans-serif;
font-size:11px;
color:#333333;
border-width: 3px;
border-color: #a9c6c9;
border-collapse: collapse;
}
table.altrowstable th {
border-width: 3px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
table.altrowstable td {
border-width: 3px;
padding: 8px;
border-style: solid;
border-color: #a9c6c9;
}
.oddrowcolor{
background-color:#d4e3e5;
}
.evenrowcolor{
background-color:#c3dde0;
}
</style>
<script type="text/javascript">
function altRows(id){
if(document.getElementsByTagName){  

var table = document.getElementById(id);  
var rows = table.getElementsByTagName("tr"); 
 
for(i = 0; i < rows.length; i++){          
if(i % 2 == 0){
rows[i].className = "evenrowcolor";
}else{
rows[i].className = "oddrowcolor";
}      
}
}
}


window.οnlοad=function(){
altRows('alternatecolor');
}
</script>

	</head>
<body style="background: url(./images/timg3.jpg) ;background-position:50% 50%; background-repeat:no-repeat">
	<h1 align="center" >
		查询成绩
	</h1>
			<table align="center" border="1">
				<tr>
					<th>用户id</th>
					<th>用户名</th>
					<th>真实姓名</th>							
				</tr>
				<c:forEach items="${queryinfobyid}" var="user">
					<tr>
						<td>${user.id }</td>
						<td>${user.name }</td>
						<td>${user.realname }</td>
					</tr>
				</c:forEach>
		</table>		
		<table align="center"  class="altrowstable" id="alternatecolor" border = "1">
		<tr>
			<th>C语言成绩</th>
			<c:forEach items="${querycgradebyid}" var="user">					
				<td>${user.cgrade }</td>						
			</c:forEach>
		</tr>
		<tr>
			<th>C++成绩</th>
			<c:forEach items="${querycppgradebyid}" var="user">					
				<th>${user.cppgrade }</th>					
			</c:forEach>
		</tr>
		<tr>
		<th>Java成绩</th>
		<c:forEach items="${queryjavagradebyid}" var="user">				
				<th>${user.javagrade }</th>						
			</c:forEach>
		</tr>
		<tr>
		<th>.Net成绩</th>
		<c:forEach items="${querynetgradebyid}" var="user">					
				<th>${user.netgrade }</th>						
			</c:forEach>
		</tr>									
			<tr>																		
				<th>Python成绩</th>
			<c:forEach items="${querypythongradebyid}" var="user">				
				<th>${user.pythongrade }</th>						
			</c:forEach>
			</tr>		
		</table>
	</body>
</html>
