package com.aotuo.article.controller;

import com.aotuo.article.pojo.Article;
import com.aotuo.article.service.ArticleService;
import com.aotuo.entity.Result;
import com.aotuo.entity.StatusCode;
import com.aotuo.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
@CrossOrigin
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private IdWorker idWorker;
    //查询所有文章相关信息
    @GetMapping("/findAll")
    public Result findAll(){
        List<Article> AllArtcile = articleService.findAll();
        //如果查询出长度是零
        if (AllArtcile.size()==0){
            return new Result(false, StatusCode.OK,"数据库暂时没有存储文章信息",null);
        }
        //如果查询出来结果,就将查询到的数据返回
        return new Result(true,StatusCode.OK,"恭喜您查询成功",AllArtcile);
    }
    //根据Id进行文章查询
    @GetMapping("findById/{id}")
    public Result findById(@PathVariable String id){
        //查询出文章的信息
        try {
            Article article = articleService.findById(id);
            return new Result(true,StatusCode.OK,"查询文章相关信息成功",article);
        }catch (Exception e){
            return new Result(false,StatusCode.ERROR,"未找到相关文章信息","查询失败请重新输入");
        }
    }
    //新增文章
    @PostMapping("add")
    public Result addArticle(@RequestBody Article article){
        try {
            //根据自动Id生成器进行添加
            article.setId(idWorker.nextId()+"");
            Article insertArticle = articleService.add(article);
            return new Result(true,StatusCode.OK,"添加文章成功",insertArticle);
        }catch (Exception e){
            return new Result(false,StatusCode.ERROR,"添加文章失败","请检查后添加");
        }
    }

    //修改文章
    @PutMapping("update/{id}")
    public Result updateArticle(@PathVariable String id,@RequestBody Article article){
        //把传入的id进行设置
        try{
            Article byId = articleService.findById(id);
            System.out.println(byId);
            article.setId(id);
            Article updateArticle = articleService.update(article);
            return new Result(true,StatusCode.OK,"恭喜您修改文章成功",updateArticle);
        }catch (Exception e){
            return new Result(false,StatusCode.ERROR,"Id不存在请重新输入","请重新输入Id");
        }
    }

    //删除文章
    @DeleteMapping("delete/{id}")
    public Result deleteArticle(@PathVariable String id){
        try{
            //先进行查询
            Article byId = articleService.findById(id);
            articleService.deleteById(id);
            return new Result(true,StatusCode.OK,"删除成功","恭喜您删除成功");
        }catch (Exception e) {
            return new Result(false, StatusCode.ERROR, "您要删除的Id不存在", "请重新输入");
        }
    }
}
