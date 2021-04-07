package com.atguigu.eduservice.service;

import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-31
 */
public interface EduChapterService extends IService<EduChapter> {

    List<ChapterVo> getChapterVideoBycourseId(String courseId);

    boolean deleteChapter(String chapterId);
}
