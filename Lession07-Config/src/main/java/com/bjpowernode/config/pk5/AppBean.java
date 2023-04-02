package com.bjpowernode.config.pk5;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration(proxyBeanMethods = false)
@ConfigurationProperties(prefix = "spring.datasource")
public class AppBean {
    //key的名称与属性名相同，调用set方法为属性赋值,static的属性无效
    private String url;
    private String username;
    private Integer password;

    @Override
    public String toString() {
        return "AppBean{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password=" + password +
                '}';
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getPassword() {
        return password;
    }

    public void setPassword(Integer password) {
        this.password = password;
    }
}
