package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.atguigu.eduservice.entity.vo.EduCourseQuery;
import com.atguigu.eduservice.service.EduCourseDescriptionService;
import com.atguigu.eduservice.service.EduCourseService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    /**
     * 修改课程信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 22:02 2021/4/10
     * @Param @param courseInfoVo
     */
    @PostMapping("updateCourseInfo")
    public CommonResult updateCourseInfo(@RequestBody CourseInfoVo courseInfoVo){
        String courseId = eduCourseService.updateCourseInfo(courseInfoVo);
        return CommonResult.ok().data("courseId",courseId);
    }

    /**
     * 根据id查询课程信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 22:02 2021/4/10
     * @Param @param id
     */
    @GetMapping("getInfoById/{id}")
    public CommonResult getInfoById(@PathVariable String id){
        CoursePublishVo coursePublishVo = eduCourseService.getInfoById(id);
        return CommonResult.ok().data("publishCourse",coursePublishVo);
    }

    /**
     * 发布课程
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 22:02 2021/4/10
     * @Param @param id
     */
    @PostMapping("publishCourse/{id}")
    public CommonResult publishCourse(@PathVariable String id){
        EduCourse eduCourse = new EduCourse();
        eduCourse.setId(id);
        eduCourse.setStatus("Normal");
        boolean count = eduCourseService.updateById(eduCourse);
        if(count) {
            return CommonResult.ok();
        }else {
            return CommonResult.error();
        }
    }

    /**
     * 课程列表查询接口
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 22:03 2021/4/10
     * @Param @param
     */
    @PostMapping("getCourseList/{current}/{limit}")
    public CommonResult getCourseList(@PathVariable long current,@PathVariable long limit,
                                      @RequestBody(required = false) EduCourseQuery eduCourseQuery){
        //创建分页对象
        Page<EduCourse> pageCourse = new Page<>(current,limit);
        //创建查询条件
        QueryWrapper<EduCourse> queryWrapper = new QueryWrapper<>();
        String title = eduCourseQuery.getTitle();
        String status = eduCourseQuery.getStatus();
        if(!StringUtils.isEmpty(title)) {
            queryWrapper.like("title",title);
        }
        if(!StringUtils.isEmpty(status)) {
            queryWrapper.like("status",status);
        }
        queryWrapper.orderByDesc("gmt_create");
        eduCourseService.page(pageCourse,queryWrapper);
        //总记录数
        long total = pageCourse.getTotal();
        //数据集合
        List<EduCourse> eduCourseList = pageCourse.getRecords();
        return CommonResult.ok().data("total",total).data("eduCourseList",eduCourseList);
    }

    /**
     * 删除课程信息
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 11:16 2021/4/11
     * @Param @param
     */
    @DeleteMapping("removeCourse/{courseId}")
    public CommonResult removeCourse(@PathVariable String courseId){
        eduCourseService.removeCourse(courseId);
        return CommonResult.ok();
    }

}

