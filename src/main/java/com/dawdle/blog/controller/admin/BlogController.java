package com.dawdle.blog.controller.admin;

import com.dawdle.blog.pojo.Blog;
import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.pojo.User;
import com.dawdle.blog.service.BlogService;
import com.dawdle.blog.service.TypeService;
import com.dawdle.blog.vo.BlogQuery;
import com.dawdle.blog.vo.SearchBlog;
import com.dawdle.blog.vo.ShowBlog;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  10:18
 */
@RequestMapping("/admin")
@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    @Autowired
    TypeService typeService;

    @GetMapping("/blogs")
    public String blogs(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        String orderBy = "update_time desc";
        PageHelper.startPage(pageNum,5,orderBy);
        List<BlogQuery> bloglist = blogService.blogList();
        model.addAttribute("blogs", bloglist);
        List<Type> typeList = typeService.typeList();
        model.addAttribute("types", typeList);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(bloglist);
        model.addAttribute("page",pageInfo);
        return "admin/blogs";
    }

    @GetMapping("/blogs/input")
    public String input(Model model){
        model.addAttribute("types", typeService.typeList());
        model.addAttribute("blog", new Blog());
        return "admin/blogs-input";
    }

    @PostMapping("/blogs")
    public String post(RedirectAttributes attributes, HttpSession session,Blog blog){
        blog.setUser((User) session.getAttribute("user"));
        blog.setUserId(blog.getUser().getId());
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTypeId(blog.getType().getId());
        int i = blogService.saveBlog(blog);
        if(i == 0){
            attributes.addFlashAttribute("msg", "新增失败");
        }else {
            attributes.addFlashAttribute("msg", "新增成功");
        }

        return "redirect:/admin/blogs";
    }
    @GetMapping("/blogs/{id}/input")
    public String updateInput(@PathVariable Long id,Model model){
        ShowBlog blog = blogService.getBlogById(id);
        model.addAttribute("blog", blog);
        model.addAttribute("types", typeService.typeList());
        return "admin/blogs-input";
    }
    @PostMapping("/blogs/input")
    public String editPost(RedirectAttributes attributes,ShowBlog showBlog){
        int i = blogService.updateBlog(showBlog);
        if(i == 0){
            attributes.addFlashAttribute("msg", "更新失败");
        }else {
            attributes.addFlashAttribute("msg", "更新成功");
        }
        return "redirect:/admin/blogs";
    }

    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        blogService.deleteBlogById(id);
        return "redirect:/admin/blogs";
    }

    @PostMapping("/blogs/search")
    public String search(Model model,SearchBlog searchBlog, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        List<BlogQuery> blogQueries = blogService.searchBlogByAdmin(searchBlog);
        PageHelper.startPage(pageNum, 5);
        PageInfo<BlogQuery> pageInfo = new PageInfo<>(blogQueries);
        model.addAttribute("page", pageInfo);
        return "admin/blogs :: blogList";
    }
}
