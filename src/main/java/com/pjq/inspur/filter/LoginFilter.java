package com.pjq.inspur.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;



public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String uname = (String) ((HttpServletRequest) servletRequest).getSession().getAttribute("uname");
        if (uname != null && !("").equals(uname)) {
            System.out.println("通过登陆拦截！");
            filterChain.doFilter(servletRequest, servletResponse);
        } else if (((HttpServletRequest) servletRequest).getServletPath().contains("/login")) {
            System.out.println("去登陆");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("不符合要求,被拦截！");
            servletRequest.setAttribute("msg", "请先登陆或者确认你的登陆权限!");
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}