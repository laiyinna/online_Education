package com.atguigu.eduservice.aspect;

import com.atguigu.eduservice.annotation.EduSysLog;
import com.atguigu.eduservice.entity.EduLog;
import com.atguigu.eduservice.service.EduLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/4/21 20:36
 */
@Component
@Aspect
public class EduLogAspect {

    @Autowired
    private EduLogService eduLogService;

    //定义Controller切点
    @Pointcut("execution(* com.atguigu.eduservice.controller..*.*(..))")
    public void controllerAspect(){

    }


    /**
     * 环绕增强
     * @Return void
     * @Author suyuanyuan
     * @Date 20:42 2021/4/21
     * @Param @param joinPoint
     */
    @Around("controllerAspect()")
    public void around(JoinPoint joinPoint) {
        System.out.println("==========开始执行controller环绕通知===============");
        try {
            //获取注解
            Method proxyMethod = ((MethodSignature) joinPoint.getSignature()).getMethod();
            Method targetMethod = joinPoint.getTarget().getClass().getMethod(proxyMethod.getName(), proxyMethod.getParameterTypes());
            EduSysLog myTag = targetMethod.getAnnotation(EduSysLog.class);
            String operationType = myTag.operationType();
            String operationName = myTag.operationName();
            try {
                ((ProceedingJoinPoint) joinPoint).proceed();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
            EduLog eduLog = new EduLog();
            eduLog.setOperationType(operationType);
            eduLog.setOperationName(operationName);
            eduLogService.save(eduLog);

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("==========结束执行controller环绕通知===============");
    }
}
