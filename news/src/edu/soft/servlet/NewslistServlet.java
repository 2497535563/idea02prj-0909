package edu.soft.servlet;

import edu.soft.dao.NewsDao;
import edu.soft.pojo.News;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "NewslistServlet", value = "/NewslistServlet")
public class NewslistServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询新闻，存入servl
        List<News> list = new NewsDao().findAllNews();
        list = new NewsDao().findAllNews();
        HttpSession session = request.getSession();


      /*  if (session.getAttribute()){

        }*/

        session.setAttribute("allNews",list);
//        response.sendRedirect("newspages/admin.jsp");

        response.sendRedirect("TopicListServlet");


    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
