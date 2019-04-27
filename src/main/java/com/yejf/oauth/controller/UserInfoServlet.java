package com.yejf.oauth.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user_info")
public class UserInfoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getSession().getAttribute("account") == null){
            resp.sendRedirect("/");
        }else{
            req.getRequestDispatcher("/WEB-INF/page/user_info.jsp").forward(req,resp);
        }
    }
}
