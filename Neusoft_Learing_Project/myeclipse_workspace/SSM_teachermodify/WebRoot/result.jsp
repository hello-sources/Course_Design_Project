<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head> 
    <title>成绩单</title> 
  </head> 
  <body>
      <h1>共${nums}题,每题2分，百分制结果是：${result*10 }分</h1>
       <c:if test="${result*10 lt 60 }">         
         <h1 style="background:red;width:${result*10*10 }px">
         <img src="images/bjg.jpg" width="350px"/>
         </h1>
      </c:if>
      <c:if test="${result*10 eq 60 }">        
         <h1 style="background:blue;width:${result*10*10 }px"> 合格,勉强</h1>
      </c:if>
       <c:if test="${result*10 eq 80 }">         
         <h1 style="background:yellow;width:${result*10*10 }px">良好</h1>
      </c:if>
      <c:if test="${result*10 eq 100 }">         
         <h1 style="background:green;width:${result*10*10 }px">
           <img src="images/yx.gif" width="150px"/>
         </h1>
      </c:if>
  </body>
</html>
