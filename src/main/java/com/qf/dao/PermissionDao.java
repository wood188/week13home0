package com.qf.dao;


import com.qf.pojo.Permission;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PermissionDao {
    List<Permission> selectPer(String name);
}
