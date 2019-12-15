package com.aotuo.article.service.impl;

import com.aotuo.article.pojo.Comment;
import com.aotuo.article.repository.CommentRepository;
import com.aotuo.article.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService{
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 查询所有评论
     * @return
     */
    //查询所有
    public List<Comment> findAllComment(){
        return commentRepository.findAll();
    }

    public Comment findByArticleId(String id){
        Comment comment = commentRepository.findById(id).get();
        return comment;
    }

    @Override
    public Comment thumbup(String id) {
        Comment comment = commentRepository.findById(id).get();
        comment.setThumbup(comment.getThumbup()+1);
        commentRepository.save(comment);
        return comment;
    }
}
