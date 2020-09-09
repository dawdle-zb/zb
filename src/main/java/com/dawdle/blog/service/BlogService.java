package com.dawdle.blog.service;

import com.dawdle.blog.pojo.Blog;
import com.dawdle.blog.vo.*;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  14:34
 */
public interface BlogService {
    List<BlogQuery> blogList();

    ShowBlog getBlogById(Long id);

    int updateBlog(ShowBlog showBlog);

    int deleteBlogById(Long id);

    int saveBlog(Blog blog);

    List<BlogQuery> searchBlogByAdmin(SearchBlog searchBlog);

    List<FirstPageBlog> getAllFirstPageBlog();

    List<BlogQuery> recommendBlog();

    List<FirstPageBlog> searchBlogByIndex(String query);

    List<FirstPageBlog> getBlogByTypeId(Long id);

    DetailedBlog getDetailedBlogById(Long id);

    List<BlogQuery> getAllBlog();
}
