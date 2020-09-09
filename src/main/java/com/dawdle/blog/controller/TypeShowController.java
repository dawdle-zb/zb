package com.dawdle.blog.controller;

import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.service.TypeService;
import com.dawdle.blog.vo.FirstPageBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/6  16:41
 */
@Controller
public class TypeShowController {
    @Autowired
    TypeService typeService;
    @Autowired
    BlogService blogService;

    @GetMapping("/types/{id}")
    public String type(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,
                       @PathVariable Long id){
        List<Type> types = typeService.showAllTypeListAndBlog();
        System.out.println("types = " + types);
        if(id == -1){
            id = types.get(0).getId();
        }
        model.addAttribute("types", types);
        List<FirstPageBlog> blogByTypeId = blogService.getBlogByTypeId(id);
        PageHelper.startPage(pageNum, 1000);
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(blogByTypeId);
        model.addAttribute("page", pageInfo);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
