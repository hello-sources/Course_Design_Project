<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE HTML>
<html>
  <head> 
    <title>登录页</title> 
    <script type="text/javascript">
        function $(id){return document.getElementById(id);}
        function check()
        {
           var username=$('name');
           var password=$('pwd');
           if(username.value=="")
           {
              alert('用户名不能为空，谢谢');
              username.focus();
              return false;
           }
           if(password.value=="")
           {
              alert('密码不能为空，谢谢');
              password.focus();
              return false;
           }
           return true;
        }
        function sh()
        { 
            var pwd=$('pwd');
            var pic=$('pic');
            if(pwd.type=="text")
            {
               pwd.type="password";
               pic.src="images/eye-off.jpg";
            }else{
               pwd.type="text";
               pic.src="images/eye-on.jpg";
            }
            
        }
    </script>    
    <style type="text/css">
        .solid{width:145px;height:25px;border:1px red solid}    
    </style> 
  </head> 
  <body>
     <form action="login.action" method="post" onsubmit="return check()">
       <table bgcolor="pink" align="center" border="0" width="30%">
          <tr>
            <th>用户:</th><td><input type="text"
            class="solid"
             placeholder="请输入用户名"
             name="name" id="name" value="admin"/>
             <a href="${pageContext.request.contextPath}/registerUser.jsp">注册</a>
             </td>
          </tr>
          <tr>
            <th>密码:</th><td><input type="password" class="solid" placeholder="请输入密码"
             name="pwd" id="pwd" value="admin"/>
             <img id="pic" style="border:5px blue double;vertical-align:middle" 
             title="显示或隐藏密码" onclick="sh()" src="images/eye-off.jpg"/>
          </td>
          </tr>
             <tr align="center"> 
             <td colspan="2">
            角色:
            <input type="radio" name="role" value="0"/>管理员
            <input type="radio" name="role" value="1" checked="checked"/>用户</td>
          </tr>
           <tr align="center"> 
             <td colspan="2"> 
            <input type="submit"  value="登录"/>
            <input type="reset"  value="取消"/></td>
          </tr>
       </table>     
     </form>
  </body>
</html>
