package com.example.guanli.config;

import com.example.guanli.domain.Article;
import com.example.guanli.domain.UpmsUser;
import com.example.guanli.service.UserService;
import com.example.guanli.service.impl.PageServiceImpl;
import com.example.guanli.service.impl.UserServiceImpl;
import com.example.guanli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.List;
@Component
public class ListenHandler {
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PageServiceImpl pageService;

    public ListenHandler(){
        System.out.println("开始初始化");
    }
    @PostConstruct
    public void init(){
        System.out.println("数据库开始初始化");
        List<Article> articleList=pageService.searchArticle("");
        System.out.println("==============" + articleList);

        articleList.forEach(article -> {
            redisUtil.incr(article.getTitle(),article.getViews());
            System.out.println(article.getViews());
        });
        System.out.println("已写入Redis");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("关闭=================");
        List<Article> articleList=pageService.searchArticle("");
        articleList.forEach(article -> {
            Object h=redisUtil.get(article.getTitle());

            int i= (Integer)h;
            article.setViews(i);
            pageService.views(article);

            redisUtil.set(article.getTitle(),0);
        });
        System.out.println("数据从Redis取出完毕=====");
        System.out.println("销毁缓存====");

        System.out.println("销毁完成====");
        System.out.println("系统关闭中=============");
    }

}
