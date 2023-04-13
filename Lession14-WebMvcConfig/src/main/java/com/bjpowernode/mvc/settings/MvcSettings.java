package com.bjpowernode.mvc.settings;

import com.bjpowernode.mvc.fomatter.DeviceFormatter;
import com.bjpowernode.mvc.interceptor.AuthInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//SpringMVC的配置类，使用implements WebMvcConfigurer来代替xml配置SpringMVC
@Configuration
public class MvcSettings implements WebMvcConfigurer {
    //页面跳转控制器,从请求直达页面(无需通过controller处理请求)
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //配置页面的控制:addViewController("请求的uri")，指定它的目标视图:setViewName("目标视图")
        registry.addViewController("/welcome").setViewName("index");
    }

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DeviceFormatter());
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/article/**")  //要拦截地址
                .excludePathPatterns("/article/query","a");//不拦截谁
    }
}
