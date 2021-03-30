package com.atguigu.oss.controller;

import com.atguigu.commonutils.CommonResult;
import com.atguigu.oss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/27 12:02
 */
@RestController
@RequestMapping("/eduoss/fileoss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;

    /**
     * 上传文件
     * @Return com.atguigu.commonutils.CommonResult
     * @Author suyuanyuan
     * @Date 12:05 2021/3/27
     * @Param @param
     */
    @PostMapping
    public CommonResult uploadOssFile(MultipartFile file){
        //获取上传的文件MultipartFile
        //url为上传至阿里云存储OSS上的文件地址
        String url = ossService.uploadFileAvatar(file);
        return CommonResult.ok().data("url",url);
    }

}
