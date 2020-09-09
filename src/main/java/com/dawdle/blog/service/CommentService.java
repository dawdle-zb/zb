package com.dawdle.blog.service;

import com.dawdle.blog.pojo.Comment;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/7  9:31
 */
public interface CommentService {

    List<Comment> listCommentByBlogId(Long blogId);

    int saveComment(Comment comment);

    void deleteComment(Comment comment, Long id);
}
