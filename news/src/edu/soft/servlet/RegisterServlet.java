package edu.soft.servlet;

import edu.soft.dao.UsereDao;
import edu.soft.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集编码（）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //1.获取注册页面中的表单数据（账号，密码）
        //1.获取表单中的数据
        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");
        //2.调用findUser()方法，传入参数
        boolean user = new UsereDao().addUser(username,upwd);
        //3.判定返回值，进行跳转
        if(user == false){//查到此人
            HttpSession session = request.getSession();//创建session;
            session.setAttribute("logonUser",username);//把用户对象存入session
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script language='javascript'>"+
                    "alert('注册成功，返回登录页面登录');"+
                    "window.location.href='index.jsp'"+
                    "</script>");
        }else{//提示登陆信息无效，请重新登录
            response.setContentType("text/html;charset=utf-8");
            PrintWriter out = response.getWriter();
            out.write("<script language='javascript'>"+
                    "alert('注册失败');"+
                    "window.location.href='register.jsp'"+
                    "</script>");

        }

        //2.将参数传入UsereDao类的addUser()方法



        //3.判定addUser()返回值，跳转至首页alert提示），或者注册页面（alert提示）

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);//调用doGet方法


    }
}
