package com.qfedu.controller;

import com.qfedu.dao.impl.OrderDaoImpl;
import com.qfedu.entity.Order;
import com.qfedu.service.OrderService;
import com.qfedu.service.impl.OrderServiceImpl;
import com.qfedu.until.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/OrderFuzzySelectServlet")
public class OrderFuzzySelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        String username = request.getParameter("username");
        if (pNo == null) {
            pNo = "1";
        }
        StringBuffer sb = new StringBuffer();
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 6;
        if (username != null && !"".equals(username)) {
            sb.append("and username like '%" + username + "%'");
        }
        String str = sb.toString();
        OrderService orderService = new OrderServiceImpl();
        List<Order> list = orderService.getAll(pageNo, pageSize, str);
        int dataCount = orderService.getDataCount(str);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setDataCount(dataCount);
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("list", list);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("after/order_processing_list.jsp").forward(request, response);
    }
}
