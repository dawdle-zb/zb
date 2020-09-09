package com.dawdle.blog.dao;

import com.dawdle.blog.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author zhoubin
 * @create 2020/8/30  19:31
 */
@Mapper
@Repository
public interface UserDao {

    User findUserByUsernameAndPassword(@Param("username") String username,@Param("password") String password);
}
