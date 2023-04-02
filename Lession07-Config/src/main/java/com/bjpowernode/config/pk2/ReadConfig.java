package com.bjpowernode.config.pk2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class ReadConfig {
    @Autowired
    private Environment environment;

    public void print(){
        String name = environment.getProperty("app.name");

        if(environment.containsProperty("app.owner")){
            System.out.println("app.owner存在");
        }
        int port = environment.getProperty("app.port",Integer.class,700);
        System.out.println("str="+String.format("读取的key值,name=%s,port=%d",name,port));
    }
}
