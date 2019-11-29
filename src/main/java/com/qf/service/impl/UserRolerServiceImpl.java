package com.qf.service.impl;

import com.qf.dao.UserRolerDao;
import com.qf.pojo.UserRoler;
import com.qf.service.UserRolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRolerServiceImpl implements UserRolerService {
    @Autowired
    private UserRolerDao userRolerDao;
    @Override
    public Integer userRolerAdd(UserRoler userRoler) {
        return userRolerDao.userRolerAdd(userRoler);
    }
}
