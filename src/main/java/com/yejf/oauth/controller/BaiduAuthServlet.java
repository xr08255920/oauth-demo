package com.yejf.oauth.controller;

import com.google.gson.Gson;
import com.yejf.oauth.dto.BaiduAccessTokenDTO;
import com.yejf.oauth.dto.UserInfoDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@WebServlet("/baiduAuth")
public class BaiduAuthServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String apiKey = "gkTh2xPm81Qoe7e5d6oczTYf";
        String secretKey = "CNi5fWr1c1Yd1NomBz4tTFaQjoXYFVOM";
        String code = req.getParameter("code");
        if (code == null || code == "") {
            req.setAttribute("errorMsg", "操作有误，请重新登录");
            resp.sendRedirect("/WEB-INF/page/login.jsp");
        }

        String basePath = req.getRequestURL().toString();
        URL accessTokenUrl = new URL("https://openapi.baidu.com/oauth/2.0/token?" +
                "grant_type=authorization_code&" +
                "code="+code+"&" +
                "client_id="+apiKey+"&" +
                "client_secret="+secretKey+"&" +
                "redirect_uri="+ basePath);
        HttpURLConnection urlConnection = (HttpURLConnection) accessTokenUrl.openConnection();
        if (urlConnection.getResponseCode() != 200){
            resp.getWriter().println(urlConnection.getResponseMessage());
            return;
        }
        InputStream is = urlConnection.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        Gson gson = new Gson();
        BaiduAccessTokenDTO baiduAccessTokenDTO = gson.fromJson(br, BaiduAccessTokenDTO.class);

        req.getSession().setAttribute("baiduAccessToken",baiduAccessTokenDTO);

        String userInfoUrl = "https://openapi.baidu.com/rest/2.0/passport/users/getLoggedInUser" +
                "?access_token="+baiduAccessTokenDTO.getAccess_token();
        URL uiUrl = new URL(userInfoUrl);
        HttpURLConnection urlConnection1 = (HttpURLConnection) uiUrl.openConnection();
        if (urlConnection1.getResponseCode() != 200){
            resp.getWriter().println(urlConnection.getResponseMessage());
            return;
        }

        UserInfoDTO userInfoDTO = gson.fromJson(new BufferedReader(new InputStreamReader(urlConnection1.getInputStream()))
                , UserInfoDTO.class);
        userInfoDTO.setInfoFrom("baidu");

        req.getSession().setAttribute("userInfo",userInfoDTO);

        resp.sendRedirect("/user_info");

    }
}
