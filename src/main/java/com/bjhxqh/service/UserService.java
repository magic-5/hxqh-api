package com.bjhxqh.service;

import com.bjhxqh.mybatis.mapper.UserMapper;
import com.bjhxqh.mybatis.model.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public Optional<User> getUserByID(Long id) {
        return Optional.ofNullable(userMapper.selectByPrimaryKey(id));
    }

    public Optional<User> getUserByName(String name) {
        User user = new User();
        user.setAccount(name);
        return Optional.ofNullable(userMapper.selectOne(user));
    }

    public List<User> getAll(int page) {
        PageHelper.startPage(page, 10);
        return userMapper.selectAll();
    }

    public int getTotalPage() {
        int count = userMapper.selectCount(new User());
        count = (count % 10 == 0) ? (count / 10) : (count / 10 + 1);
        return count;
    }

    @Transactional
    public boolean addUser(User user) {
        return userMapper.insert(user) > 0;
    }

    @Transactional
    public boolean modifyUserById(User user) {
        return userMapper.updateByPrimaryKey(user) > 0;
    }

    @Transactional
    public boolean deleteUserById(Long id) {
        return userMapper.deleteByPrimaryKey(id) > 0;
    }
}