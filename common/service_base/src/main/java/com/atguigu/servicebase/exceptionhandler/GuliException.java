package com.atguigu.servicebase.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/20 13:36
 */
//生成get、set方法
@Data
//生成有参构造
@AllArgsConstructor
//生成无参构造
@NoArgsConstructor
public class GuliException extends RuntimeException {
    @ApiModelProperty(value = "状态码")
    private Integer code;
    private String msg;
}
