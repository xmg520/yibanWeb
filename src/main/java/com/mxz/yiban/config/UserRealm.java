package com.mxz.yiban.config;

import com.mxz.yiban.pojo.User;
import com.mxz.yiban.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    /**
     * 执行授权逻辑
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        System.out.println("执行授权逻辑");
        //给资源进行授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //获取当前登录用户
        Subject subject = SecurityUtils.getSubject();
        User user = (User) subject.getPrincipal();
        System.out.println(subject.getPrincipal());
        User dbUser = userService.findById(user.getId());

        //获取数据库权限
        String[] dbUsers = dbUser.getPerms().split(";");
        for (String db:dbUsers){
            info.addStringPermission(db);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        System.out.println("执行认证逻辑");

        //编写shiro判断逻辑，判断用户名和密码
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;

        User user = userService.findByName(token1.getUsername());

        //1、判断用户名
        if (user == null){
            //用户名不存在
            return null; //shiro底层会抛出UnKnowAccountException
        }

        //2、判断密码, 这里的user是principal
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
