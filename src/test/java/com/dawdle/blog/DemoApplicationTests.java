package com.dawdle.blog;

import com.dawdle.blog.pojo.Comment;
import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.service.CommentService;
import com.dawdle.blog.service.TypeService;
import com.dawdle.blog.util.MD5Utils;
import com.dawdle.blog.vo.FirstPageBlog;
import com.dawdle.blog.vo.ShowBlog;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoApplicationTests {

    @Autowired
    DataSource dataSource;
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;
    @Autowired
    CommentService commentService;

    @Test
    void contextLoads() {
            System.out.println(dataSource.getClass());
    }
    @Test
    public void test(){
        System.out.println(typeService.typeList());
    }
    @Test
    public void test1(){
        List<Comment> commentList = commentService.listCommentByBlogId(2L);
        System.out.println(commentList);
    }
}
