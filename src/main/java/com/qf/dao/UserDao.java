package com.qf.dao;

import com.qf.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    User selectOne(User user);
    Integer userAdd(User user);
}
