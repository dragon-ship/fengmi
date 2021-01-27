package com.qfedu.dao;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderDao {
    List<Order> getAll(int pageNo, int pageSize, String str);
    int getDataCount(String str);
    int deleteByID(int id);
}
