package com.qfedu.dao.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.entity.Admin;
import com.qfedu.until.BaseDao;

import java.sql.ResultSet;

public class AdminDaoImpl extends BaseDao implements AdminDao {
    @Override
    public boolean getAdmin(Admin ad) {
        String sql = "select * from admin where username = ? and password = ?";
        Object[] obj = {ad.getUsername(), ad.getPassword()};
        try {
            ResultSet resultSet = this.select(sql, obj);
            return resultSet.next();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}

