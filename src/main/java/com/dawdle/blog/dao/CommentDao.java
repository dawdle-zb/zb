package com.dawdle.blog.dao;

import com.dawdle.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/7  9:39
 */
@Repository
@Mapper
public interface CommentDao {
    List<Comment> findByBlogIdParentIdNull(@Param("blogId") Long blogId,@Param("blogParentId") long blogParentId);

    List<Comment> findByBlogIdParentIdNotNull(@Param("blogId") Long blogId,@Param("id") Long id);

    List<Comment> findByBlogIdAndReplayId(@Param("blogId") Long blogId,@Param("childId") Long childId);

    int saveComment(Comment comment);

    void deleteComment(Long id);
}
