package com.qfedu.service.impl;

import com.qfedu.dao.OrderDao;
import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public List<Order> getAll(int pageNo, int pageSize, String str) {
        OrderDao orderDao = new OrderDaoImpl();
        List<Order> list = orderDao.getAll(pageNo, pageSize, str);
        return list;
    }

    @Override
    public int getDataCount(String str) {
        OrderDao orderDao = new OrderDaoImpl();
        int dataCount = orderDao.getDataCount(str);
        return dataCount;
    }

    @Override
    public int deleteByID(int id) {
        OrderDao orderDao = new OrderDaoImpl();
        int i = orderDao.deleteByID(id);
        return i;
    }
}
