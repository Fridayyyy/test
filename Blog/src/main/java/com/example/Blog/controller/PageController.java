package com.example.guanli.controller;

import com.example.guanli.domain.Article;
import com.example.guanli.domain.UpmsUser;
import com.example.guanli.service.PageService;
import com.example.guanli.service.impl.PageServiceImpl;
import com.example.guanli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("admin")
public class PageController {
    @Autowired
    private PageServiceImpl pageService;
    @Autowired
    private RedisUtil redisUtil;

    @RequestMapping("/article")
    @ResponseBody
    public Article check(Integer article){
        Article article1=pageService.check(article);
        redisUtil.incr(article1.getTitle(),1);
        System.out.println("articleTitle"+"\t"+redisUtil.get(article1.getTitle()));
        return article1;
    }

}
