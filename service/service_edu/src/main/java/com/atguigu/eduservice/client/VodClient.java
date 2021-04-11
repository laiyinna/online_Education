package com.atguigu.eduservice.client;

import com.atguigu.commonutils.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/4/11 17:57
 */
@Component
@FeignClient(name = "service-vod", fallback = VodFileDegradeFeignClient.class)
public interface VodClient {

    /**
     * 根据视频id删除视频
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 17:58 2021/4/11
     * @Param @param videoId
     */
    @DeleteMapping("/eduvod/video/removeAlyVideo/{id}")
    public CommonResult removeAlyVideo(@PathVariable("id") String id);

    /**
     * 删除多个阿里云视频的方法
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 18:19 2021/4/11
     * @Param @param videoIdList
     */
    @DeleteMapping("/eduvod/video/delete-batch")
    public CommonResult deleteBatch(@RequestParam("videoIdList") List<String> videoIdList);

}
