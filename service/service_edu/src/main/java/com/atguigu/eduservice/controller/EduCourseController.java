package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
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

    /**
     * 根据课程id查询信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 15:57 2021/4/3
     * @Param @param courseId
     */
    @GetMapping("getCourseInfoById/{courseId}")
    public CommonResult getCourseInfoById(@PathVariable String courseId){
        CourseInfoVo courseInfoVo = eduCourseService.getCourseInfoById(courseId);
        return CommonResult.ok().data("courseInfoVo",courseInfoVo);
    }

    @PostMapping("updateCourseInfo")
    public CommonResult updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = eduCourseService.updateCourseInfo(courseInfoVo);
        return CommonResult.ok().data("courseId",courseId);
    }

    @GetMapping("getInfoById/{id}")
    public CommonResult getInfoById(@PathVariable String id){
        CoursePublishVo coursePublishVo = eduCourseService.getInfoById(id);
        return CommonResult.ok().data("publishCourse",coursePublishVo);
    }

}

