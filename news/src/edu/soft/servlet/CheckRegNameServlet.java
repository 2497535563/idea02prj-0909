package edu.soft.servlet;

import edu.soft.dao.UsereDao;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "CheckRegNameServlet", value = "/CheckRegNameServlet")
public class CheckRegNameServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String regName = request.getParameter("regName");//获取地址栏url中的regName参数值
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //查询数据库，调用UsereDao中的查询方法
        int res = new UsereDao().findUserByName(regName);
        System.out.println("doGet----res="+res);
        out.print(res);
        out.flush();//清空输出流
        out.close();//关闭输出流
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
this.doGet(request,response);
    }
}
