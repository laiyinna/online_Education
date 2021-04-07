package com.atguigu.eduservice.mapper;

import com.atguigu.eduservice.entity.EduCourse;
import com.atguigu.eduservice.entity.vo.CoursePublishVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 课程 Mapper 接口
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-31
 */
public interface EduCourseMapper extends BaseMapper<EduCourse> {

    CoursePublishVo getInfoById(@Param("id") String id);

}
