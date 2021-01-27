package com.qfedu.controller;

import com.qfedu.service.impl.GoodsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/DeleteGoodsServlet")
public class DeleteGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String goodsid = request.getParameter("goodsid");
        String[] split = goodsid.split(",");
        GoodsServiceImpl goodsService = new GoodsServiceImpl();
        for (String s : split) {
            if(!"".equals(s)){
                int id = Integer.parseInt(s);
                goodsService.delete(id);
            }
        }
        response.sendRedirect(request.getContextPath() + "/FuzzySelectGoods");
    }
}
