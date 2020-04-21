package com.mxz.yiban.service.impl;


import com.mxz.yiban.dao.UserDao;
import com.mxz.yiban.pojo.User;
import com.mxz.yiban.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public User findByName(String username) {
        return userDao.findByName(username);
    }
}
