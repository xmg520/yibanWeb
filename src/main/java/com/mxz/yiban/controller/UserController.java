package com.mxz.yiban.controller;


import com.mxz.yiban.pojo.NoUpload;
import com.mxz.yiban.service.NoUploadService;
import com.mxz.yiban.service.UserService;
import com.mxz.yiban.utill.JsoupUtill;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private NoUploadService noUploadService;

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/dalao")
    public String dalao(){
        return "admin/todalao";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "login";
    }

    @RequestMapping("/admin/user")
    public String user(){
        return "admin/user";
    }

//    @RequestMapping("/admin/user1")
//    public String user1(){
//        return "/admin/user3";
//    }



    @RequestMapping("/noload")
    public String noload(Model model){
        List<NoUpload> noUploads = noUploadService.findAll();
        model.addAttribute("nloads",noUploads);
        return "admin/badlist";
    }

    /**
     * 登陆认证
     */
    @ResponseBody
    @RequestMapping("/login")
    public  Map<String,Object> login(String userName, String passWord, HttpServletRequest request) {

        Map<String,Object> map = new HashMap<>();

        //1、获取subject
        Subject subject = SecurityUtils.getSubject();

        //2、封装用户数据
        UsernamePasswordToken token = new UsernamePasswordToken(userName,passWord,true);

        //3、执行登录方法

        try {
            //交给Realm处理--->执行它的认证方法
            subject.login(token);
            //登录成功
            if (token.getUsername().equals("root")){
                request.getSession().setAttribute("role","管理员");
            }else {
                request.getSession().setAttribute("role","用户");
            }
            map.put("state",Integer.valueOf(200));
        }catch (UnknownAccountException e){
            //登录失败:用户名不存在
            request.getSession().setAttribute("msg","用户名不存在");
            map.put("state",Integer.valueOf(500));
        }catch (IncorrectCredentialsException e){
            //登录失败：密码错误
            request.getSession().setAttribute("msg","密码错误");
            map.put("state",Integer.valueOf(500));
        }

        return map;

    }




}
