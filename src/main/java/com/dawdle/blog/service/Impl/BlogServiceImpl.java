package com.dawdle.blog.service.Impl;

import com.dawdle.blog.dao.BlogDao;
import com.dawdle.blog.pojo.Blog;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.util.MarkdownUtils;
import com.dawdle.blog.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  14:37
 */
@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    BlogDao blogDao;

    @Override
    public List<BlogQuery> blogList() {
        return blogDao.getBlogList();
    }

    @Override
    public ShowBlog getBlogById(Long id) {
        return blogDao.getBlogById(id);
    }
    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateTime(new Date());
        blog.setUpdateTime(new Date());
        blog.setView(0);
        return blogDao.saveBlog(blog);
    }

    @Transactional
    @Override
    public int updateBlog(ShowBlog showBlog) {
        showBlog.setUpdateTime(new Date());
        return blogDao.updateBlog(showBlog);
    }
    @Transactional
    @Override
    public int deleteBlogById(Long id) {
        return blogDao.deleteBlogById(id);
    }

    @Override
    public List<BlogQuery> searchBlogByAdmin(SearchBlog searchBlog) {
        return blogDao.searchBlogByAdmin(searchBlog);
    }

    @Override
    public List<FirstPageBlog> getAllFirstPageBlog() {
        return blogDao.getAllFirstPageBlog();
    }

    @Override
    public List<BlogQuery> recommendBlog() {
        return blogDao.recommendBlogs();
    }

    @Override
    public List<FirstPageBlog> searchBlogByIndex(String query) {
        return blogDao.searchBlog(query);
    }

    @Override
    public List<FirstPageBlog> getBlogByTypeId(Long id) {
        return blogDao.getBlogByTypeId(id);
    }

    @Override
    public DetailedBlog getDetailedBlogById(Long id) {
        DetailedBlog blogById = blogDao.getDetailBlogById(id);
        String content = blogById.getContent();
        blogById.setContent(MarkdownUtils.markdownToHtmlExtensions(content));
        blogDao.updateView(id);
        return blogById;
    }

    @Override
    public List<BlogQuery> getAllBlog() {
        return blogDao.getAll();
    }
}
