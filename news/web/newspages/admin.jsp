<%@ page language="java" import="java.util.*,java.sql.*,edu.soft.pojo.*" pageEncoding="utf-8"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page import="edu.soft.pojo.User" %>
<%@ page import="edu.soft.pojo.News" %>
<%@ page import="edu.soft.util.Page" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
//当前url地址

%>


<%
    Page pages = (Page) request.getAttribute("pages");
    if (pages == null) {
        response.sendRedirect("PageControlServlet?pageIndex=1");
    }else {

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<base href="<%= basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<title>添加主题--管理后台</title>
<link href="<%= basePath%>/../css/admin.css" rel="stylesheet" type="text/css" />
</head>
<body>
<div id="header">
  <div id="welcome">欢迎使用新闻管理系统！</div>
  <div id="nav">
    <div id="logo"><img src="<%= basePath%>/../images/logo.jpg" alt="新闻中国" /></div>
    <div id="a_b01"><img src="<%= basePath%>/../images/a_b01.gif" alt="" /></div>
  </div>
</div>
<div id="admin_bar">
  <div id="status">管理员：
    <%--  <%
          String username = ((User) session.getAttribute("logonUser")).getUsername();
      %>
      <%=username%>--%>

<%--      ${logonUser.username}--%>

      <c:out value=" ${logonUser.username}" default="匿名" escapeXml="false"></c:out>

      登录  &#160;&#160;&#160;&#160; <a href="LogoutServlet">退出</a></div>

  <div id="channel"> </div>
</div>
<div id="main">
    <%@include file="console_element/left.html" %>
  <div id="opt_area">
    <script language="javascript">
	function clickdel(){
		return confirm("删除请点击确认");
	}
</script>
       <%--  <tr>
           表格的行
         </tr>

<td>
    表格的列
</td>

    <th>
        表格的表头
    </th>--%>

      <table >
      <%
          int totalPages = pages.getTotalPageCount();//获取总页数
          int pageIndex = pages.getCurrPageNo();//获取当前页码
          List<News> newsList = pages.getNewsList();//获取当前页的News列表
          for(News news:newsList){
      %>
      <tr>
          <td><%=news.getNTitle()%></td>
          <td><%=news.getNContent()%></td>
          <td><%=news.getNCreateDate()%></td>
      </tr>

     <%
          }
     %>
      </table>

      当前页数：[<%=pageIndex%>/<%=totalPages%>]

      <%
          if (pageIndex > 1){//不是首页
      %>

      <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=1">首页</a>
      <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=pageIndex-1%>">上一页</a>

<%
    }
%>

      <%
          if (pageIndex < totalPages){//不是尾页
        %>
      <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=pageIndex+1%>">下一页</a>
      <a href="<%=request.getContextPath()%>/PageControlServlet?pageIndex=<%=totalPages%>">尾页</a>

      <%
          }
        %>




     <%-- <ul>
          <c:forEach var="news" items="${allNews}" varStatus="status">
              <li <c:if test="${status.count%2==0}"> style="color:red"</c:if>>
                  <span>${status.count}</span>&#160;&#160;&#160;&#160;
                  <span>标题：${news.NTitle} </span>&#160;&#160;&#160;&#160;
                  <span>内容：${news.NContent}</span>&#160;&#160;&#160;&#160;
                  <span>日期：${news.NCreateDate}</span>/
                  <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                  <a href='#'>删除</a> &#160;&#160;&#160;&#160;
              </li>
          </c:forEach>
      </ul>--%>



     <%-- <table border="1">
          <tr>
              <th>标题</th>
              <th>内容</th>
              <th>日期</th>
              <c:forEach var="news" items="${allNews}" varStatus="">
                  <tr>
                      <td>标题：${news.NTitle} </td>&#160;&#160;&#160;&#160;
                      <td>内容：${news.NContent}</td>&#160;&#160;&#160;&#160;
                      <td>日期：${news.NCreateDate}</td>
                  </tr>
              </c:forEach>
          </tr>
      </table>
--%>

<%--    <ul class="classlist">
      <%
      List<News> list=( List<News>)session.getAttribute("allNews");
      if(list==null){
      	response.sendRedirect("../util/do_news_list.jsp");
      	return;
      }else{
	      session.removeAttribute("list");
		  int n=0;
		  for(News tempNew:list){
		    n++;
	     %>
	      <li><%=tempNew.getNTitle() %>
              <span> 作者：<%=tempNew.getNAuthor() %> &#160;&#160;&#160;&#160;
                  内容：<%=tempNew.getNContent() %> &#160;&#160;&#160;&#160;
                  时间：<%=tempNew.getNCreateDate() %> &#160;&#160;&#160;&#160;
                  <a href='#'>修改</a> &#160;&#160;&#160;&#160;
                  <a href='#' onclick='return clickdel()'>删除</a>
              </span>
          </li>
	      <%if(n%5==0){ %>
	      <li class='space'></li>
	      <%}} }%>
    </ul>--%>
  </div>
</div>
<div id="footer">
  <%@include file="console_element/bottom.html" %>
</div>
</body>
</html>

<%
    }
%>