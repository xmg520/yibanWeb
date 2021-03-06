package com.mxz.yiban.controller;

import com.mxz.yiban.pojo.Member;
import com.mxz.yiban.pojo.NoUpload;
import com.mxz.yiban.service.MeberService;
import com.mxz.yiban.utill.JsoupUtill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Controller
public class MemberController {


    @Autowired
    MeberService meberService;
    //查询接口


    @ResponseBody
    @RequestMapping("/saveMem")
    public Map<String,Object> saveMember(String studentId, String name,String ybpasswd,String department){
        Map<String,Object> map = new HashMap<>();
        boolean result = meberService.saveMemBer(studentId,name,ybpasswd,department);
        if (result){
            map.put("state","200");
        }else {
            map.put("state","500");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/updateMem")
    public Map<String,Object> updateMember(Integer id,String account, String name,String passwd,String city,Integer isupload){
        Map<String,Object> map = new HashMap<>();
        if (passwd == null){
            passwd = "123456";
        }
        Member member = new Member(id,account,passwd,name,city,isupload);
        boolean result = meberService.updateMemBer(member);
        if (result){
            map.put("state","200");
        }else {
            map.put("state","500");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/isDel")
    public Map<String,Object> isDel(Integer commentId,Integer isupload){
        Map<String,Object> map = new HashMap<>();
        boolean result = meberService.isDel(commentId,isupload);
        if (result){
            map.put("state","200");
        }else {
            map.put("state","500");
        }
        return map;
    }

    @ResponseBody
    @RequestMapping("/clear")
    public Map<String,Object> clear(Integer commentId){
        Map<String,Object> map = new HashMap<>();
        boolean result = meberService.clear(commentId);
        if (result){
            map.put("state","200");
        }else {
            map.put("state","500");
        }
        return map;
    }


    @ResponseBody
    @RequestMapping("/todalao")
    public String todalao(String username,String city) throws IOException {

        try{
            return JsoupUtill.login(username,city);

        }catch (Exception e){
            return "Applied today";
        }
    }

    @ResponseBody
    @RequestMapping("/reloadEnd")
    public boolean reloadEnd() {
        try {
            List<Member> allUser = this.meberService.findAll(0,100);
            for (Member user:allUser) {
                String acoount = user.getAccount();
                if(JsoupUtill.isUpload(acoount)){
                    user.setIsendupload(0);
                }else {
                    user.setIsendupload(1);
                }
                this.meberService.updateEndMemBer(user);
            }
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @ResponseBody
    @RequestMapping(value = {"/findAllMem"})
    public Map<String,Object> findAllUser(HttpServletRequest request, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "20")int limit, Model model) {
        Map<String,Object> map = new HashMap<>();

        //设置简单反爬，python请求头 或 访问速度过快 提示页面访问过于频繁
        Object visitDate = request.getSession().getAttribute("visitDate");
        // 访问速度过快(请求速度不能超过500毫秒)
        if (visitDate == null){
            long time = System.currentTimeMillis();
            request.getSession().setAttribute("visitDate",Long.valueOf(time));
        }else {
            long time = ((Long) request.getSession().getAttribute("visitDate")).longValue();
            long nowSecond = System.currentTimeMillis();
            long timelen = nowSecond - time;
            if (timelen < 500L){
                map.put("msg", "Web page visits are too frequent");
                return map;
            }
        }
        //请求头为Python
        String header = request.getHeader("User-Agent");
        if (header.contains("python")){
            map.put("msg", "Web page visits are too frequent");
            return map;
        }

        //请求单页数据超过60条
        if (limit > 60){
            map.put("msg", "Web page visits are too frequent");
            return map;
        }

        /**
         * sql 中 LIMIT 后的第一个参数是输出记录的初始位置，第二个参数偏移量
         */
        //limit： startLine 比如第二页 (2 - 1) * 10 = 第十行数据  limit
        int startLine = (page - 1) * limit;
        // count:统计所有数据数量
        long l = this.meberService.dataLogCount();
        List<Member> allUser = this.meberService.findAll(startLine,limit);
        List list = new ArrayList();
        map.put("code",Integer.valueOf(0));
        map.put("msg","");
        map.put("count",Long.valueOf(l));
        map.put("data",allUser);
        model.addAttribute("dataMap",map);
        return map;
    }


}
