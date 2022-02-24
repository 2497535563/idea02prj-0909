package edu.soft.servlet;

import edu.soft.dao.TopicDao;
import edu.soft.pojo.Topic;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TopicListServlet", value = "/TopicListServlet")
public class TopicListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Topic> list = new TopicDao().findAllTopic();
        for (Topic topic:list){
            System.out.println(topic);
        }
        HttpSession session = request.getSession();

       /* if (session.getAttribute("allTopics") == null){
            session.setAttribute("allTopics",list);
        }*/

//        request.getSession().setAttribute("allTopic",list);

//        response.sendRedirect("newspages/admin.jsp");
        response.sendRedirect("PageControlServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
