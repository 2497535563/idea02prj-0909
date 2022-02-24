<%--
  Created by IntelliJ IDEA.
  User: 赵书嵘
  Date: 2021/9/11
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         import="edu.soft2.dao.GoodsDao,edu.soft2.entity.Goods" %>
<%@ page import="java.util.List" %>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//当前url地址
%>
<html>
<head>
    <base href="<%=basePath%>"><%--引入basePath到页面中--%>
    <title>陕西饭店的菜单</title>
</head>
<body>
<div>pagecontext: ${pageContext.request.contextPath}</div>

<a href="<%=path+"/img/1.jpg"%>">点击看图</a>

<a href=${pageContext.request.contextPath}/img/1.jpg>点击看图</a>

<%
    Integer x = (Integer) application.getAttribute("counter");
    out.write("path="+path+",basePath="+basePath+"您好，您是第"+x+"位访问本网站的登录用户:");
//    if (x == 3){
//        out.write("恭喜你是本网站第一百万位访客");
//    }
%>
<%--<%
    //1.循环遍历cookie数组，查询到c_id和c_pwd
    Cookie[] cs = request.getCookies();
    boolean flag = false;
    //2.页面显示用户的账号、密码
    for(int i=0;i< cs.length;i++){
        if(cs[i].getName().equals("msg1")){
            flag = true;
            out.write("<div>你的登录账号："+cs[i].getValue()+"</div>");
        }
        if(cs[i].getName().equals("msg2")){
            flag = true;
            out.write("<div>你的登录密码："+cs[i].getValue()+"</div>");
        }
    }
    //3.过一段时间刷新页面(超过有效期)，会显示已过期，无法登录
    if(flag==false){
        out.write("cookie已过期，无法显示账号密码");
    }
%>
<div>
    <a href=" ">登出</a></div><br>
<a href="pages/0917.jsp">跳转到0917.jsp页面</a>
<table border="1">
    <caption>菜单</caption>
    <tr>
        <td>编号</td><td>名称</td><td>价格</td><td>折扣</td><td>种类编号</td><td>商家编号</td><td>评分</td><td>描述</td><td>包装费</td>
    </tr>
    <%
        List<Goods> list = new GoodsDao().queryAllGoods();
        for(int i = 0;i< list.size();i++){
            Goods goods = list.get(i);
            //添加到表格
    %>
    <tr>
        <td><%=goods.getGoodsid()%></td>
        <td><%=goods.getTitle()%></td>
        <td><%=goods.getUnitPrice()%></td>
        <td><%=goods.getDiscount()%></td>
        <td><%=goods.getCateid()%></td>
        <td><%=goods.getStoreid()%></td>
        <td><%=goods.getRoat()%></td>
        <td><%=goods.getDescription()%></td>
        <td><%=goods.getPackingExpense()%></td>
    </tr>

    <% } %>
</table>--%>
<%-- <%out.print(basePath);%>--%>
</body>
</html>