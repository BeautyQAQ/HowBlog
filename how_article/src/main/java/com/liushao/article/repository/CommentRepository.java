package com.liushao.article.repository;

import com.liushao.article.pojo.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;


/**
 * @author huangshen
 */
public interface CommentRepository extends MongoRepository<Comment, String> {
    /**
     * 根据文章id查询评论列表
     */
    List<Comment> findByArticleid(String articleId);
}
