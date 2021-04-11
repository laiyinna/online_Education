package com.atguigu.eduservice.client;

import com.atguigu.commonutils.CommonResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VodFileDegradeFeignClient implements VodClient {
   //出错之后会执行
    @Override
    public CommonResult removeAlyVideo(String id) {
        return CommonResult.error().message("删除视频出错了");
    }

    @Override
    public CommonResult deleteBatch(List<String> videoIdList) {
        return CommonResult.error().message("删除多个视频出错了");
    }
}
