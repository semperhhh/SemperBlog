package com.zph.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //排除
        registry.addInterceptor(new TokenInterceptor()).
                excludePathPatterns("/api/login"
                        //, "/index.html"
                        //, "/static/**",
                        //, "/assets/**"
                );
    }
}
