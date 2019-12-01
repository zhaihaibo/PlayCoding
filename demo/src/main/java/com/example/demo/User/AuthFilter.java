package com.example.demo.User;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class AuthFilter implements Filter {

    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

        log.info("过滤器进行了初始化-------------------");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        log.info("开始过滤--------------------------");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd  HH:mm:ss");
        String start = simpleDateFormat.format(new Date());
        log.info(start+"++++++++++++++++++++++++++++++");
        chain.doFilter(request,response);
        String end = simpleDateFormat.format(new Date());
        log.info(end+"++++++++++++++++++++++++++++++++++");

    }

    @Override
    public void destroy() {
        log.info("销毁过滤器-----------------------");
    }
}
