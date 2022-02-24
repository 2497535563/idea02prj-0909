<%--
  Created by IntelliJ IDEA.
  User: 赵书嵘
  Date: 2021/9/21
  Time: 9:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<%
//在application对象中放入一个属性
application.setAttribute("att","hello你好");
out.write
("同页面下，显示：<strong>"+application.getAttribute("att")
    +"</strong><br>");
//当前页面被重定向到TestApplicationScope.jsp
//response.sendRedirect("TestApplicationScope.jsp");
%>

</body>
</html>
