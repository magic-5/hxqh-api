package com.bjhxqh.common.base.service;



import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


public abstract class ServiceSupport<T> implements IService<T> {

    @Autowired
    protected Mapper<T> mapper;

    public Mapper<T> getMapper() {
        return mapper;
    }

    //@Override
    public T selectByKey(Object key) {
        return mapper.selectByPrimaryKey(key);
    }

    public T selectByEntity(T entity) {
        return mapper.selectOne(entity);
    }

    public int selectCount(T entity){
        return mapper.selectCount(entity);
    }

    public int save(T entity) {
        return mapper.insert(entity);
    }

    public int delete(Object key) {
        return mapper.deleteByPrimaryKey(key);
    }

    public int updateAll(T entity) {
        return mapper.updateByPrimaryKey(entity);
    }

    public int updateNotNull(T entity) {
        return mapper.updateByPrimaryKeySelective(entity);
    }

    public List<T> selectByExample(Object example) {
        return mapper.selectByExample(example);
    }

    public List<T> selectAll() {
        return mapper.selectAll();
    }

}
