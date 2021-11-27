package com.whpu.config;

import com.whpu.handler.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @description
 * @author: 唉 烁
 * @time: 2021/10/27 21:33
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Autowired
    LoginInterceptor loginInterceptor;

//    跨域配置
    @Override
    public void addCorsMappings(CorsRegistry registry) {
//        跨域配置，允许当前所有接口给 8080访问
        registry.addMapping("/**").allowedOrigins("http://localhost:3000");

    }

   /* @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/api/login");
    }*/
}
