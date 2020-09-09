package com.dawdle.blog.dao;

import com.dawdle.blog.pojo.Blog;
import com.dawdle.blog.vo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  14:38
 */
@Mapper
@Repository
public interface BlogDao {

    List<BlogQuery> getBlogList();

    int saveBlog(Blog blog);

    ShowBlog getBlogById(Long id);

    int updateBlog(ShowBlog showBlog);

    int deleteBlogById(Long id);

    List<BlogQuery> searchBlogByAdmin(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<BlogQuery> recommendBlogs();

    List<FirstPageBlog> searchBlog(String query);

    List<FirstPageBlog> getBlogByTypeId(Long id);

    DetailedBlog getDetailBlogById(Long id);

    int updateView(Long id);

    List<BlogQuery> getAll();
}
