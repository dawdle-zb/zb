package com.dawdle.blog.controller;

import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.service.TypeService;
import com.dawdle.blog.vo.BlogQuery;
import com.dawdle.blog.vo.DetailedBlog;
import com.dawdle.blog.vo.FirstPageBlog;
import com.dawdle.blog.vo.ShowBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


/**
 * @author zhoubin
 * @create 2020/9/6  10:47
 */
@Controller
public class IndexController {
    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/")
    public String index(@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,Model model){
        PageHelper.startPage(pageNum, 10);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("page", pageInfo);
        model.addAttribute("types", typeService.typeList());
        model.addAttribute("recommendBlogs", blogService.recommendBlog());
        return "index";
    }

    @PostMapping("/search")
    public String search(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                         @RequestParam String query){
        PageHelper.startPage(pageNum, 1000);
        List<FirstPageBlog> firstPageBlogs = blogService.searchBlogByIndex(query);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(firstPageBlogs);
        model.addAttribute("query", query);
        model.addAttribute("page", pageInfo);
        return "search";
    }

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable Long id, Model model){
        DetailedBlog blogById = blogService.getDetailedBlogById(id);
        model.addAttribute("blog", blogById);
        return "blog";
    }
}
