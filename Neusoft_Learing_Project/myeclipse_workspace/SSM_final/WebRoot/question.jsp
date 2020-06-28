<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head> 
    <title>在线答题页面</title>
    <script type="text/javascript"> 
window.onload = function() {  
var show = document.getElementById("show");  
setInterval(function() {   
var time = new Date();   // 程序计时的月从0开始取值后+1   
var m = time.getMonth() + 1;   
var t = time.getFullYear() + "-" + m + "-"     
+ time.getDate() + " " + time.getHours() + ":"     
+ time.getMinutes() + ":" + time.getSeconds();   
show.innerHTML = t;  
}, 1000); 
};
</script> 
  </head> 
  <body>
     <h1 style="text-align: right"><span id="show"></span></h1>
     <hr color="red" size="10px"/>
     <form action="reply.action" method="post">
     <table border="1" width="100%" background="images/exam-bg.jpg"
      bordercolorlight="red" bordercolordark="yellow">
     <tr>
      <th>编号</th><th>题目</th><th>选项</th><th>答案</th><th>分数</th>
     </tr>
     <c:forEach items="${questions}" var="q">
       <tr>
         <td>${q.qid }</td>
         <td>${q.title }</td><td>
       <input type="radio" name="a${q.qid }" value="A"/>A:${q.optionA }<br/>
       <input type="radio" name="a${q.qid }" value="B"/>B:${q.optionB }<br/>
       <input type="radio" name="a${q.qid }" value="C"/>C:${q.optionC }<br/>
       <input type="radio" name="a${q.qid }" value="D"/>D:${q.optionD }</td>
       <td>作弊答案:${q.answer }</td><td>分数:${q.score }</td>
       </tr> 
     </c:forEach>
     <tr align="center">
      <td colspan="5"><input type="submit" 
       style="width:500px;height:50px;font-size:40px;color:red;background:lightgreen" value="我要交卷"/></td>
     </tr>
     </table>
     </form>
  </body>
</html>
