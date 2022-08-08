package com.soft.spb.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName CorsConfig
 * @Description 跨域配置
 * @Author mq_xu
 * @Date 2019/11/29
 **/
@Configuration
public class CorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        // 设置访问源地址
        config.addAllowedOriginPattern("*");
        // 设置访问源请求头
        config.addAllowedHeader("*");
        // 设置访问源请求方法
        config.addAllowedMethod("*");
        // 有效期 1800秒
        config.setMaxAge(1800L);
        // 添加映射路径，拦截一切请求
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        CorsConfiguration config = new CorsConfiguration();
//        config.setAllowCredentials(false);
//        //放行所有跨域的客户端domain
//        config.addAllowedOrigin("*");
//        //允许的请求方法列表
//        String[] requestMethods = {"GET", "POST", "PUT", "DELETE", "OPTIONS"};
//        List<String> allowedRequestMethods = Arrays.asList(requestMethods);
//        config.setAllowedMethods(allowedRequestMethods);
//        //允许的客户端请求头列表
//        String[] requestHeaders = {"x-requested-with", "Content-Type", "Authorization"};
//        List<String> allowedHeaders = Arrays.asList(requestHeaders);
//        config.setAllowedHeaders(allowedHeaders);
//        //允许的响应头列表
//        String[] responseHeaders = {"Access-Control-Expose-Headers","Verify", "Content-Type", "Authorization"};
//        List<String> allowedExposedHeaders = Arrays.asList(responseHeaders);
//        config.setExposedHeaders(allowedExposedHeaders);
//        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
