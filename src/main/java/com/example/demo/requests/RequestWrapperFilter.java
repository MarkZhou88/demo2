package com.example.demo.requests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = "/user/*", filterName = "RequestWrapperFilter")
public class RequestWrapperFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(RequestWrapperFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        log.info("RequestWrapperFilter Replace InputStream!");

        ServletRequest requestWrapper =
                new RequestWrapper((HttpServletRequest) request);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
