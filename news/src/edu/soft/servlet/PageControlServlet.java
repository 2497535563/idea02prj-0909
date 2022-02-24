package edu.soft.servlet;

import edu.soft.dao.NewsDao;

import edu.soft.pojo.News;
import edu.soft.util.Page;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PageControlServlet", value = "/PageControlServlet")
public class PageControlServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            Page pages = new Page();
            NewsDao newsDao = new NewsDao();
            String pageIndex = request.getParameter("pageIndex");//url地址中的当前页码
            if (pageIndex==null){//没有pageIndex参数
                pageIndex="1";}//若若没有获取页码，设置为首页1
            int currPageNo = Integer.parseInt(pageIndex);//设置当前页
            if (currPageNo<1){//当前页面不可小于1
                currPageNo=1;
            }else if (currPageNo>pages.getTotalPageCount()){//当前页不可大于最末页
//            currPageNo = pages.getTotalPageCount();
            }
            pages.setCurrPageNo(currPageNo);//设置pages对象当前页
            System.out.println("当前页currPageNo="+currPageNo);
            int totalCount = newsDao.getTotalCount();//查询获取News总记录条数（数据库查询）
            System.out.println("总记录totalCount="+totalCount);

            pages.setPageSize(2);//设置pages对象每页显示几条记录

            pages.setTotalCount(totalCount);//设置pages对象总记录数
            pages.setTotalPageCount(pages.getTotalCount());//设置pages对象总页数
            System.out.println("总页数TotalPages="+pages.getTotalPageCount());
            List<News> newsList = newsDao.getPageNewsList(pages.getCurrPageNo(),pages.getPageSize());
            for (News news:newsList){
                System.out.println(news);
            }
            pages.setNewsList(newsList);//设置pages对象的newlist的值
            request.setAttribute("pages",pages);//将pages存入request
            // request.getRequestDispatcher("newspages/admin.jsp").forward(request,response);
            request.getRequestDispatcher("newspages/admin.jsp").forward(request,response);
        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
        }
}
