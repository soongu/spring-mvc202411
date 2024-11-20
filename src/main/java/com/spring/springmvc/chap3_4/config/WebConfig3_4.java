// 1. WebMvcConfigurer를 사용하여 CORS 설정
package com.spring.springmvc.chap3_4.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig3_4 implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/v3-4/**") // CORS 허용 경로
                .allowedOrigins("http://127.0.0.1:5500") // Live Server의 Origin
                .allowedMethods("GET") // 허용할 HTTP 메서드
                .allowedHeaders("*"); // 허용할 헤더
    }
}
