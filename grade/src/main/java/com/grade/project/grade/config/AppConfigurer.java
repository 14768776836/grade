package com.grade.project.grade.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class AppConfigurer extends WebMvcConfigurerAdapter {

    @Bean
    public HandlerInterceptor getMyInterceptor() {
        return new Interceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns("/**")对所有请求都拦截，但是排除(excludePathPatterns)了/user请求的拦截
        registry.addInterceptor(new Interceptor()).addPathPatterns("/**")
                .excludePathPatterns(
                        "/user/**",
                        "/wxMch/**",
                        "/wxPpublicNum/**"
                );
        super.addInterceptors(registry);
    }
}