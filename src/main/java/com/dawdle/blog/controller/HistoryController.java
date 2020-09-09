package com.dawdle.blog.controller;

import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.vo.BlogQuery;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/7  12:37
 */
@Controller
public class HistoryController {
    @Autowired
    BlogService blogService;

    @GetMapping("/history")
    public String history(Model model){
        List<BlogQuery> blogQueryList = blogService.getAllBlog();
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueryList);
        model.addAttribute("blogs", blogQueryList);
        model.addAttribute("page", pageInfo);
        return "history";
    }
}
