package com.jiahua.backup;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

        // cookie处理相关
        // 记录用户最新访问时间，这个跟cookies对象没有关系
        String dateString = new Date().toString();
        Cookie cookie = new Cookie("lastVisit", dateString);
        cookie.setMaxAge(60*60); // 1 hour
        response.addCookie(cookie);

        // 根据url判断请求页面是否需要验证登陆
        String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
        if (!url.contains("auth")) {

            // 不需要验证的页面，直接放过
            filterChain.doFilter(servletRequest, servletResponse);
        } else {

            // 利用filter检测用户登录
            System.out.println("AuthenticationFilter : 验证用户登录");
            if (LoginChecker.check(request)) {
                filterChain.doFilter(servletRequest, servletResponse);
            }


            /*
            // 尝试根据url不过滤图片文件等
            if (servletRequest instanceof HttpServletRequest) {
                String url = ((HttpServletRequest)servletRequest).getRequestURL().toString();
                String queryString = ((HttpServletRequest)servletRequest).getQueryString(); // null
                System.out.println(url);
                System.out.println();

                // 正则表达式，检测图片文件等
                if(url.matches(".*[css|jpg|png|gif|js].*")){
                    filterChain.doFilter(servletRequest, servletResponse);
                    return;
                }
            }
            */
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
