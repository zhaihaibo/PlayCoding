package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
@author  zhaihaibo
@data 2020/3/9 - 18:26
*/
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserByAccount(Integer id) {
        User user = new User();
        user.setId(id);
        User user1 = userMapper.selectByPrimaryKey(user);

        return user1;
    }
}
