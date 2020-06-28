<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
  <head> 
    <title>在线答题页面</title> 
  </head> 
  <body>
     <table border="2" width="100%">
     
     <c:forEach items="${questions}" var="q">
       <tr>
         <td>${q.title }</td><td><input type="radio" name="a${q.qid }" value="A"/>A:${q.optionA }
       <input type="radio" name="a${q.qid }" value="B"/>B:${q.optionB }
       <input type="radio" name="a${q.qid }" value="C"/>C:${q.optionC }
       <input type="radio" name="a${q.qid }" value="D"/>D:${q.optionD }</td>
       <td>作弊答案:${q.answer }</td><td>分数:${q.score }</td>
       </tr> 
     </c:forEach>
     </table>
  </body>
</html>
