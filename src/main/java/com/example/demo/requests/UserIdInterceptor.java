package com.example.demo.requests;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserIdInterceptor implements HandlerInterceptor {

    private static final Logger log = LoggerFactory.getLogger(UserIdInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {

        if (RequestParseUtil.isJson(request)) {

            String json = RequestParseUtil.getBodyString(request);
            User user;

            try {
                user = new ObjectMapper().readValue(json, User.class);
            } catch (Exception ex) {
                user = null;
            }

            if (user != null) {
                log.info("UserIdInterceptor process user: {}", user);
            }
        }

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception ex) throws Exception {

    }
}
