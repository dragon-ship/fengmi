package com.qfedu.service;

import com.qfedu.entity.GoodsType;

import java.util.List;

public interface GoodsTypeService {
    public List<GoodsType> getAll(int pageNo, int pageSize);
    public int getDataCount();
    public GoodsType getGoodsTypeById(int id);
    public int Add(Object[] obj);
    public int update(Object[] obj);
    public int delete(Object[] obj);
    List<GoodsType> All();
    GoodsType getGoodsTypeByTypeName(String typename);
    boolean selectTypeName(String typename);
}
