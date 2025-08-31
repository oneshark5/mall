package com.mall.mallgateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @version 1.0
 * @Author bobo
 * @Date 2025/3/3 16:07
 * @注释  @Configuration 该注解标注 该类是一个配置类
 */
@Configuration
public class MallCorsConfiguration {
    // 该注解表示加入到容器中
    @Bean
    public CorsWebFilter corsWebFilter () {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 配置跨域 TODO 跨域项目最后设置
        corsConfiguration.addAllowedHeader("*"); // 请求头设置
        corsConfiguration.addAllowedMethod("*"); // 请求方法设置
        corsConfiguration.addAllowedOrigin("*"); // 请求源设置
        corsConfiguration.setAllowCredentials(true);// 是否携带cookie允许跨域

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
