package com.example.guanli.aop;

import com.example.guanli.utils.LogUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Aspect
@Component
public class logAop {
    private SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
    @Autowired
    private LogUtil logUtil;

    @Pointcut("execution(* com.example.guanli.controller.UserController.*(..))")
    public void log(){
    }
    @Before("log()")
    public void beforeLog(JoinPoint point){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();
        logUtil.info(Thread.currentThread().getName()+"  "+"【请求时间】："+simpleDateFormat.format(new Date()));
        logUtil.info(Thread.currentThread().getName()+"  "+"【请求URL】"+request.getRequestURI());
        logUtil.info(Thread.currentThread().getName()+"  "+"【请求Ip】"+request.getRemoteAddr());
    }
}
