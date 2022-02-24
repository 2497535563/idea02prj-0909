package edu.soft.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
                                            //过滤器，选择不让进入的页面
@WebFilter(filterName = "LogonFilter",urlPatterns ={"/newspages/*","/util/*"})
public class LogonFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }
    public void destroy() {
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        //判定是否登录，若已经登录，则直接放行，若未登录，则给出提示，可以选择跳转到登录页面
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;
        HttpSession session = req.getSession();
        if (session.getAttribute("logonUser") == null){//待添加
            //未登录，给出提示，跳转到其他页面
            resp.sendRedirect(req.getContextPath()+"/error/error.jsp");
        }else {
            chain.doFilter(request, response);//放行（进入下一个过滤器或者进入下一步）

        }
    }
}
