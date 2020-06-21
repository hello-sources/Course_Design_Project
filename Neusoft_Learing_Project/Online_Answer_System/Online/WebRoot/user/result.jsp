<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head> 
  	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
 
  	<style type="text/css">
.STYLE1 {
	font-family: "Microsoft YaHei UI";
	font-size: 36px;
	color: white;
}
.STYLE2 {
	font-family: "Microsoft YaHei UI";
	font-size: 24px;
	color: deeppink;
}
.STYLE3 {
	font-family: "Microsoft YaHei UI";
	font-size: 22px;
	color: red;
}
.img {
	vertical-align:middle;
}
</style>
    <title>考试成绩</title>  
  </head> 
  <body style="background:url(./images/beijing0.jpg)">
  <div id = ".img">
        <h1>共${nums}题,每题2分，满分${nums*2}分,您的成绩：${result }分</h1>
       <c:if test="${result lt 12 }">         
         <h1 style="color:red">小伙不行啊，得加油啊</h1>
         <img src="./images/fail.jpg" width="300px"/>
      </c:if>
      <c:if test="${result eq 12 }">        
         <h1 style="color:blue"> 
         	<img src ="./images/jige.jpg"/>
         	加把劲，努努力</h1>
      </c:if>
       <c:if test="${result eq 16 }">         
         <h1 style="color:green">良好</h1>
         <img src="./images/8fen.jpg"/>
     
      </c:if>
      <c:if test="${result eq 20 }">         
         <h1 style="color:deepblue">小伙厉害啊 </h1>
         <img src = "./images/No1.jpg"/>
      </c:if>
      </div>
       <h1 align="left" style="font-size:20px">您所选择的答案是：</h1>
      <c:forEach items="${selectAnswers}" var="q1">
 		<tr>
 			<td>
      			${q1 }
      		</td>
      </tr>
      </c:forEach>
      <h1 align="left" style="font-size:20px">正确的答案应该是：</h1>
      <c:forEach items="${correctAnswers}" var="q2">
       <tr >
       	<td>
       		${q2 }
       	</td>
        </tr> 
     </c:forEach>
	 <form action="${pageContext.request.contextPath}/insertGrade.action" method="post" id="submit1">		
  		<table align="center" border="2" width="30%">
  		<h1>确认以下信息无误后请点确定</h1>
  		<tr><th>科目编号</th>		<td><input type="text" name="sId" value="${s_id }" readonly="readonly" /></td>
  		<tr><th>总分：</th>	<td><input type="text" name ="score" value="${result }" readonly="readonly" /></td></tr>
  		<tr><th>用户id</th>	<td><input type="text" name="uId" value="${user.id }" readonly="readonly" /></td></tr>
  		</table>
  		<table align="center">
  		<tr>
  		<th><input type="submit"  value="确定"/></th>	
  		<th><input type="submit" value="取消"/></th>	
  		</tr>
  	</table>
  </form>
  </body>
</html>
