package com.example.guanli.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class AjaxController {
    @RequestMapping("")
    public String test0(){
        return "ajax-test";
    }

    @RequestMapping(value = "/test1", method = RequestMethod.GET)
    @ResponseBody
    public String test1(@RequestParam("xxx") String info) {
        System.out.printf("接收前端值："+info);
        return "你输入的内容是这个:" + info;
    }
}
