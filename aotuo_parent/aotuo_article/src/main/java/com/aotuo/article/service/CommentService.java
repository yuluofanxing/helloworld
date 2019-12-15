package com.aotuo.article.service;

import com.aotuo.article.pojo.Comment;

import java.util.List;

public interface CommentService {
    //查询所有评论信息
    public List<Comment>findAllComment();

    public Comment findByArticleId(String id);

    public Comment thumbup(String id);

}
