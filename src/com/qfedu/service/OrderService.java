package com.qfedu.service;

import com.qfedu.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll(int pageNo, int pageSize, String str);
    int getDataCount(String str);
    int deleteByID(int id);
}
