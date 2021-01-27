package com.qfedu.dao;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    public List<GoodsType> getAll(int pageNo, int pageSize);
    public int getDataCount();
    GoodsType getGoodsTypeById(int id);
    GoodsType getGoodsTypeByTypeName(String typename);
    public int Add(Object[] obj);
    public int update(Object[] obj);
    public int delete(Object[] obj);
    List<GoodsType> All();
    boolean selectTypeName(String typename);
}
