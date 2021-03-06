package com.qfedu.dao;

import com.qfedu.entity.Goods;

import java.util.List;

public interface GoodsDao {
    List<Goods> getAll(int pageNo, int pageSize, String str);
    int getDataCount(String str);
    Goods getGoodsById(int id);
    public int Add(Object[] obj);
    public int update(Object[] obj);
    public int delete(int id);
}
