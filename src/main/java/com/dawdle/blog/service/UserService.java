package com.dawdle.blog.service;

import com.dawdle.blog.pojo.User;

/**
 * @author zhoubin
 * @create 2020/8/30  19:25
 */
public interface UserService {

    User checkUser(String username, String password);
}
