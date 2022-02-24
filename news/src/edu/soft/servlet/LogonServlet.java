package edu.soft.servlet;

import edu.soft.dao.UsereDao;
import edu.soft.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/*
@WebServlet(name = "LogonServlet",
            loadOnStartup = 1,
          value = "/LogonServlet",
        initParams = {@WebInitParam(name = "name1",value = "value1")})
*/
public class LogonServlet extends HttpServlet {

   /* @Override
    public  void init() throws ServletException{
        System.out.println("开始创建LogonServlet");
        super.init();//执行创建操作
    }*/

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //字符集编码（）
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //1.解析Request对象，获取username,upwd对象
        String username = request.getParameter("username");
        String upwd = request.getParameter("upwd");

        //2.调用UsersDao中的finndUsers()方法，获取返回值
        User user = new UsereDao().findUser(username,upwd);

        //3.判定返回值，跳转页面
        if (user!=null){//查询到用户    非空
            //将用户user存入session
            HttpSession session = request.getSession();
            session.setAttribute("logonUser",user);//设置session属性

            /*session.removeAttribute("xxx");
            session.invalidate();*/

            //跳转到下一个servlet
            request.getRequestDispatcher("NewslistServlet").forward(request,response);
//            response.sendRedirect("util/do_news_list.jsp");//新闻页面
        }else {//没有查询到用户，跳转回去
//            response.sendRedirect("../index.jsp");//跳转（重定向）到登录页面
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.println("<script language='javascript'>"+
                    "alert('账号或密码错误，请重新登录！');"+
                    "window.location.href='index.jsp';"+
                    "</script>");
            writer.flush();//输出流清空
            writer.close();//输出流关闭
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);//调用doGet方法

    }
}
