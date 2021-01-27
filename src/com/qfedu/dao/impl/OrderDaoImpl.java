package com.qfedu.dao.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.entity.Order;
import com.qfedu.until.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public List<Order> getAll(int pageNo, int pageSize, String str) {
        String sql = "select * from t_order inner join t_status on t_order.status = t_status.id" +
                " inner join t_user on t_order.uid=t_user.id where 1 = 1 " + str + " limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        ArrayList<Order> list = new ArrayList<>();
        try {
            ResultSet resultSet = super.select(sql, obj);
            while (resultSet.next()) {
                Order order = new Order();
                order.setId(resultSet.getInt("id"));
                order.setCreateDate(resultSet.getDate("createDate"));
                order.setOrder_status(resultSet.getString("order_status"));
                order.setOrderCode(resultSet.getString("orderCode"));
                order.setTotalPrice(resultSet.getString("totalPrice"));
                order.setUsername(resultSet.getString("username"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getDataCount(String str) {
        int count = 0;
        String sql = "select count(1) from t_order inner join t_status on t_order.status = t_status.id" +
                " inner join t_user on t_order.uid=t_user.id where 1 = 1 " + str;
        Object[] obj = {};
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
    public int deleteByID(int id) {
        String sql = "delete from t_order where id = ?";
        Object[] obj = {id};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
