package com.qf.dao;

import com.qf.pojo.RolerPerm;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RolerPermDao {
    Integer rolerPermAdd(RolerPerm rolerPerm);
}
