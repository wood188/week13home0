package com.qf.service.impl;

import com.qf.dao.PermissionDao;
import com.qf.pojo.Permission;
import com.qf.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<Permission> selectPer(String name) {
        return permissionDao.selectPer(name);
    }
}
