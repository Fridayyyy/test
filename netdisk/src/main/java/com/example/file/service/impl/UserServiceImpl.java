package com.example.file.service.impl;

import com.example.file.Model.User;
import com.example.file.common.RestResult;
import com.example.file.mapper.UserMapper;
import com.example.file.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public RestResult<String> registerUser(User user){
        String telephone=user.getTelephone();
        String password=user.getPassword();
        if (!StringUtils.hasLength(telephone)||!StringUtils.hasLength(password)){
            return RestResult.fail().message("手机号码不能为空");
        }

        if (isTelPhoneExit(telephone)){
            return RestResult.fail().message("手机号已存在");
        }

        int result=userMapper.insertUser(user);
        if (result==1){
            return RestResult.success();
        }else {
            return RestResult.fail().message("注册失败");
        }
    }
    private boolean isTelPhoneExit(String telephone){
        return false;
    }

    @Override
    public RestResult<User> login(User user){
        //String telephone = user.getTelephone();
        //String password=user.getPassword();
        return RestResult.success();
    }
}
