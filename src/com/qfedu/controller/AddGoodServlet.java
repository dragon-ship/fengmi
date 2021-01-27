package com.qfedu.controller;

import com.qfedu.service.GoodsService;
import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/AddGoodsServlet")
public class AddGoodServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(123);
        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("id");
        String goodsName = request.getParameter("goodsName");
        String price = request.getParameter("price");
        String typeId = request.getParameter("typeId");
        String imgPath = request.getParameter("imgPath");
        String comment = request.getParameter("comment");
        GoodsService goodsService = new GoodsServiceImpl();
        if (s != null && !"".equals(s)) {
            int id = Integer.parseInt(s);
            Object[] obj = {goodsName, price, typeId, imgPath, comment, id};
            goodsService.update(obj);
        } else {
            Object[] obj = {goodsName, price, typeId, imgPath, comment};
            goodsService.Add(obj);
        }
        response.sendRedirect(request.getContextPath() + "/FuzzySelectGoods");
    }
}
