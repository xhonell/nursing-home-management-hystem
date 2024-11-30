package com.gxa.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>Project:test_01 - indexFilter
 * <p>POWER by xhonell on 2024-11-22 17:48
 * <p>description：语言拦截器，控制所有页面跳转的语言
 * <p>idea：
 * @author xhonell
 * @version 1.0
 * @since 1.8
 */
@WebFilter({"/page/*", "/servlet/index/*"})
public class LanguageFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 重写doFilter方法，用于处理过滤逻辑。
     *
     * @param servletRequest  ServletRequest对象，包含客户端请求信息
     * @param servletResponse ServletResponse对象，用于向客户端发送响应
     * @param filterChain     FilterChain对象，用于调用链中的下一个过滤器或目标资源
     * @throws IOException  如果发生输入/输出错误
     * @throws ServletException 如果发生Servlet错误
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*设置接受请求的字符集utf-8*/
        servletRequest.setCharacterEncoding("utf-8");
        /*设置响应的字符集utf-8,并强制返回json格式*/
        servletResponse.setContentType("application/json;charset=utf-8");
        /*获取session中的player，如果为空则跳转到登录页面*/
        Object player = ((HttpServletRequest) servletRequest).getSession().getAttribute("role");
        if (player == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("/Login/login.html");
        }else{
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
