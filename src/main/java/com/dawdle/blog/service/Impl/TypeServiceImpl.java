package com.dawdle.blog.service.Impl;

import com.dawdle.blog.dao.TypeDao;
import com.dawdle.blog.pojo.Type;
import com.dawdle.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author zhoubin
 * @create 2020/9/1  15:37
 */
@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    TypeDao typeDao;

    @Override
    public List<Type> typeList() {
        return typeDao.getTypeList();
    }

    @Override
    public Type getType(Long id) {
        return typeDao.getTypeById(id);
    }

    @Transactional
    @Override
    public int addType(Type type) {
        return typeDao.addType(type);
    }

    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(String name) {
        return typeDao.updateType(name);
    }

    @Transactional
    @Override
    public int deleteType(Long id) {
        return typeDao.deleteTypeById(id);
    }

    @Override
    public List<Type> showAllTypeListAndBlog() {
        return typeDao.showAllTypeListAndBlog();
    }

}
