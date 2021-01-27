package com.qfedu.service.impl;

import com.qfedu.dao.AdminDao;
import com.qfedu.dao.impl.AdminDaoImpl;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;

public class AdminServiceImpl implements AdminService {
    @Override
    public boolean getAdmin(Admin ad) {
        AdminDao adminDao = new AdminDaoImpl();
        boolean admin = adminDao.getAdmin(ad);
        return admin;
    }
}
