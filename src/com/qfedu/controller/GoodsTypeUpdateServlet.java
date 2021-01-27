package com.qfedu.controller;

import com.qfedu.dao.impl.GoodsDaoImpl;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.UserService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/GoodsTypeUpdateServlet")
public class GoodsTypeUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String typename = request.getParameter("typename");
        String uid = request.getParameter("id");
        GoodsTypeService goodsType = new GoodsTypeServiceImpl();
        if (uid != null && !"".equals(uid)) {
            int id = Integer.parseInt(uid);
            Object[] obj = {typename, id};
            goodsType.update(obj);
        } else {
            boolean ret = goodsType.selectTypeName(typename);
            System.out.println(ret);
            if (ret) {
                response.getWriter().print("该类型已存在");
            } else {
                Object[] obj = {typename};
                goodsType.Add(obj);
            }
        }
        response.sendRedirect(request.getContextPath() + "/GoodsTypeSelectServlet");
    }
}
