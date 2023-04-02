package com.bjpowernode.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

@Component
@Aspect
public class LogAspect {
    @Before("execution(* com.bjpowernode.aop.service..*.*(..))")
    //功能增加方法
    public void sysLog(JoinPoint joinPoint){
        StringJoiner log = new StringJoiner("|", "{", "}");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        log.add(dateTimeFormatter.format(LocalDateTime.now()));
        //当前执行方法的名称
        String name = joinPoint.getSignature().getName();
        log.add(name);
        //方法的参数
        Object[] args = joinPoint.getArgs();
        for(Object arg:args)
            log.add(arg==null?"-":arg.toString());
        System.out.println("日志:"+log);
    }
}
