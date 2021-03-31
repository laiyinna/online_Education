package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CourseInfoVo;
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
}
