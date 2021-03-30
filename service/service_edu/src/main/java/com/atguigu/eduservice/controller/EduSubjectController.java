package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-30
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/subject")
public class EduSubjectController {

    @Autowired
    private EduSubjectService eduSubjectService;

    @PostMapping("importSubject")
    public CommonResult importSubject(MultipartFile multipartFile){
        eduSubjectService.saveSubject(multipartFile,eduSubjectService);
        return CommonResult.ok();
    }

    @GetMapping("getAllSubject")
    public CommonResult getAllSubject() {
        //list集合泛型是一级分类
        List<OneSubject> list = eduSubjectService.getAllOneTwoSubject();
        return CommonResult.ok().data("list",list);
    }
}

