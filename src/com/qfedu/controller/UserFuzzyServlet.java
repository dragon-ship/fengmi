package com.qfedu.controller;

import com.qfedu.entity.User;
import com.qfedu.service.impl.UserServiceImpl;
import com.qfedu.until.PageUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/UserFuzzyServlet")
public class UserFuzzyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String sex = request.getParameter("sex");
        String pNo = request.getParameter("pageNo");
        if (pNo == null) {
            pNo = "1";
        }
        int pageNo = Integer.parseInt(pNo);
        UserServiceImpl userService = new UserServiceImpl();
        PageUtil pageUtil = new PageUtil();
        StringBuffer stringBuffer = new StringBuffer();
        if (username != null && !" ".equals(username) && sex != null && !" ".equals(sex)) {
            stringBuffer.append("and username like '%"+ username +"%' and sex like '%"+ sex +"%'");
        } else if (username != null && !" ".equals(username)) {
            stringBuffer.append("and username like '%"+ username +"%'");
        } else if (sex != null && !" ".equals(sex)) {
            stringBuffer.append("and sex like '%"+ sex +"%'");
        }
        String str = stringBuffer.toString();
        int dataCount = userService.getDataCount(str);
        int pageSize = 6;
        pageUtil.setDataCount(dataCount);
        pageUtil.setPageNo(pageNo);
        pageUtil.setPageSize(pageSize);
        int pageCount = pageUtil.getPageCount();
        List<User> list = userService.select(pageNo, pageSize, str);
        System.out.println(list.size());
        request.setAttribute("list", list);
        request.setAttribute("pageNo", pageNo);
        request.setAttribute("pageCount", pageCount);
        request.getRequestDispatcher("after/user.jsp").forward(request, response);
    }
}
