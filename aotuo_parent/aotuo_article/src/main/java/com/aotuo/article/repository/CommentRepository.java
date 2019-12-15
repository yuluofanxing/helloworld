package com.aotuo.article.repository;

import com.aotuo.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CommentRepository extends MongoRepository<Comment,String>{
}
