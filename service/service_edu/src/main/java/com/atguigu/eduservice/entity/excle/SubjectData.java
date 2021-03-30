package com.atguigu.eduservice.entity.excle;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/30 20:50
 */
@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String oneSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;

}
