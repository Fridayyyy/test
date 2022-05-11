package com.example.file.service;

import com.example.file.Model.User;
import com.example.file.common.RestResult;

public interface UserService {
    RestResult<String> registerUser(User user);
    RestResult<User> login(User user);
}
