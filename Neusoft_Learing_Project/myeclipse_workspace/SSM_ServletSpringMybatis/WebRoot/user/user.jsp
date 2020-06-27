<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE HTML>
<html>
  <head> 
    <title>选择科目界面</title>
  </head>  
  <body style="background-image:url('../images/bg1.jpg')">
      
       <center>
        <form action="">
            <select name="subject">
              <c:forEach items="${subjects}" var="sub">
              <option value="${sub.id }">${sub.name}</option>
              </c:forEach>
            </select>        
        </form>
       </center>
  
  
  </body>
</html>
