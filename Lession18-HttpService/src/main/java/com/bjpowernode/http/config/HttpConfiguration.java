package com.bjpowernode.http.config;

import com.bjpowernode.http.service.AlbumsService;
import com.bjpowernode.http.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration(proxyBeanMethods = false)
public class HttpConfiguration {
    //创建服务接口的代理对象,基于WebClient
    @Bean
    public TodoService requestService(){
        WebClient webClient=
                WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com/").build();
        //创建代理对象
        HttpServiceProxyFactory proxyFactory=
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();

        //创建某个接口的代理事务
        return proxyFactory.createClient(TodoService.class);
    }

    //创建代理
    @Bean
    public AlbumsService albumsService(){
        WebClient webClient = WebClient.create();
        HttpServiceProxyFactory proxyFactory =
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(webClient)).build();
        return proxyFactory.createClient(AlbumsService.class);
    }
}
