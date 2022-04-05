package com.yp.gulimall.gateway.config;
/**
 * @author pan
 * @date 2022/3/30 14:21
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.reactive.CorsWebFilter;

/**
 * @ClassName : com.yp.gulimall.gateway.config.GulimailCorsConfiguration
 * @Description : 类描述
 * @author pan
 * @date 2022/3/30 14:21
 */
@Configuration
public class GulimailCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        //1、配置跨域
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowCredentials(true);

        // 配置前端js允许访问的自定义响应头
        corsConfiguration.addExposedHeader("setToken");

        source.registerCorsConfiguration("/**",corsConfiguration);
        return new CorsWebFilter(source);
    }
}
