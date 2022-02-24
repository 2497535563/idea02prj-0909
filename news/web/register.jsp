<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>新闻中国</title>
    <link href="css/main.css" rel="stylesheet" type="text/css" />
    <script src="${pageContext.request.contextPath}/js/jquery-3.6.0.min.js" type="text/javascript"></script>
    <script language="javascript">
        function check(){
            //获取表单中的账号username数据
            var id_username = document.getElementById("id_username").value;
            //获取表单中密码pwd的数据
            var id_upwd = document.getElementById("id_upwd").value;
            if(id_username == null || id_username == ""){//判定数据是否为空
                alert("账号为空，请重新登录！")//提示 弹出框
                document.getElementById("usernameError").innerHTML="账号不能为空！";
                return false;
            }
            if (id_upwd == null || id_upwd == ""){//判定数据是否为空
                alert("密码为空，请重新注册！")//提示 弹出框
                document.getElementById("upwdError").innerHTML="密码不能为空！";
                return false;
            }
            alert("通过空值验证");
            return true;//验证通过
        }

        function jqueryCheck(){
            const id_username = $("#id_username").val();
            const id_upwd = $("#id_upwd").val();
            if(id_username == null || id_username == ""){//判定数据是否为空
                $("#usernameError").html("账号不能为空!");
                $("#upwdError").html("");

                $("#id_username").focus();
                return false;
            }
            if (id_upwd == null || id_upwd == ""){//判定数据是否为空
                $("#upwdError").html("密码不能为空！");
                $("#usernameError").html("");

                $("#id_upwd").focus();
                return false;
            }
            alert("通过空值验证");
            return true;//验证通过
        }

        function focusOnLogin(){
            // var login_username = document.getElementById("username");
            // login_username.focus();
            $("#id_username").focus();

        }

        //*************************js原生ajax********************
        var xhr;//声明XMLHttpRequest对象变量
        function createXHR(){
            try{
                return new XMLHttpRequest();//创建XMLHttpRequest对象
            }catch (e){
                return new ActiveXObject("Microsoft.XMLHTTP");
            }
        }

        function checkRegName(regName){
            xhr = createXHR();//xhr(XMLHttpRequest)赋值
            xhr.onreadystatechange = callback;//当xhr状态改变，即调用回函数callback
            //查询数据库，获取结果。
            xhr.open("get","CheckRegNameServlet?regName="+regName,true);
            //发送给后台，让后台执行servlet
            xhr.send(null);

            //-----------ajax的jquery--------------
          /*  $.get(
                "CheckRegNameServlet",
                {regName},
                function (data){
                    if (data == 0){//返回结果若为0，则无此用户，显示可注册
                        alert("callback()-----0");
                        document.getElementById("logonNameCheck").
                            innerHTML="<font style='color: green'>用户名可以注册(jquery)</font>";
                        document.getElementById("regBtn").disabled=false;
                    }else if(data == 1){
                        alert("callback()-----1");
                        document.getElementById("logonNameCheck").
                            innerHTML="<font style='color:red'>用户名已存在(jquery)</font>";
                        document.getElementById("regBtn").disabled=true;
                    }else {
                        alert("数据有误！")
                    }
                }
            )

            $.ajax({
                    url:"CheckRegNameServlet",
                    type:"get",
                    data:{regName},
                dataType:"text",
                    success:function (data){
                        if (data == 0){//返回结果若为0，则无此用户，显示可注册
                            alert("callback()-----0");
                            document.getElementById("logonNameCheck").
                                innerHTML="<font style='color: green'>用户名可以注册(jquery)</font>";
                            document.getElementById("regBtn").disabled=false;
                            document.getElementById("regForm").style.visibility = "hidden";

                        }else if(data == 1){
                            alert("callback()-----1");
                            document.getElementById("logonNameCheck").
                                innerHTML="<font style='color:red'>用户名已存在(jquery)</font>";
                            document.getElementById("regBtn").disabled=true;
                            document.getElementById("regForm").style.visibility = "hidden";

                        }else {
                            alert("数据有误！")
                        }
                    }
                }
            )*/
        }
        function callback(){//回调函数，获servlet的返回值，根据返回值进行页面的异步更新
            if(xhr.readyState==4 && xhr.status==200){//是否servlet执行成功
                var res = xhr.responseText;//获取open方法中的servlet的返回值
                if (res == 0){//返回结果若为0，则无此用户，显示可注册
                    alert("callback()-----0");
                    document.getElementById("logonNameCheck").
                        innerHTML="<font style='color: green'>用户名可以注册</font>";
                    document.getElementById("regBtn").disabled=false;//设置按钮可用

                    // $("#regBtn").attr("disabled",false);//设置按钮可用
                    document.getElementById("regForm").style.visibility = "hidden";

                }else if(res == 1){//返回结果若为1，则有此用户，不能注册，
                    alert("callback()-----1");
                    document.getElementById("logonNameCheck").
                        innerHTML="<font style='color:red'>用户名已存在</font>";
                    document.getElementById("regBtn").disabled=true;//设置按钮可用

                    // $("#regBtn").attr("disabled",true);//设置按钮可用
                    document.getElementById("regForm").style.visibility = "hidden";

                }else {
                    alert("数据有误！")
                }
            }
        }
    </script>
</head>
<body onload="focusOnLogin()">
<div id="header">

    <div id="nav">
        <div id="logo"> <img src="images/logo.jpg" alt="新闻中国" /> </div>
        <div id="a_b01"> <img src="images/a_b01.gif" alt="" /> </div>
        <!--mainnav end-->
    </div>
</div>
<div id="container">
    <div class="main">
        <div class="class_type"> <img src="images/class_type.gif" alt="新闻中心" /> </div>
        <div class="content">
            <form action="RegisterServlet" method="post" >
                <label> 用户名 </label>
                <input onblur="checkRegName(this.value)" id="id_username" name="username" placeholder="请输入账号/用户名/手机号" class="login_input" />
                <label id="usernameError" style="color: red"> </label>
                <span id="logonNameCheck"></span>
                <br><br><label> 密&#160;&#160;&#160;码 </label>
                <input type="password" id="id_upwd" name="upwd" placeholder="请输入密码" class="login_input" />
                <label id="upwdError" style="color: red"> </label>
                <br><br><input type="submit" class="login_sub" value="注册" id="regBtn"/>
                <input type="button" class="login_sub" value="返回" onclick="javascrtpt:window.location.href='index.jsp'" />
            </form>
        </div>
<%--        <%@include file="index-elements/index_rightbar.html"%>--%>
    </div>
</div>
<%@include file="index-elements/index_bottom.html"%>
</body>
</html>
