package com.qfedu.controller;

import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.until.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/GoodsTypeSelectServlet")
public class GoodsTypeSelectServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 6;
        GoodsTypeService goodsTypeService = new GoodsTypeServiceImpl();
        List<GoodsType> list = goodsTypeService.getAll(pageNo, pageSize);
        int dataCount = goodsTypeService.getDataCount();
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageNo(pageNo);
        pageUtil.setDataCount(dataCount);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("after/goods_type_list.jsp").forward(request, response);
    }
}
