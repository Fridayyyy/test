package com.example.guanli.service.impl;

import com.example.guanli.domain.Article;
import com.example.guanli.domain.UpmsUser;
import com.example.guanli.mapper.UserMapper;
import com.example.guanli.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int save(UpmsUser user){
        return userMapper.save(user);
    }

    public List<UpmsUser> queryPage(Integer startRows){
        return userMapper.queryPage(startRows);
    }
    @Override
    public UpmsUser login(String username, String password){
        return userMapper.login(username,password);
    }

    @Override
    public int allUser(){
        return userMapper.allUser();
    }
    @Override
    public List<UpmsUser> searchUser(String name){
        return userMapper.searchUser(name);
    };

    @Override
    public int hot(UpmsUser user){
        return userMapper.hot(user);
    }


}
