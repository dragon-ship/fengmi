package com.qfedu.service.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.Goods;
import com.qfedu.service.GoodsService;

import java.util.List;

public class GoodsServiceImpl implements GoodsService {
    @Override
    public List<Goods> getAll(int pageNo, int pageSize, String str) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        List<Goods> all = goodsDao.getAll(pageNo, pageSize, str);
        return all;
    }

    @Override
    public int getDataCount(String str) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        int dataCount = goodsDao.getDataCount(str);
        return dataCount;
    }

    @Override
    public Goods getGoodsById(int id) {
        GoodsDaoImpl goodsDao = new GoodsDaoImpl();
        Goods goods = goodsDao.getGoodsById(id);
        return goods;
    }

    @Override
    public int Add(Object[] obj) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        int add = goodsDao.Add(obj);
        return add;
    }

    @Override
    public int update(Object[] obj) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        int update = goodsDao.update(obj);
        return update;
    }

    @Override
    public int delete(int id) {
        GoodsDao goodsDao = new GoodsDaoImpl();
        int delete = goodsDao.delete(id);
        return delete;
    }
}
