<%@ page import="edu.soft.dao.UsereDao" %>
<%@ page import="edu.soft.pojo.User" %><%--
  Created by IntelliJ IDEA.
  User: 86183
  Date: 2021/9/24
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //1.接收表单数据
    String username = request.getParameter("username");
    String upwd = request.getParameter("upwd");
    //2.调用UserDao,获取返回值
    User user = new UsereDao().findUser(username,upwd);

    //3.判定返回值，页面跳转
    if (user!=null){//查询到用户    非空
        //将用户user存入session
        session.setAttribute("logonUser",user);//设置session属性
        response.sendRedirect("do_news_list.jsp");//新闻页面
    }else {//没有查询到用户，跳转回去
        System.out.println("登录失败，返回登录页...");
        response.sendRedirect("../index.jsp");//跳转（重定向）到登录页面
    }
%>
</body>
</html>
