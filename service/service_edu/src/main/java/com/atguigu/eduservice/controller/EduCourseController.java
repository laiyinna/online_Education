package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-31
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/educourse")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;

    /**
     * 添加课程信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 19:35 2021/3/31
     * @Param @param courseInfoVo
     */
    @PostMapping("addCourseInfo")
    public CommonResult addCourseInfo(@RequestBody CourseInfoVo courseInfoVo) {
        String id = eduCourseService.saveCourseInfo(courseInfoVo);
        return CommonResult.ok().data("courseId",id);
    }

}

