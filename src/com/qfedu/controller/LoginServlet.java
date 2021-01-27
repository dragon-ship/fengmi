package com.qfedu.controller;

import com.qfedu.dao.impl.AdminDaoImpl;
import com.qfedu.entity.Admin;
import com.qfedu.service.AdminService;
import com.qfedu.service.impl.AdminServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        AdminService adminService = new AdminServiceImpl();
        Admin ad = new Admin(username, password);
        boolean admin = adminService.getAdmin(ad);
        request.getSession().setAttribute("session", username);
        String path = request.getServletContext().getContextPath();
        if (admin) {
            response.sendRedirect(path + "/UserFuzzyServlet");
        } else {
            response.sendRedirect(path + "/after/login.jsp");
        }
    }
}
