package com.atguigu.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/16 20:02
 */
@Configuration
@MapperScan("com.atguigu.eduservice.mapper")
public class EduTeacherConfig {

    /**
     * 逻辑删除插件
     * @Return ISqlInjector
     * @Author suyuanyuan
     * @Date 20:56 2021/3/19
     * @Param @param
     */
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
