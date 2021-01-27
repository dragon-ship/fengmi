package com.qfedu.service.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.dao.impl.GoodsTypeDaoImpl;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;

import java.util.List;

public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Override
    public List<GoodsType> getAll(int pageNo, int pageSize) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> list = goodsTypeDao.getAll(pageNo, pageSize);
        return list;
    }

    @Override
    public int getDataCount() {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        int dataCount = goodsTypeDao.getDataCount();
        return dataCount;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        GoodsType goodsTypeById = goodsTypeDao.getGoodsTypeById(id);
        return goodsTypeById;
    }

    @Override
    public int Add(Object[] obj) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.Add(obj);
        return i;
    }

    @Override
    public int update(Object[] obj) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.update(obj);
        return i;
    }

    @Override
    public int delete(Object[] obj) {
        GoodsTypeDaoImpl goodsTypeDao = new GoodsTypeDaoImpl();
        int i = goodsTypeDao.delete(obj);
        return i;
    }

    @Override
    public List<GoodsType> All() {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        List<GoodsType> all = goodsTypeDao.All();
        return all;
    }

    @Override
    public GoodsType getGoodsTypeByTypeName(String typename) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        GoodsType goodsType = goodsTypeDao.getGoodsTypeByTypeName(typename);
        return goodsType;
    }

    @Override
    public boolean selectTypeName(String typename) {
        GoodsTypeDao goodsTypeDao = new GoodsTypeDaoImpl();
        boolean ret = goodsTypeDao.selectTypeName(typename);
        return ret;
    }

}
