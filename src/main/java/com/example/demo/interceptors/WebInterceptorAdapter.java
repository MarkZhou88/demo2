package com.example.demo.interceptors;

import com.example.demo.requests.UserIdInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
@Configuration
public class WebInterceptorAdapter implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new LogInterceptor()).addPathPatterns("/**").order(0);
        registry.addInterceptor(new UserIdInterceptor()).addPathPatterns("/user/*").order(1);
    }
}
