<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML>
<html>
  <head> 
    <title>注册页</title> 
  </head> 
  <body>
     <form action="${pageContext.request.contextPath}/register.action" method="post">
       <input type="hidden" name="role" value="1">
       <table bgcolor="pink" align="center" border="0" width="30%">
          <caption>用户注册</caption>
          <tr>
            <th>用户:</th><td><input type="text"
            class="solid"
             placeholder="请输入用户名"
             name="name" id="name" /></td>
          </tr>
          <tr>
            <th>密码:</th><td><input type="password" class="solid" placeholder="请输入密码"
             name="pwd" id="pwd" /></td>
          </tr>
          <tr>
            <th>重复密码:</th><td>
            <input type="password" class="solid" id="pwd2" /></td>
          </tr>
          <tr>
            <th>真实姓名:</th><td>
            <input  name="realname" /></td>
          </tr>
          <tr>
            <th>手机号码:</th><td>
            <input  name="phone" /></td>
          </tr>
          <tr>
            <th>备注:</th><td>
            <input  name="mark" /></td>
          </tr>
           <tr align="center"> 
             <td colspan="2"> 
            <input type="submit"  value="注册"/>
            <input type="reset"  value="取消"/></td>
          </tr>
       </table>     
     </form>
  </body>
</html>
