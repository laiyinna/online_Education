package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.client.VodClient;
import com.atguigu.eduservice.entity.EduChapter;
import com.atguigu.eduservice.entity.EduVideo;
import com.atguigu.eduservice.service.EduVideoService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-31
 */
@RestController
@CrossOrigin
@RequestMapping("/eduservice/eduvideo")
public class EduVideoController {

    @Autowired
    private EduVideoService eduVideoService;

    @Autowired
    private VodClient vodClient;

    @PostMapping("addVideo")
    public CommonResult addVideo(@RequestBody EduVideo eduVideo){
        eduVideoService.save(eduVideo);
        return CommonResult.ok();
    }

    @DeleteMapping("{videoId}")
    public CommonResult deleteVideo(@PathVariable String videoId) {
        EduVideo eduVideo = eduVideoService.getById(videoId);
        //删除视频
        if(!StringUtils.isEmpty(eduVideo.getVideoSourceId())) {
            CommonResult commonResult = vodClient.removeAlyVideo(eduVideo.getVideoSourceId());
            if(commonResult.getCode() == 20001) {
                throw new GuliException(20001,"删除视频失败，熔断器...");
            }
        }
        eduVideoService.removeById(videoId);
        return CommonResult.ok();
    }

    @GetMapping("getVideoById/{videoId}")
    public CommonResult getVideoById(@PathVariable String videoId) {
        EduVideo eduVideo = eduVideoService.getById(videoId);
        return CommonResult.ok().data("eduVideo",eduVideo);
    }

    @PostMapping("updateVideoInfo")
    public CommonResult updateVideoInfo(@RequestBody EduVideo eduVideo){
        eduVideoService.updateById(eduVideo);
        return CommonResult.ok();
    }

}

