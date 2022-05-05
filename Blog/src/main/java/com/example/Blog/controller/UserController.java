package com.example.guanli.controller;

import com.example.guanli.domain.Article;
import com.example.guanli.domain.Message;
import com.example.guanli.domain.UpmsUser;
import com.example.guanli.service.PageService;
import com.example.guanli.service.impl.PageServiceImpl;
import com.example.guanli.service.impl.UserServiceImpl;
import com.example.guanli.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private PageServiceImpl pageService;
    @Autowired
    private RedisUtil redisUtil;
    //首页
    @RequestMapping("/index")
    public String index(Integer pageN, Model model){
        int pageNow=pageN==null?1:pageN;
        int maxPage=pageService.getAllArticle();
        int pageSize=2;
        int maxA=maxPage%pageSize==0?maxPage/pageSize:maxPage/pageSize+1;

        pageNow=Math.min(pageNow,maxA);


        int start=pageSize*(pageNow-1);
        List<Article> articles=pageService.queryArticle(start);
        model.addAttribute("maxA",maxA);
        model.addAttribute("articles",articles);
        model.addAttribute("pageNowA",pageNow);
        return "index";
    }

    //登录
    @RequestMapping("/login")
    public String login(){
        SimpleDateFormat simpleDateFormat =new SimpleDateFormat("yyyy年MM月dd日HH时mm分ss秒");
        System.out.println("login time"+simpleDateFormat.format(new Date()));
        return "userLogin";
    }

    @RequestMapping("/resultL")
    @ResponseBody
    public Map<String,Object> login(HttpServletRequest request,
                                    HttpServletResponse response,
                                    HttpSession session){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username+"\t"+password+"\t");

        UpmsUser user = userService.login(username,password);
        System.out.println("正在调用controller");
        Map<String,Object> map=new HashMap<String,Object>();
        if (user!=null){
            map.put("status","y");
            session.setAttribute("loginUser",user.getUsername());
            session.setAttribute("loginId",user.getUserId());

        }else {
            map.put("status","n");
        }
        return map;
    }
    //添加用户
    @RequestMapping("/save")
    public String register(UpmsUser user){
        return "userRegister";
    }
    @RequestMapping("/saveResult")
    @ResponseBody
    public int Register(HttpServletRequest request){
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        String password2=request.getParameter("password2");
        System.out.println(username);
        if (password.equals(password2)){
            UpmsUser user=new UpmsUser();
            user.setUsername(username);
            user.setPassword(password);
            int res= userService.save(user);
            return res;
        } else {
            return 0;
        }
    }

    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:/login";
    }



    //分页
    @RequestMapping("/page")
    public String page(Integer page, Model model){

        int pageNow=page==null?1:page;

        int maxNum = userService.allUser();

        int pageSize=5;

        int max=maxNum%pageSize==0?maxNum/pageSize:maxNum/pageSize+1;

        System.out.println(maxNum);
        int startRows = pageSize*(pageNow-1);
        List<UpmsUser> list=userService.queryPage(startRows);

        pageNow=Math.min(max,pageNow);

        model.addAttribute("team",list);
        model.addAttribute("pageNow",pageNow);
        model.addAttribute("max",max);

        return "userList";
    }

    @RequestMapping("/list")
    public String page(String pa){
        return "userList";
    }

    @GetMapping("/search")
    public String tosearch(Model model){
        model.addAttribute("message",new Message());
        return "userSearch1";
    }

    @PostMapping("/search")
    public String search(@ModelAttribute(value = "message") Message message,
                         Model model
                         ){
                        // HttpServletRequest request


        //String name=request.getParameter("name");
        String name=message.getName();
        System.out.println(name);

        List<UpmsUser> users=userService.searchUser(name);
        model.addAttribute("users",users);
        return "userSearch";
    }

    @RequestMapping("/file")
    public String file(){
        return "fileUpload";
    }

    @RequestMapping("/file/upload")
    @ResponseBody
    public String upload(@RequestParam("file")MultipartFile file){
        String fileName=file.getOriginalFilename();
        String filePath="C:\\Users\\c\\Desktop\\upload";
        fileName=filePath+ UUID.randomUUID()+fileName;
        File dest=new File(fileName);
        if (!dest.getParentFile().exists()){
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        }catch (Exception e){
            e.printStackTrace();
        }
        return "上传失败";
    }
}
