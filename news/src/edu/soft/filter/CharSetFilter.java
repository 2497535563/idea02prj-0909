package edu.soft.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import java.io.IOException;

//@WebFilter(filterName = "CharSetFilter")
public class CharSetFilter implements Filter {
    private String filterName;
    private String charSet;

    public void init(FilterConfig config) throws ServletException {
        filterName = config.getInitParameter("name");
        charSet = config.getInitParameter("charset");
        System.out.println("过滤器"+filterName+"初始化！");
    }

    public void destroy() {
        System.out.println("过滤器销毁");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("开始过滤"+charSet+"字符编码！");
        //过滤器的操作
        request.setCharacterEncoding("UTF-8");//请求    客户端--->服务端
        response.setCharacterEncoding("UTF-8");//响应    服务端--->客户端

        chain.doFilter(request, response);//进入下一个过滤器
    }
}
