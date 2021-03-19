package com.atguigu.eduservice.controller;


import com.atguigu.commonutils.CommonResult;
import com.atguigu.eduservice.entity.EduTeacher;
import com.atguigu.eduservice.entity.vo.EduTeacherQuery;
import com.atguigu.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author suyuanyuan
 * @since 2021-03-16
 */
@Api(description = "讲师管理")
@CrossOrigin
@RestController
@RequestMapping("/eduservice/eduteacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    @ApiOperation(value = "所有讲师列表")
    @GetMapping("findAll")
    public CommonResult findAll() {
        List<EduTeacher> list = eduTeacherService.list(null);
        return CommonResult.ok().data("item", list);
    }

    @ApiOperation(value = "根据id删除讲师")
    @DeleteMapping("{id}")
    public CommonResult removeById(@ApiParam(name = "id", value = "讲师id", required = true) @PathVariable String id) {
        eduTeacherService.removeById(id);
        return CommonResult.ok();
    }

    @ApiOperation(value = "分页讲师列表")
    @GetMapping("pageTeacher/{page}/{limit}")
    public CommonResult pageList(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable long page,
                                 @ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable long limit) {
        Page<EduTeacher> pageParam = new Page<EduTeacher>(page,limit);
        eduTeacherService.page(pageParam,null);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return CommonResult.ok().data("total", total).data("rows", records);
    }

    @ApiOperation(value = "条件分页讲师列表")
    @PostMapping("pageTeacherCondition")
    public CommonResult pageListCondition(@RequestBody EduTeacherQuery eduTeacherQuery){
        Page<EduTeacher> pageParam = new Page<EduTeacher>(eduTeacherQuery.getCurrent(),eduTeacherQuery.getLimit());
        //构建条件QueryWrapper
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();
        // 多条件组合查询
        // mybatis学过 动态sql
        String name = eduTeacherQuery.getName();
        Integer level = eduTeacherQuery.getLevel();
        String begin = eduTeacherQuery.getBegin();
        String end = eduTeacherQuery.getEnd();
        //判断条件值是否为空，如果不为空拼接条件
        if(!StringUtils.isEmpty(name)) {
            //构建条件
            wrapper.like("name",name);
        }
        if(!StringUtils.isEmpty(level)) {
            wrapper.eq("level",level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create",begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_create",end);
        }
        eduTeacherService.page(pageParam,wrapper);
        List<EduTeacher> records = pageParam.getRecords();
        long total = pageParam.getTotal();
        return CommonResult.ok().data("total", total).data("rows", records);
    }
}

