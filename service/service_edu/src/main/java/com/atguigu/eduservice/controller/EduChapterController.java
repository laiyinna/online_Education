package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.chapter.ChapterVo;
import com.atguigu.eduservice.service.EduChapterService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/eduservice/educhapter")
public class EduChapterController {

    @Autowired
    private EduChapterService eduChapterService;

    @GetMapping("getChapterVo/{courseId}")
    public CommonResult getChapterVo(@PathVariable String courseId) {
        List<ChapterVo> chapterList = eduChapterService.getChapterVideoBycourseId(courseId);
        return CommonResult.ok().data("chapterList",chapterList);
    }

    @PostMapping("addChapterInfo")
    public CommonResult addChapterInfo(@RequestBody EduChapter eduChapter){
        eduChapterService.save(eduChapter);
        return CommonResult.ok();
    }

    @GetMapping("getChapterById/{chapterId}")
    public CommonResult getChapterById(@PathVariable String chapterId) {
        EduChapter eduChapter = eduChapterService.getById(chapterId);
        return CommonResult.ok().data("eduChapter",eduChapter);
    }

    @PostMapping("updateChapterInfo")
    public CommonResult updateChapterInfo(@RequestBody EduChapter eduChapter){
        eduChapterService.updateById(eduChapter);
        return CommonResult.ok();
    }

    @DeleteMapping("{chapterId}")
    public CommonResult deleteChapterInfo(@PathVariable String chapterId) {
        boolean flag = eduChapterService.deleteChapter(chapterId);
        if(flag) {
            return CommonResult.ok();
        }else {
            return CommonResult.error();
        }
    }

}

