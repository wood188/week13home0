package com.qf.dao;

import com.qf.pojo.UserRoler;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRolerDao {
    Integer userRolerAdd(UserRoler userRoler);
}
