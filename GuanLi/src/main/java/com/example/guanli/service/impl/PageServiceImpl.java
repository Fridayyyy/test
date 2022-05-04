package com.example.guanli.service.impl;

import com.example.guanli.domain.Article;
import com.example.guanli.mapper.PageMapper;
import com.example.guanli.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    PageMapper pageMapper;
    public int saveArticle(Article article){
        return pageMapper.saveArticle(article);
    }
    public List<Article> queryArticle(int start){
        return pageMapper.queryArticle(start);
    }

    public int getAllArticle(){
        return pageMapper.getAllArticle();
    }

    public int deleteArticle(int id){
        return pageMapper.deleteArticle(id);
    }

    public int views(Article article){
        return pageMapper.views(article);
    }

    public Article check(int articleId){
        return pageMapper.check(articleId);
    }

    public List<Article> searchArticle(String name){
        return pageMapper.searchArticle(name);
    }
}
