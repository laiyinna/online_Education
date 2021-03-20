package com.atguigu.servicebase.exceptionhandler;

import com.atguigu.commonutils.CommonResult;
import com.atguigu.commonutils.ExceptionUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/20 13:15
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    /**
     * 统一异常处理
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 13:30 2021/3/20
     * @Param @param e
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public CommonResult error(Exception e){
        e.printStackTrace();
        return CommonResult.error().message("全局异常处理");
    }

    /**
     * 特定异常处理
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 13:30 2021/3/20
     * @Param @param e
     */
    @ExceptionHandler(ArithmeticException.class)
    @ResponseBody
    public CommonResult error(ArithmeticException e){
        e.printStackTrace();
        return CommonResult.error().message("执行了ArithmeticException异常处理");
    }

    /**
     * 自定义异常处理
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 13:30 2021/3/20
     * @Param @param e
     */
    @ExceptionHandler(GuliException.class)
    @ResponseBody
    public CommonResult error(GuliException e){
        log.error(ExceptionUtil.getMessage(e));
        e.printStackTrace();
        return CommonResult.error().code(e.getCode()).message(e.getMsg());
    }
}
