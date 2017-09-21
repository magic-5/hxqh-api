package com.bjhxqh.common.base.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 通用接口
 */
@Service
public interface IService<T> {

    T selectByKey(Object key);

    T selectByEntity(T entity);

    public int selectCount(T entity);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);

    List<T> selectAll();

    //TODO 其他...
}
