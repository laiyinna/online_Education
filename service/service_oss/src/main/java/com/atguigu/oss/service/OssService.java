package com.atguigu.oss.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/27 12:02
 */
public interface OssService {
    /**
     * 上传文件至OSS
     * @Return java.lang.String
     * @Author suyuanyuan
     * @Date 12:11 2021/3/27
     * @Param @param file
     */
    String uploadFileAvatar(MultipartFile file);
}
