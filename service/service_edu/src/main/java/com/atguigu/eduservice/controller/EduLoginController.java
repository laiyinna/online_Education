package com.atguigu.eduservice.controller;

import com.atguigu.commonutils.CommonResult;
import org.springframework.web.bind.annotation.*;

/**
 * 登录
 * @author SuSu
 * @version 1.0
 * @date 2021/3/24 21:17
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
public class EduLoginController {

    /**
     * 登录
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 21:20 2021/3/24
     * @Param @param
     */
    @PostMapping("login")
    public CommonResult login() {
        return CommonResult.ok().data("token","admin");
    }

    /**
     * 获取用户信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 21:20 2021/3/24
     * @Param @param
     */
    @GetMapping("info")
    public CommonResult info() {
        return CommonResult.ok().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
