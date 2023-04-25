package com.example.mojocebe.service.Impl;

import com.example.mojocebe.entity.User;
import com.example.mojocebe.mapper.UserMapper;
import com.example.mojocebe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {
        User user = userMapper.login(username, password);
        return user;
    }
    public void register(String username, String password){
        userMapper.register(username,password);
    }

    @Override
    public User find(String username) {
        User user = userMapper.find(username);
        return user;
    }
}
