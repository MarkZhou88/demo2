package com.example.demo.interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class LogInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(LogInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler)
            throws Exception {

        request.setAttribute("startTime", System.currentTimeMillis());

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        log.info("LogInterceptor: {}", handlerMethod.getBean()
                .getClass().getName());
        log.info("LogInterceptor: {}", handlerMethod.getMethod().getName());

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        log.info("UpdateLogInterceptor Print Log: {} -> {}",
                request.getRequestURI(),
                System.currentTimeMillis() - (long) request.getAttribute("startTime"));
    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler,
                                Exception ex) throws Exception {

    }
}
