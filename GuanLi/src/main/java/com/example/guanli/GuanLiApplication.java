package com.example.guanli;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableCaching
public class GuanLiApplication {

    public static void main(String[] args) {
        SpringApplication.run(GuanLiApplication.class, args);
    }

}
