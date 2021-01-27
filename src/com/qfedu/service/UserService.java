package com.qfedu.service;

import com.qfedu.entity.User;

import java.util.List;

public interface UserService {
    public List<User> select(int pageNo, int pageSize, String str);
    public int getDataCount(String str);
    public int Add(Object[] obj);
    public int Delete(int id);
    public int update(int id);
}
