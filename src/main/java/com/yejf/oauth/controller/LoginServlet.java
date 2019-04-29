package com.yejf.oauth.controller;


import com.yejf.oauth.dto.UserInfoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet( "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String account = req.getParameter("account");
        String password = req.getParameter("password");
        if ("admin".equals(account) && "123456".equals(password)){
            UserInfoDTO userInfoDTO = new UserInfoDTO();
            userInfoDTO.setUid(account);
            userInfoDTO.setUname(account);
            req.getSession().setAttribute("userInfo",userInfoDTO);
            resp.sendRedirect("user_info");
        }else{
            req.setAttribute("errorMsg","您的账号或密码有误，请重新登录");
            req.setAttribute("account",account);
            req.getRequestDispatcher("/WEB-INF/page/login.jsp").forward(req,resp);
        }
    }
}
