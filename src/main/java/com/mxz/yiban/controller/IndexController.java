package com.mxz.yiban.controller;

import com.mxz.yiban.pojo.User;
import com.mxz.yiban.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IndexController {
    @Autowired
    UserService userService;

//    @RequestMapping(value = {"/login"})
//    public Map<String,Object> login(HttpServletRequest request, String userName, String passWord){
//        Map<String,Object> map = new HashMap<>();
//        map.put("state",Integer.valueOf(500));
//
//        User user = userService.findByName(userName);
//        if ((user.getUsername().equals(userName)) && (user.getPassword().equals(passWord))){
//            map.put("state",Integer.valueOf(200));
//        }
//        return map;
//    }


    //登出账户
    @ResponseBody
    @RequestMapping("/logout")
    public String logout(){
        Subject subject = SecurityUtils.getSubject();

        subject.logout();

        return "OUT ok";
    }

}
