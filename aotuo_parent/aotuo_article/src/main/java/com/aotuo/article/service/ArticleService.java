package com.aotuo.article.service;

import com.aotuo.article.pojo.Article;

import java.util.List;

public interface ArticleService {
    //查询所有文章信息
    public List<Article>findAll();
    //根据id进行查询文章信息
    public Article findById(String id);
    //添加文章信息
    public Article add(Article article);
    //修改文章的信息
    public Article update(Article article);
    //根据Id进行删除
    public void deleteById(String id);

}
