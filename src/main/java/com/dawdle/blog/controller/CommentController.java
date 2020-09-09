package com.dawdle.blog.controller;

import com.dawdle.blog.pojo.Comment;
import com.dawdle.blog.pojo.User;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.service.CommentService;
import com.dawdle.blog.vo.DetailedBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/7  9:31
 */
@Controller
public class CommentController {

    @Autowired
    CommentService commentService;
    @Autowired
    BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments/{blogId}")
    public String listComment(@PathVariable Long blogId, Model model){
        List<Comment> commentList = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", commentList);
        return "blog :: commentList";
    }

    @PostMapping("/comments")
    public String postComments(Comment comment, HttpSession session,Model model){
        Long blogId = comment.getBlogId();
        User user = (User) session.getAttribute("user");
        if(user != null){
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        }else{
            comment.setAvatar(avatar);
        }
        if(comment.getParentComment().getId() != null){
            comment.setParentCommentId(comment.getParentComment().getId());
        }
        commentService.saveComment(comment);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("comments", comments);
        return "blog :: commentList";
    }

    @GetMapping("comment/{blogId}/{id}/delete")
    public String delete(@PathVariable Long blogId,@PathVariable long id,Comment comment,Model model){
        commentService.deleteComment(comment,id);
        DetailedBlog detailedBlogById = blogService.getDetailedBlogById(blogId);
        List<Comment> comments = commentService.listCommentByBlogId(blogId);
        model.addAttribute("blog", detailedBlogById);
        model.addAttribute("comments", comments);
        return "blog";
    }

}
