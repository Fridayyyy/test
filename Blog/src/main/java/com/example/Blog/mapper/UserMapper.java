package com.example.guanli.mapper;

import com.example.guanli.domain.UpmsUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper {
    int save(UpmsUser user);

    List<UpmsUser> queryPage(Integer startRows);

    UpmsUser login(@Param("username") String username, @Param("password") String password);

    int allUser();

    List<UpmsUser> searchUser(String name);

    int hot(UpmsUser user);
}

