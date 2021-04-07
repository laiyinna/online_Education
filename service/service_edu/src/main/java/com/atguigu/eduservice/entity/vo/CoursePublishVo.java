package com.atguigu.eduservice.entity.vo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/4/7 21:50
 */
@Data
public class CoursePublishVo {
    private String id;
    private String courseName;
    private BigDecimal price;
    private Integer lessonNum;
    private String description;
    private String name;
    private String oneTitle;
    private String twoTitle;
    private String cover;
}
