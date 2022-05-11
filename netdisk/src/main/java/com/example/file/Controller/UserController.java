package com.example.file.Controller;

import com.example.file.common.RestResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping(value = "/test1")
    @ResponseBody
    public RestResult test1(){
        return RestResult.success();
    }

    @GetMapping(value = "test2")
    @ResponseBody
    public RestResult test2(){
        return RestResult.fail();
    }

    @GetMapping(value = "test3")
    @ResponseBody
    public RestResult test3(){
        String s=null;
        int i = s.length();
        return RestResult.success();
    }
}
