package com.pjq.inspur.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uname = (String) request.getSession().getAttribute("uname");
        if (uname != null && !("").equals(uname)) {
            System.out.println("通过登陆拦截！");
            return true;
        } else {
            System.out.println("不符合要求,被拦截！");
            request.setAttribute("msg", "请先登陆或者确认你的登陆权限!");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
            return false;
        }
    }
}