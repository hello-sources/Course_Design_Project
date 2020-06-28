<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML>
<html>
  <head> 
    <title>选择科目界面</title>
  </head>  
  <body>      
       <center>
        <form action="question.action" method="post">
            <select name="sid">
              <c:forEach items="${subjects}" var="sub">
              <option value="${sub.id }">${sub.name}</option>
              </c:forEach>
            </select> 
            <input type="submit" value="开始答题→">       
        </form>
       </center>  
  </body>
</html>
