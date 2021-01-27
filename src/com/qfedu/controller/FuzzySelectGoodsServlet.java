package com.qfedu.controller;

import com.qfedu.entity.Goods;
import com.qfedu.entity.GoodsType;
import com.qfedu.service.GoodsService;
import com.qfedu.service.GoodsTypeService;
import com.qfedu.service.impl.GoodsServiceImpl;
import com.qfedu.service.impl.GoodsTypeServiceImpl;
import com.qfedu.until.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.List;

@WebServlet("/FuzzySelectGoods")
public class FuzzySelectGoodsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String pNo = request.getParameter("pageNo");
        String goodsname = request.getParameter("goodsname");
        String deployDate = request.getParameter("deployDate");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        int pageSize = 6;
        StringBuffer buffer = new StringBuffer();
        if (goodsname != null && !"".equals(goodsname)) {
           buffer.append("and goodsName like '%"+ goodsname +"%'");
       } else if (deployDate != null && !"".equals(deployDate)) {
            buffer.append("and deployDate like '%"+ deployDate +"%'");
        } else if (goodsname != null && !"".equals(goodsname) && deployDate != null && !"".equals(deployDate)) {
            buffer.append("and goodsName like '%"+ goodsname +"%' and deployDate like '%"+ deployDate +"%'");
        }
        String str = buffer.toString();
        GoodsService goodsService = new GoodsServiceImpl();
        List<Goods> list = goodsService.getAll(pageNo, pageSize, str);
        int dataCount = goodsService.getDataCount(str);
        PageUtil pageUtil = new PageUtil();
        pageUtil.setDataCount(dataCount);
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        request.setAttribute("list",list);
        request.setAttribute("pageNo",pageNo);
        request.setAttribute("pageCount",pageCount);
        request.getRequestDispatcher("after/goods_list.jsp").forward(request, response);
    }
}
