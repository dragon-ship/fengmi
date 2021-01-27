package com.qfedu.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        String requestURI = ((HttpServletRequest) req).getRequestURI();
        HttpSession session = ((HttpServletRequest) req).getSession(false);
        if (requestURI.endsWith("login.jsp") || requestURI.endsWith("LoginServlet")) {
            chain.doFilter(req, resp);
        } else if (session != null && session.getAttribute("session") != null) {
            chain.doFilter(req, resp);
        } else if (session == null) {
            ((HttpServletResponse)resp).sendRedirect(((HttpServletRequest) req).getContextPath() +"/after/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
