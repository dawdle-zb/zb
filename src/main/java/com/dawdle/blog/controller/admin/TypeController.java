package com.dawdle.blog.controller.admin;

import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.service.TypeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/5  10:54
 */
@Controller
@RequestMapping("/admin")
public class TypeController {

    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String type(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum, 5);
        List<Type> typeList = typeService.typeList();
        PageInfo pageInfo = new PageInfo(typeList);
        model.addAttribute("page",pageInfo);
        return "admin/types";

    }

    @GetMapping("/types/input")
    public String input(Model model){
        model.addAttribute("type", new Type());
        return "admin/types-input";
    }

    @PostMapping("/types")
    public String post(@Valid Type type, RedirectAttributes attributes){
        Type type1 = typeService.getTypeByName(type.getName());
        if(type1 != null){
            attributes.addFlashAttribute("msg", "添加失败，该分类已存在");
            return "redirect:/admin/types/input";
        }
        int i = typeService.addType(type);
        if (i == 0) {
            attributes.addFlashAttribute("msg", "新增失败");
        } else {
            attributes.addFlashAttribute("msg", "新增成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/input")
    public String editInput(@PathVariable Long id,Model model){
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "admin/types-input";
    }

    @PostMapping("/types/input")
    public String editPost(@Valid Type type,RedirectAttributes attributes){
        int i = typeService.updateType(type.getName());
        if(i == 1){
            attributes.addFlashAttribute("msg", "更新成功");
        }
        return "redirect:/admin/types";
    }

    @GetMapping("/types/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes){
        int i = typeService.deleteType(id);
        attributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/admin/types";
    }
}
