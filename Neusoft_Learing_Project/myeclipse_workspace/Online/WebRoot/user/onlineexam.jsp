<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>选择科目界面</title>
<style type="text/css">
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: white;
}
.STYLE2 {
	font-family: "Microsoft YaHei UI";
	font-size: 18px;
}
.STYLE3 {
	font-family: "Microsoft YaHei UI";
	color: #FF0000;
}
</style>
</head>
  <body style="background:url(./images/a.jpg)">      
       <center >  
       <span class="STYLE1">选择你要答题的科目</span>  
        <form action="question.action" method="post" font-size:70px>   <!-- 提取sub.id -->
            <select name="sid">    
              <c:forEach items="${subjects}" var="sub">    
              <option value="${sub.id }">${sub.name}</option>    
              </c:forEach>  
            </select>  
           <input type="submit" value="开始答题">   
        </form>  
       </center>   
  </body>
</html>
