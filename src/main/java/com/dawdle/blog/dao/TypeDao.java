package com.dawdle.blog.dao;

import com.dawdle.blog.pojo.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  15:39
 */
@Mapper
@Repository
public interface TypeDao {

    List<Type> getTypeList();

    Type getTypeById(Long id);

    int addType(Type type);

    Type getTypeByName(String name);

    int updateType(String name);

    int deleteTypeById(Long id);

    List<Type> showAllTypeListAndBlog();
}
