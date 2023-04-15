package com.bjpowernode.http.service;

import com.bjpowernode.http.model.Albums;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url = "https://jsonplaceholder.typicode.com/")
public interface AlbumsService {

    //查询专辑
    @HttpExchange(method = "GET",url = "/albums/{id}")
    Albums getById(@PathVariable Integer id);
}
