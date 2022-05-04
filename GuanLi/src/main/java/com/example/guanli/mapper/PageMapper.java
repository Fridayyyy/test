package com.example.guanli.mapper;

import com.example.guanli.domain.Article;
import com.example.guanli.domain.UpmsUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface PageMapper {
    int saveArticle(Article article);

    List<Article> queryArticle(int start);

    int getAllArticle();

    int deleteArticle(int id);

    int views(Article article);

    Article check(int articleId);

    List<Article> searchArticle(String name);

}
