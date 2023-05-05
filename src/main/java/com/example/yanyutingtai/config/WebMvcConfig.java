package com.example.yanyutingtai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    public void addCorsMappings(CorsRegistry registry){
        //对哪些请求路径进行跨域处理
        registry.addMapping("/**")
                //允许的请求头
                .allowedHeaders("*")
                //允许的方法
                .allowedMethods("*")
                //探测请求有效时间，单位：“秒”
                .maxAge(1800)
                //是否允许证书（cookies）
                .allowCredentials(true)
                //支持的域
                .allowedOriginPatterns("*");
    }
}
