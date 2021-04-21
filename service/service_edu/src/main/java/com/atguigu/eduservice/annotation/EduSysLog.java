package com.atguigu.eduservice.annotation;

import java.lang.annotation.*;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/4/21 20:24
 */
//@Target注解说明自定义的注解可作用在哪些地方
@Target({ElementType.PARAMETER,ElementType.METHOD})
//@Retention作用是定义被它所注解的注解保留多久
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface EduSysLog {

    /**
     * 要执行的操作类型比如：add操作
     * @return
     */
    public String operationType () default "";

    /**
     * 要执行的具体操作比如：添加用户
     * @return
     */
    public String operationName () default "";
}
