package com.qfedu.service.impl;

import com.qfedu.dao.UserDao;
import com.qfedu.dao.impl.UserDaoImpl;
import com.qfedu.entity.User;
import com.qfedu.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> select(int pageNo, int pageSize, String str) {
        UserDao userDao = new UserDaoImpl();
        List<User> list = userDao.select(pageNo, pageSize, str);
        return list;
    }

    @Override
    public int getDataCount(String str) {
        UserDao userDao = new UserDaoImpl();
        int dataCount = userDao.getDataCount(str);
        return dataCount;
    }

    @Override
    public int Add(Object[] obj) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.Add(obj);
        return i;
    }

    @Override
    public int Delete(int id) {
        UserDao userDao = new UserDaoImpl();
        int i = userDao.Delete(id);
        return i;
    }

    @Override
    public int update(int id) {
        UserDao userDao = new UserDaoImpl();
        int update = userDao.update(id);
        return update;
    }
}
