package com.atguigu.eduservice.entity.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/19 21:39
 */
@Data
public class EduCourseQuery {

    @ApiModelProperty(value = "课程名称,模糊查询")
    private String title;

    @ApiModelProperty(value = "课程状态 Draft未发布  Normal已发布")
    private String status;

    @ApiModelProperty(value = "当前页")
    private long current;

    @ApiModelProperty(value = "每页显示条数")
    private long limit;
}
