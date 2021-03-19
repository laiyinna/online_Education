package com.atguigu.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/16 19:58
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.atguigu"})
public class EduTeacherApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduTeacherApplication.class,args);
    }

}
