<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML >
<html>
  <head  
    <title>等待修改页</title>
  </head>
  <body>
  <form action="${pageContext.request.contextPath}/modify" method = "post">
  	<table  bgcolor = "skyblue" align = "center"   border = "0" width = "30%">
  		<tr>
  		<th>编号:</th><td>
  		<input name = "id" value = "${user.name }" readonly = "readonly"/></td>
  		</tr>
  		<tr>
  		<th>用户:</th><td><input type = "text" 
  		name = "realname" id = "id" value = "${user.name }" /></td>
  		</tr>
  		<tr>
            <th>密码:</th><td><input type="password" class="solid" placeholder="请输入密码"
             name="pwd" id="pwd" /></td>
          </tr>
  		<tr>
  		<th>重复密码:</th><td>
  		<input type = "password" class = "solid" id = "pwd2" /></td>
  		</tr>
  		<tr>
  		<th>真实姓名:</th><td><input name = "realname"  value = "${user.reslname }" /></td>
  		</tr>
  		<tr>
  		<th>手机号码:</th><td><input name = "phone"  value = "${user.phone }"/></td>
  		</tr>
  		<tr>
  		<th>备注:</th><td><input name = "mark"  value = "${user.mark }"/></td>
  		</tr>
  		<tr align = "center">
  		<td colspan = "2">
  		<input type = "submit"  value = "修改"/>
  		<input type = "reset"  value = "取消"/></td>
  		</tr>
  	</table>
  </form>
  </body>
</html>
