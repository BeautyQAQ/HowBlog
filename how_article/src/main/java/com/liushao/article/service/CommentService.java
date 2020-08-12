package com.liushao.article.service;

import com.liushao.article.pojo.Comment;
import com.liushao.article.repository.CommentRepository;
import com.liushao.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author huangshen
 */
@Service
public class CommentService {
    @Autowired
    private IdWorker idWorker;
    @Autowired
    private CommentRepository commentDao;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Comment findById(String id) {
        return commentDao.findById(id).get();
    }

    public List<Comment> findAll() {
        return commentDao.findAll();
    }

    public void save(Comment comment) {
        String id = idWorker.nextId() + "";
        comment.set_id(id);

        //初始化数据
        comment.setPublishdate(new Date());
        comment.setThumbup(0);

        commentDao.save(comment);
    }

    public void update(Comment comment) {
        commentDao.save(comment);
    }

    public void deleteById(String id) {
        commentDao.deleteById(id);
    }

    /**
     * 根据文章id查询评论
     */
    public List<Comment> findByarticleId(String articleId) {
        return commentDao.findByArticleid(articleId);
    }

    /**
     * 点赞
     */
    public void thumbup(String id) {
        //这个方法需要操作两次数据库,性能较低
        /*//查询评论
        Comment comment = commentDao.findById(id).get();
        //修改点赞数
        comment.setThumbup(comment.getThumbup() + 1);
        commentDao.save(comment);*/

        //优化  修改条件
        Query query = new Query();
        query.addCriteria(Criteria.where("_id").is(id));
        //修改的数据
        Update update = new Update();
        //在原来的基础上加一
        update.inc("thumbup", 1);
        mongoTemplate.updateFirst(query, update, "comment");
    }
}
