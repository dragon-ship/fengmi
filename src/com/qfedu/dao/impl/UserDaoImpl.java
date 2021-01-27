package com.qfedu.dao.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.entity.User;
import com.qfedu.until.BaseDao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public List<User> select(int pageNo, int pageSize, String str) {
        String sql = "select * from t_user where 1=1 " + str + " limit ?,?";
        Object[] obj = {(pageNo - 1) * pageSize, pageSize};
        List<User> list = new ArrayList<>();
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setPassword(resultSet.getString("password"));
                user.setPhone(resultSet.getString("phone"));
                user.setUsername(resultSet.getString("username"));
                user.setSex(resultSet.getString("sex"));
                list.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public int getDataCount(String str) {
        String sql = "select count(1) from t_user where 1=1 " + str;
        System.out.println(sql);
        Object[] obj = {};
        int count = 0;
        try {
            ResultSet resultSet = this.select(sql, obj);
            while (resultSet.next()) {
                count = resultSet.getInt("count(1)");
            }
            System.out.println(count);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public int Add(Object[] obj) {
        String sql = "insert into t_user(username, password, phone, sex) values(?, ?, ?, ?)";
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int Delete(int id) {
        String sql = "delete from t_user where id = ?";
        Object[] obj = {id};
        int i = super.setUpdate(sql, obj);
        return i;
    }

    @Override
    public int update(int id) {
        String sql = "update t_user set password = 123456 where id = ?";
        Object[] obj = {id};
        int i = super.setUpdate(sql, obj);
        return i;
    }
}
