package com.example.guanli.service;

import com.example.guanli.domain.Article;

import java.util.List;

public interface PageService {
    int saveArticle(Article article);
    List<Article> queryArticle(int start);

    int getAllArticle();

    int deleteArticle(int id);

    int views(Article article);

    Article check(int articleId);

    List<Article> searchArticle(String name);
}
