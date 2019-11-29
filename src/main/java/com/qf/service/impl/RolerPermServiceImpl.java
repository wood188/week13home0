package com.qf.service.impl;

import com.qf.dao.RolerPermDao;
import com.qf.pojo.RolerPerm;
import com.qf.service.RolerPermService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolerPermServiceImpl implements RolerPermService {
    @Autowired
    private RolerPermDao rolerPermDao;
    @Override
    public Integer rolerPermAdd(RolerPerm rolerPerm) {
        return rolerPermDao.rolerPermAdd(rolerPerm);
    }
}
