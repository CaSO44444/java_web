package com.example.mojocebe.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: DawnT0wn
 * @Date: 2023/5/16 16:39
 * @Description: 拦截防止注入漏洞（即防止XSS的跨站脚本攻击）
 */
@WebFilter(urlPatterns = "/*", filterName = "xssFilter")
public class XssFilter implements Filter {
    private FilterConfig filterConfig = null;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(new XssHttpServletRequestWrapper((HttpServletRequest) servletRequest), servletResponse);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}

