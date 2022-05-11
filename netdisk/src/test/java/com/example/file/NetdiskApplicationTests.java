package com.example.file;

import com.example.file.Model.User;
import com.example.file.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NetDiskApplicationTests {
    @Autowired
    private UserMapper userMapper;
    @Test
    void contextLoads() {
        User user=new User();
        user.setUsername("username");
        user.setPassword("password");
        user.setTelephone("tel");

        userMapper.insertUser(user);
        System.out.println("-----结果查询-----");

        List<User> list=userMapper.selectUser();
        list.forEach(System.out::println);
    }

}
