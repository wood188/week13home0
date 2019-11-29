package com.qf.dao;

import com.qf.pojo.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDao {
    List<Goods> goodsFinfAll();
    Goods goodsFindById(Integer gid);
    Integer goodsUpadteById(Goods goods);
    Integer goodsDeleteById(Integer gid);
    Integer goodsAdd(Goods goods);
}
