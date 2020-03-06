package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> getAll() {
        return userMapper.selectAll();
    }

    @Cacheable(cacheNames = {"emp"})   //当前查询运用了缓存
    @Override
    public User getUserById(Integer id) {
        User user = userMapper.selectByPrimaryKey(id);
        return  user;
    }

    @Override
    public int insertUser(User user) {

        int insert = userMapper.insert(user);
        return insert;
    }

    @Override
    public int deleteById(String id) {
        User user = new User();
        user.setId(Integer.parseInt(id));
        int delete = userMapper.delete(user);
        return delete;
    }


}
