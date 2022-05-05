package com.example.guanli.config;

import com.example.guanli.utils.AdminLoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class LoginConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry){

        registry.addInterceptor(new AdminLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/resultL")
                .excludePathPatterns("/admin/save")
                .excludePathPatterns("/admin/saveResult");
        System.out.println("拦截成功");
    }
}
