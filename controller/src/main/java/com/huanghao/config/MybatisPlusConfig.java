package com.huanghao.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HuangHao
 * @date 2021/8/10 0:50
 */
@Configuration
public class MybatisPlusConfig {

    /**
     *  mybatis-plus分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor page = new PaginationInterceptor();
        page.setDialectType(DbType.MYSQL.getDb());
        return page;
    }
}
