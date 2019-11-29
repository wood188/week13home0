package com.qf.service;

import com.qf.pojo.Permission;

import java.util.List;

public interface PermissionService {
    List<Permission> selectPer(String name);
}
