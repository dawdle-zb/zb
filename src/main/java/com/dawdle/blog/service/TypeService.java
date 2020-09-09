package com.dawdle.blog.service;

import com.dawdle.blog.pojo.Type;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  15:35
 */
public interface TypeService {
    List<Type> typeList();

    Type getType(Long id);

    int addType(Type type);

    Type getTypeByName(String name);

    int updateType(String name);

    int deleteType(Long id);

    List<Type> showAllTypeListAndBlog();
}
