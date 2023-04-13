package com.bjpowernode.mvc.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;

public class AuthInterceptor implements HandlerInterceptor {
    private static final String COMMON_USER = "zhangsan";
    //判断登陆的用户能否执行相应操作

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("======权限拦截器运行了=====");
        String loginUser = request.getParameter("loginUser");
        //获取请求的URI
        String requestURI = request.getRequestURI();

        if(COMMON_USER.equals(loginUser)&&(requestURI.startsWith("/article/add")
        ||requestURI.startsWith("/article/edit")))
            return false;
        return true;
    }
}
