package com.qfedu.controller;

import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String ordersid = request.getParameter("ordersid");
        int id = Integer.parseInt(ordersid);
        OrderService orderService = new OrderServiceImpl();
        orderService.deleteByID(id);
        response.sendRedirect(request.getContextPath() + "/OrderFuzzySelectServlet");
    }
}
