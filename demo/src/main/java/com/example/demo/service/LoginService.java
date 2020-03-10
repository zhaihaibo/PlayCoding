package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Repository;

/*
@author  zhaihaibo
@data 2020/3/9 - 18:26
*/
@Repository
public interface LoginService {
    User getUserByAccount(Integer id);
}
