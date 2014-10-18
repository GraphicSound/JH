package com.jiahua.user.filter;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by yu on 10/12/14.
 */

public class AuthenticationFilter implements Filter {
    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        // 不转换的话调用不到方法
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        response.setContentType("text/html");

        // 记录用户最新访问时间，这个跟cookies对象没有关系
        String dateString = new Date().toString();
        Cookie cookie = new Cookie("lastVisit", dateString);
        cookie.setMaxAge(60*60); // 1 hour
        response.addCookie(cookie);

        // 利用filter检测用户登录
        System.out.println("AuthenticationFilter : 访问auth资源，需要验证用户登录");
        if (null == request.getSession().getAttribute("user")) {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    // 遍历、显示cookie所有元素
    private void showCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (null == cookies) {
            // 第一次访问，连sessionID都没有
        } else {
            // 查看所有的cookie元素
            System.out.println("***cookies***");
            for(Cookie obj : cookies){
                System.out.println(obj.getName() + " : " + obj.getValue());
            }
            System.out.println("***cookies***");
        }
    }
}
