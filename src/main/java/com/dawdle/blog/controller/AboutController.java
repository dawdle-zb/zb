package com.dawdle.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zhoubin
 * @create 2020/9/7  14:51
 */
@Controller
public class AboutController {


    @GetMapping("/about")
    public String about(){

        return "about";
    }
}
