<%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/10/20
  Time: 8:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<%
    response.setStatus(HttpServletResponse.SC_OK);
%>
<html>
<head>
    <title>访问页面不存在</title>
</head>
<body>
访问页面不存在
<a href="javascript:history.go(-1)">返回上页面</a>
</body>
</html>
