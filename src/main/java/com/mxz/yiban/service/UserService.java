package com.mxz.yiban.service;


import com.mxz.yiban.pojo.User;

public interface UserService {
    User findById(Integer id);

    User findByName(String username);
}
