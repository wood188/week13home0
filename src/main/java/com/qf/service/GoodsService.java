package com.qf.service;

import com.qf.pojo.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> goodsFinfAll();
    Goods goodsFindById(Integer gid);
    Integer goodsUpadteById(Goods goods);
    Integer goodsDeleteById(Integer gid);
    Integer goodsAdd(Goods goods);
}
