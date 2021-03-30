package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-30
 */
public interface EduSubjectService extends IService<EduSubject> {

    /**
     * 添加课程分类
     * @Return void
     * @Author suyuanyuan
     * @Date 20:47 2021/3/30
     * @Param @param multipartFile
     */
    void saveSubject(MultipartFile multipartFile, EduSubjectService eduSubjectService);

    /**
     * 课程分类列表（树形）
     * @Return List<OneSubject>
     * @Author suyuanyuan
     * @Date 22:09 2021/3/30
     * @Param @param
     */
    List<OneSubject> getAllOneTwoSubject();
}
