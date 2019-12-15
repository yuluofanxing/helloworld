package com.aotuo.article.controller;

import com.aotuo.article.pojo.Comment;
import com.aotuo.article.service.CommentService;
import com.aotuo.entity.Result;
import com.aotuo.entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
@CrossOrigin
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping
    public Result findAllComment(){
        List<Comment>list=commentService.findAllComment();
        return new Result(true, StatusCode.OK,"查询所有评论成功",list);
    }

    //根据文章Id查询评论列表
    @GetMapping("findByArticleId/{id}")
    public Result findByArticleId(@PathVariable String id){
        Comment byArticleId = commentService.findByArticleId(id);
        return new Result(true,StatusCode.OK,"根据Id查询成功",byArticleId);
    }
    @PutMapping("thumbup/{id}")
    public Result thumbup(@PathVariable String id){
        Comment thumbup = commentService.thumbup(id);
        return new Result(true,StatusCode.OK,"恭喜您点赞成功",thumbup);
    }
}
