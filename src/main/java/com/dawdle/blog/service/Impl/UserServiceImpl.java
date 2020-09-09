package com.dawdle.blog.service.Impl;

import com.dawdle.blog.dao.UserDao;
import com.dawdle.blog.pojo.User;
import com.dawdle.blog.service.UserService;
import com.dawdle.blog.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author zhoubin
 * @create 2020/8/30  19:29
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserDao userDao;

    @Override
    public User checkUser(String username, String password) {
        String codePassword = MD5Utils.code(password);
        return userDao.findUserByUsernameAndPassword(username,codePassword);
    }
}
