package com.qf.service.impl;

import com.qf.dao.GoodsDao;
import com.qf.pojo.Goods;
import com.qf.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GoodsServcieImpl implements GoodsService {
    @Autowired
    private GoodsDao goodsDao;
    @Override
    public List<Goods> goodsFinfAll() {
        return goodsDao.goodsFinfAll();
    }

    @Override
    public Goods goodsFindById(Integer gid) {
        return goodsDao.goodsFindById(gid);
    }

    @Override
    public Integer goodsUpadteById(Goods goods) {
        return goodsDao.goodsUpadteById(goods);
    }

    @Override
    public Integer goodsDeleteById(Integer gid) {
        return goodsDao.goodsDeleteById(gid);
    }

    @Override
    public Integer goodsAdd(Goods goods) {
        return goodsDao.goodsAdd(goods);
    }
}
