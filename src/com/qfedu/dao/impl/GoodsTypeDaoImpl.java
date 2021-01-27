package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsTypeDao;
import com.qfedu.entity.GoodsType;
import com.qfedu.until.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl extends BaseDao implements GoodsTypeDao {
    @Override
    public List<GoodsType> getAll(int pageNo, int pageSize) {
        String sql = "select * from t_goodstype limit ?,?";
        Object[] obj = {(pageNo-1) * pageSize, pageSize};
        try {
            ResultSet resultSet = super.select(sql, obj);
            ArrayList<GoodsType> list = new ArrayList<>();
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                list.add(goodsType);
            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int getDataCount() {
        String sql = "select count(1) from t_goodstype";
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                count = resultSet.getInt("count(1)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public GoodsType getGoodsTypeById(int id) {
        String sql = "select * from t_goodstype where id = ?";
        Object[] obj = {id};
        try {
            ResultSet select = this.select(sql, obj);
            while(select.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(select.getInt("id"));
                goodsType.setTypename(select.getString("typename"));
                return goodsType;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public GoodsType getGoodsTypeByTypeName(String typename) {
        String sql = "select * from t_goodstype where typename= ?";
        Object[] obj = {typename};
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setId(resultSet.getInt("id"));
                goodsType.setTypename(resultSet.getString("typename"));
                return goodsType;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int Add(Object[] obj) {
        String sql = "insert into t_goodstype (typename) values(?)";
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int update(Object[] obj) {
        String sql = "update t_goodstype set typename=? where id=?";
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int delete(Object[] obj) {
        String sql = "delete from t_goodstype where id = ?";
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public List<GoodsType> All() {
        String sql = "select * from t_goodstype";
        Object[] obj = {};
        List<GoodsType> list = new ArrayList<>();
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                GoodsType goodsType = new GoodsType();
                goodsType.setTypename(resultSet.getString("typename"));
                goodsType.setId(resultSet.getInt("id"));
                list.add(goodsType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public boolean selectTypeName(String typename) {
        boolean flag = false;
        String sql = "select * from t_goodstype where typename=?";
        Object[] obj = {typename};
        try {
            ResultSet resultSet = super.select(sql, obj);
            while(resultSet.next()) {
                flag = true;
            }
            return flag;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

}
