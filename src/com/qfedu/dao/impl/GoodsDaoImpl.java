package com.qfedu.dao.impl;

import com.qfedu.dao.GoodsDao;
import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.until.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpl extends BaseDao implements GoodsDao {
    @Override
    public List<Goods> getAll(int pageNo, int pageSize, String str) {
        String sql = "select * from t_goods inner join t_goodstype on t_goods.typeId = t_goodstype.id where 1=1 " + str +" limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize , pageSize};
        List<Goods> list = new ArrayList<>();
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setId(resultSet.getInt("id"));
                goods.setDescription(resultSet.getString("comment"));
                goods.setDeployDate(resultSet.getDate("deployDate"));
                goods.setGoodsName(resultSet.getString("goodsName"));
                goods.setImgPath(resultSet.getString("imgPath"));
                goods.setTypename(resultSet.getString("typename"));
                goods.setPrice(resultSet.getDouble("price"));
                goods.setScore(resultSet.getInt("score"));
                goods.setTypeId(resultSet.getInt("typeId"));
                list.add(goods);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getDataCount(String str) {
        String sql = "select count(1) from t_goods inner join t_goodstype on t_goods.typeId = t_goodstype.id  where 1=1 " + str;
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet select = super.select(sql, obj);
            while (select.next()) {
                int dataCount = select.getInt("count(1)");
                count = dataCount;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public Goods getGoodsById(int id) {
        String sql = "select * from t_goods where id=?";
        Object[] obj = {id};
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                Goods goods = new Goods();
                goods.setId(resultSet.getInt("id"));
                goods.setDescription(resultSet.getString("comment"));
                goods.setDeployDate(resultSet.getDate("deployDate"));
                goods.setGoodsName(resultSet.getString("goodsName"));
                goods.setImgPath(resultSet.getString("imgPath"));
                goods.setPrice(resultSet.getDouble("price"));
                goods.setScore(resultSet.getInt("score"));
                goods.setTypeId(resultSet.getInt("typeId"));
                return goods;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int Add(Object[] obj) {
        String sql = "insert into t_goods(goodsName, price, typeId, imgPath, comment) values(?,?,?,?,?)";
        int add = super.setUpdate(sql, obj);
        return add;
    }

    @Override
    public int update(Object[] obj) {
        String sql = "update t_goods set goodsName=? , price=?, typeId=?, imgPath=?, comment=? where id=?";
        int update = super.setUpdate(sql, obj);
        return update;
    }

    @Override
    public int delete(int id) {
        String sql = "delete from t_goods where id = ?";
        Object[] obj = {id};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
