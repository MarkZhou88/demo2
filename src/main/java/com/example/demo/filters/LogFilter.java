package com.example.demo.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/*", filterName = "LogFilter")
public class LogFilter implements Filter {

    private static final Logger log = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        chain.doFilter(request, response);
        log.info("LogFilter Print Log: {} -> {}",
                ((HttpServletRequest) request).getRequestURI(),
                System.currentTimeMillis() - start);
    }

    @Override
    public void destroy() {

    }
}
