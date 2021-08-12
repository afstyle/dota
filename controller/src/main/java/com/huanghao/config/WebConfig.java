package com.huanghao.config;

import com.huanghao.interceptor.BAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author HuangHao
 * @date 2021/8/12 17:59
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public BAuthInterceptor bAuthInterceptor() {
        return new BAuthInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(bAuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/dota/b/user/login");
    }
}
