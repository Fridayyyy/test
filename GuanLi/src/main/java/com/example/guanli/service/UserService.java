package com.example.guanli.service;

import com.example.guanli.domain.UpmsUser;

import java.util.List;


public interface UserService {
    int save(UpmsUser user);

    List<UpmsUser> queryPage(Integer startRows);

    UpmsUser login(String username, String password);

    int allUser();

    List<UpmsUser> searchUser(String name);

    int hot(UpmsUser user);
}
