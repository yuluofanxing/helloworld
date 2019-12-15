package com.aotuo.article.service.impl;

import com.aotuo.article.dao.ArticleDao;
import com.aotuo.article.pojo.Article;
import com.aotuo.article.service.ArticleService;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService{
    @Autowired
    private ArticleDao articleDao;
    /**
     * 查询所有文章信息
     * @return 所有文章信息
     */
    @Override
    public List<Article> findAll() {
        List<Article> articles = articleDao.selectList(null);
        return articles;
    }

    /**
     * 根据Id查询文章相关信息
     * @param id
     * @return 查询出的文章信息
     */
    @Override
    public Article findById(String id) {
        Map<String,Object>columnMap=new HashMap<>();
        columnMap.put("id",id);
        List<Article> articles = articleDao.selectByMap(columnMap);
        return articles.get(0);
    }

    /**
     * 添加文章信息
     * @param article
     * @return 返回添加的文章信息
     */
    @Override
    public Article add(Article article) {
        articleDao.insert(article);
        return article;
    }

    /**
     * 根据id对文章信息进行修改
     * @param article
     * @return
     */
    @Override
    public Article update(Article article) {
        EntityWrapper wrapper=new EntityWrapper<Article>();
        //设置查询条件
        wrapper.eq("id",article.getId());
        articleDao.update(article,wrapper);
        return article;
    }

    /**
     * 根据Id进行删除
     * @param id
     */
    @Override
    public void deleteById(String id) {
        EntityWrapper wrapper=new EntityWrapper();
        wrapper.eq("id",id);
        articleDao.delete(wrapper);
    }

}
