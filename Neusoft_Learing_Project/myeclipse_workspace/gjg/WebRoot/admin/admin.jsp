<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%--  利用jsp三大指令之一 taglib导入jstl --%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head> 
    <title>管理员的首页</title> 
    <style>
      li{float:left;margin-right:10px;}
      ul{list-style-type:none}
    </style>
  </head> <body>  
  
  <ul><%-- pageContext是九大jsp隐式对象之一为当前页面级的对象，
      request就九大jsp隐式对象之一的服务器的请求对象，当服务器内部进行
      转发(dispatcher),数据可以在下一页显示，如果是用response.sendRedirect进行
      重定向跳转，地栏发生变化，此时数据一定要通过服务器的作用域的session
      放大作用域才能下一页或多页中得到数据，contextPath上下文路径   --%>
    <li><a href="${pageContext.request.contextPath}/userPagination">分页查询用户</a></li>
    <li><a href="${pageContext.request.contextPath}/user/register.jsp">注册用户</a></li>
    <li><a href="#">其它</a></li>
  </ul>
  
  <hr style="clear:left"/>
  <c:if test="${empty users}">
     <center>
     <h1>无数据</h1>
     </center>
  </c:if>  
  <c:if test="${not empty users}">
  <table align="center" border="1" width="100%">
       <tr> <th>用户名</th> <th>真实姓名</th> <th>电话</th>
         <th>注册日期</th> <th>备注</th><th>辅助功能</th>
       </tr>
        <c:forEach items="${users}" var="user">
         <tr>
          <td>${user.name }</td>
          <td>${user.realname }</td>
          <td>${user.phone }</td>
          <td>${user.regdt }</td>
          <td>${user.mark }</td>
          <td>
             <a href="${pageContext.request.contextPath}/remove?id=${user.id }" 
             onclick="return confirm('您确定删除吗,谢谢！')">删除当前行</a>
         
          <a href="${pageContext.request.contextPath}/userQueryById?id=${user.id }">修改前的查询</a>
          </td>
         </tr>      
        </c:forEach>       
     </table>  
     <hr color="red" size="5px"/>
     <center>
        第${pageIndex }页/共${totalPages}页
        <c:if test="${pageIndex>1 }">
        <a href="${pageContext.request.contextPath}/userPagination?pageIndex=1">首页</a>
        <a href="${pageContext.request.contextPath}/userPagination?pageIndex=${pageIndex-1 }">上一页</a>
        </c:if>
        <c:if test="${pageIndex<totalPages }">
        <a href="${pageContext.request.contextPath}/userPagination?pageIndex=${pageIndex+1 }">下一页</a>
        <a href="${pageContext.request.contextPath}/userPagination?pageIndex=${totalPages}">末页</a>
        </c:if>
     </center>
     </c:if>
  </body>
</html>
