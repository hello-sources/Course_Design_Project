<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="zh"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>哈尔滨工程大学在线答题系统</title>
<script type="text/javascript" src="./jquery-1.9.1.min.js.下载"></script>
<script type="text/javascript" src="./jquery.cookie.js.下载"></script>
<script>$.cookie.json=true;</script>
<link rel="icon" href="./ubuntu.ico" type="image/x-icon">
<link href="./style.css" rel="stylesheet" type="text/css" media="screen">
<script type="text/javascript">
        function $(id){return document.getElementById(id);}//用美元符号获得id
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
    </script>
</head>
<body>
	<div id="banner">
		<div id="top">
			<div id="topPic">
				<img src="./images/index_02.gif">
			</div>
		</div>
	</div>
<div id="main">
	<div id="mainMiddle">
		<div id="mainLeft">
			<img src="./images/index_06.jpg"></img>				<!-- 提取u_id -->
		</div>
		<div id="mainRight" style="background:url(./images/index_07.jpg);background-size:100% 100%;background-position:50% 50%;background-repeat:no-repeat">
			<div id="login">
				<form id="fm1" class="clearfix" action="login.action" method="post" onsubmit = "return check()">
					<li>学号：<input id="name" name="name" class="input1 required" tabindex="1" placeholder="学号(不能为空)" type="text"  autocomplete="false"></li>
					<li>密码：<input id="pwd" name="pwd" class="input2 required" tabindex="2" placeholder="密码(不能为空)" type="password" autocomplete="off"></li>
					<li style="text-align: right;"><input type="hidden" name="lt" value="LT-219852-Vv2yrbcSkQNCVIV2WZwflStiGajIOY"> <input type="hidden" name="execution" value="e1s1"> <input type="hidden" name="_eventId" value="submit"> 
						&nbsp;&nbsp;&nbsp; <input type="radio" name="role" value="0"/>管理员
            			&nbsp;&nbsp;&nbsp; <input type="radio" name="role" value="1" checked="checked"/>用户
            			&nbsp;&nbsp;&nbsp; <input class="loginBtn" name="submit" accesskey="l" value="注册" tabindex="4" type="button" onclick ="location.href='${pageContext.request.contextPath}/user/user_register.jsp'">			
            			&nbsp;&nbsp;&nbsp; <input class="loginBtn" name="submit" accesskey="1" value="登 录" tabindex="4" type="submit"></li>
				</form>
			</div>
		</div>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
</div>
	<div id="bottom" color = "skyblue">
	© 2019 哈尔滨工程大学<br> 
      	在线答题项目组服务电话：666 <a style="text-decoration:none;" href="./user/connectionus.jsp">联系我们</a>
	</div>
</body>
</html>