package com.qf.service;


import com.qf.pojo.User;


public interface UserService {
    User selectOne(User user);
    Integer userAdd(User user);
}
