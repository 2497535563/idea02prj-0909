<%--
  Created by IntelliJ IDEA.
  User: 赵书嵘
  Date: 2021/9/17
  Time: 16:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
这里是2021年9月17日创建的页面
<%
    request.setAttribute("msg","你好这里是0917.jsp");
%>

<button href="redirect()">重定向到0918</button>

<button href="">转发到0918</button>

</body>
</html>
