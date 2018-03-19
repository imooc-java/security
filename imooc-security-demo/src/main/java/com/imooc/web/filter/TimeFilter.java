package com.imooc.web.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

//@Component
public class TimeFilter implements Filter {

    private static final Logger logger = LoggerFactory.getLogger(TimeFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("TimeFilter init");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("TimeFilter do start");
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        logger.info("TimeFilter 耗时：{} 毫秒", System.currentTimeMillis() - start);
        logger.info("TimeFilter do finish");
    }

    @Override
    public void destroy() {
        logger.info("TimeFilter destroy");
    }
}
