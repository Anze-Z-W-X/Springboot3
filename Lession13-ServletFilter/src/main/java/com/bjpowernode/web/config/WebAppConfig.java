package com.bjpowernode.web.config;

import com.bjpowernode.web.filter.AuthFilter;
import com.bjpowernode.web.filter.LogFilter;
import com.bjpowernode.web.servlet.LogServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

//编码方式创建Servlet,Filter
@Configuration
public class WebAppConfig {
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        //创建ServletRegistrationBean，登录一个或多个Servlet
        ServletRegistrationBean registrationBean = new ServletRegistrationBean<>();
        registrationBean.setServlet(new LogServlet());
        registrationBean.addUrlMappings("/user/log");
        registrationBean.setLoadOnStartup(1);
        return registrationBean;
    }

    @Bean
    public FilterRegistrationBean AuthFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new AuthFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean LogFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new LogFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.setOrder(0);
        return filterRegistrationBean;
    }

    //等级框架内置的Filter
    @Bean
    public FilterRegistrationBean addCommomLogFilter(){

        int[] arr = {2,1,3,6,5};


        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();

        CommonsRequestLoggingFilter commonsRequestLoggingFilter=new CommonsRequestLoggingFilter();
        //记录uri地址
        commonsRequestLoggingFilter.setIncludeQueryString(true);

        filterRegistrationBean.setFilter(commonsRequestLoggingFilter);
        filterRegistrationBean.addUrlPatterns("/*");
        return filterRegistrationBean;
    }
}
