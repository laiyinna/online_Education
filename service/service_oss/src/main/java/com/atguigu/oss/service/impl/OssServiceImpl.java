package com.atguigu.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.atguigu.oss.service.OssService;
import com.atguigu.oss.utils.ConstantPropertiesUtils;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/27 12:03
 */
@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadFileAvatar(MultipartFile file) {

        String endpoint = ConstantPropertiesUtils.END_POINT;
        String accessKeyId = ConstantPropertiesUtils.KEY_ID;
        String accessKeySecret = ConstantPropertiesUtils.KEY_SECRET;
        String bucketName = ConstantPropertiesUtils.BUCKET_NAME;

        // 填写本地文件的完整路径。如果未指定本地路径，则默认从示例程序所属项目对应本地路径中上传文件流。
        InputStream inputStream = null;
        try {
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            inputStream = file.getInputStream();
            //为防止文件名相同导致文件覆盖，需在文件名后添加随机值
            String filename = UUID.randomUUID().toString().replaceAll("-","") + file.getOriginalFilename();
            //把文件按日期分类
            String datePath = new DateTime().toString("yyyy/MM/dd");
            filename = datePath + "/" + filename;
            //1、Bucket名称
            //2、上传至OSS的路径或文件名称
            //3、上传文件的输入流
            ossClient.putObject(bucketName, filename, inputStream);

            //上传至OSS的文件路径返回，需要手动拼接
            String url = "https://" + bucketName + "." + endpoint + "/" + filename;
            // 关闭OSSClient。
            ossClient.shutdown();
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
