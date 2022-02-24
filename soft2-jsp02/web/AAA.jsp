<%--
  Created by IntelliJ IDEA.
  User: 赵书嵘
  Date: 2022/2/24
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>当前已有多少人访问过本网页</title>
</head>
<body>
<%
    int counter =1;//变量
    if(application.getAttribute("c")!=null){//存在c属性
        counter = (Integer)application.getAttribute("c") + 1;//计数器自增1
    }
    application.setAttribute("c",new Integer(counter));
%>
<p>当前已有<%= counter%>人访问过本网页</p>
<p>当前已有${application.counter}人访问过本网页</p>
</body>
</html>
