package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-31
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程信息
     * @Return void
     * @Author suyuanyuan
     * @Date 19:35 2021/3/31
     * @Param @param courseInfoVo
     */
    String saveCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 根据课程id查询信息
     * @Return com.atguigu.eduservice.entity.vo.CourseInfoVo
     * @Author suyuanyuan
     * @Date 15:59 2021/4/3
     * @Param @param courseId
     */
    CourseInfoVo getCourseInfoById(String courseId);

    /**
     * 修改课程信息
     * @Return void
     * @Author suyuanyuan
     * @Date 16:04 2021/4/3
     * @Param @param courseInfoVo
     */
    String updateCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 根据课程id查询信息
     * @Return com.atguigu.eduservice.entity.vo.CoursePublishVo
     * @Author suyuanyuan
     * @Date 22:01 2021/4/7
     * @Param @param id
     */
    CoursePublishVo getInfoById(String id);
}
