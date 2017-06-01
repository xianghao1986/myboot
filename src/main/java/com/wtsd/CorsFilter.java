package com.wtsd;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决ajax跨域的问题
 * Created by xianghao on 2017/5/29.
 */
public class CorsFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        ((HttpServletResponse)response).setHeader("Access-Control-Allow-Origin", "*");
        ((HttpServletResponse)response).setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS, PUT, DELETE");
        ((HttpServletResponse)response).setHeader("Access-Control-Max-Age", "3600");
        ((HttpServletResponse)response).setHeader("Access-Control-Allow-Headers", "Origin, No-Cache, X-Requested-With, If-Modified-Since, Pragma, Last-Modified, Cache-Control, Expires,Content-Type, X-E4M-With");

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
