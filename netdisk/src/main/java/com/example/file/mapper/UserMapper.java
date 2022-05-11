package com.example.file.mapper;

import com.example.file.Model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    Integer insertUser(User user);
    List<User> selectUser();
}
