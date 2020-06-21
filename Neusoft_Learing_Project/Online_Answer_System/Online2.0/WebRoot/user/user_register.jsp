<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>注册</title>
<meta http-equiv='content-type' content='text/html;charset=utf-8'/> 
        <script type='text/javascript' src='jquery-1.7.2.js'></script> 
        <script type='text/javascript'> 
        var code ; //在全局定义验证码   
           
        function createCode(){ 
             code = "";    
             var codeLength = 4;//验证码的长度   
             var checkCode = document.getElementById("code");    
             var random = new Array(0,1,2,3,4,5,6,7,8,9,'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R',   
             'S','T','U','V','W','X','Y','Z');//随机数   
             for(var i = 0; i < codeLength; i++) {//循环操作   
                var index = Math.floor(Math.random()*36);//取得随机数的索引（0~35）   
                code += random[index];//根据索引取得随机数加到code上   
            }   
            checkCode.value = code;//把code值赋给验证码
        } 
       
        //校验验证码   
        function validate(){ 
            var pass=document.getElementById("pwd").value;
            var na = document.getElementById("name").value;
            var inputCode = document.getElementById("input").value.toUpperCase(); //取得输入的验证码并转化为大写          
            if (pass.length<=0 || na.length<=0){
                alert("请重新输入账号密码");
            	return false;
            }
            if(inputCode.length <= 0) { //若输入的验证码长度为0   
                alert("请输入验证码！"); //则弹出请输入验证码   
                return false;
            }else if(inputCode !=code) { //若输入的验证码与产生的验证码不一致时   
                alert("验证码输入错误！@_@"); //则弹出验证码输入错误   
                createCode();//刷新验证码   
                document.getElementById("input").value = "";//清空文本框   
            }else { //输入正确时   
                alert("合格！注册成功！^-^"); 
            } 
        } 
        </script> 
        <style type='text/css'> 
        #code{ 
            font-family:Arial,宋体; 
            font-style:italic; 
            color:blue;
            size:12px;            
            border:0; 
            padding:2px 3px; 
            letter-spacing:8px; 
            font-weight:bolder; 
        } 
        </style> 
</head>

<body onload='createCode()'>
	<table border=0 align="center">
		<th ><img src="${pageContext.request.contextPath}/images/index_01.jpg">
		</th>
		</table>
<form action="${pageContext.request.contextPath}/register.action" method="post">
<!-- 可能需要修改的地方，就是加上${pageContext.request.contextPath}这个东西 -->
	<table align="center" border="0">
		<tr>
            <th>用        户:</th><td><input type="text"
            class="solid"
             placeholder="请输入用户名"
             name="name" id="name" /></td>
          </tr>
          <tr>
            <th>密        码:</th><td><input type="password" class="solid" placeholder="请输入密码"
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
            <th>备       注:</th><td>
            <input  name="mark" /></td>
          </tr>
		  <tr>
		  	<div>
		  		<th>验 证 码:</th>
		  		<th>   
            	<input type = "text" id = "input"/>   
            	<input type="button" id="code" onclick="createCode()" style="height:40px;width:80px" title='点击更换验证码' /> 
            	</th>
        	</div>  
		  </tr>
        <tr><th colspan=2 height=65><input type="checkbox"><font size='2' color='red' required/>我已阅读并同意相关条例</font></input></th></tr>
		
		<tr>
			<th colspan=2 height=35><input type='submit' style="background-color:red;height:35px;width:100px;font-size:20px;color:white;border:none" value='注册'id='l' onclick = "validate()" ></th>
			<th colspan=2 height=35><input type='reset' style="background-color:deepskyblue;height:35px;width:100px;font-size:20px;color:white;border:none" value='取消'></th>
		</tr>
	</table>
</form>
<table align="center">
	<tr>
		<th bgcolor='f9f8ed' height=100px width=978px>
			<p>📧联系邮箱：3245849061@qq.com</p>
			<p>联系地址：哈尔滨工程大学</p>
			<p>📞联系电话：66666</p>
		</th>
	</tr>
</table>
</body>
</html>


