<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<jsp:include page="header.jsp" />
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'info.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="static/js/iframe.js"></script>
</head>

<body>
	<div class="layout-body">
		<div class="w960  clf">
			<div class="m_left">
				<div class="inner pd1">
					<ul class="stats-list clf">
						<li class="first"><strong>${sessionScope.findFriendCount}</strong><span>好友</span></li>
						<li><strong>${sessionScope.messagescount}</strong><span>留言</span></li>
						<li><strong>${sessionScope.feelsCount}</strong><span>说说</span></li>
					</ul>
				</div>
				<div class="inner mt12 p0">
					<div class="hd">
						<h3>最近访客</h3>
					</div>
					<div class="bd">
						<ul class="avatar-list clf">
						   <c:forEach items="${sessionScope.historys}" var="visit">
							<li><a href="#" target="_blank"><img
									src="static/headpic/${visit.user.headpic}" alt="十二的头像" />
									<div class="a-name">${visit.user.nickname}</div> 
									</a></li>
							</c:forEach>
						</ul>
					</div>
				</div>
			</div>
			<div class="m_main">
				<iframe frameborder=0 width=854 id="iframepage" name="iframepage"
					onLoad="iFrameHeight()" 
					src="<%=request.getContextPath()%>/${other}"></iframe>
			</div>
		</div>
	</div>
</body>
</html>
