<%--
  Created by IntelliJ IDEA.
  User: 赵书嵘
  Date: 2021/9/20
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //在page对象中放入一个属性
    pageContext.setAttribute("att","hello你好");
    out.write("同页面下，显示：<strong>"+pageContext.getAttribute("att")+"</strong><br>");
    pageContext.include("TestPageScope.jsp");
%>

</body>
</html>