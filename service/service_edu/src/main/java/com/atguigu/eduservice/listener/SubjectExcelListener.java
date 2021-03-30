package com.atguigu.eduservice.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excle.SubjectData;
import com.atguigu.eduservice.service.EduSubjectService;
import com.atguigu.servicebase.exceptionhandler.GuliException;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/3/30 20:58
 */
public class SubjectExcelListener extends AnalysisEventListener<SubjectData> {

    private EduSubjectService eduSubjectService;

    public SubjectExcelListener() {
    }

    public SubjectExcelListener(EduSubjectService eduSubjectService) {
        this.eduSubjectService = eduSubjectService;
    }

    /**
     * 读取excle数据，一行一行读取
     * @Return void
     * @Author suyuanyuan
     * @Date 21:07 2021/3/30
     * @Param @param subjectData
     * @param analysisContext
     */
    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if(subjectData == null) {
            throw new GuliException(20001,"文件数据为空！");
        }
        //一行一行读取，每次读取两个值，第一个是一级分类，第二个是二级分类
        EduSubject existOneEduSubject = this.existOneSubject(eduSubjectService, subjectData.getOneSubjectName());
        //没有相同的一级分类
        if(existOneEduSubject == null) {
            existOneEduSubject = new EduSubject();
            existOneEduSubject.setParentId("0");
            existOneEduSubject.setTitle(subjectData.getOneSubjectName());
            eduSubjectService.save(existOneEduSubject);
        }
        String pid = existOneEduSubject.getId();
        EduSubject existTwoSubject = this.existTwoSubject(eduSubjectService, subjectData.getTwoSubjectName(), pid);
        if(existTwoSubject == null) {
            existTwoSubject = new EduSubject();
            existTwoSubject.setParentId(pid);
            existTwoSubject.setTitle(subjectData.getTwoSubjectName());//二级分类名称
            eduSubjectService.save(existTwoSubject);
        }
    }

    /**
     * 判断一级分类不能重复添加
     * @Return com.atguigu.eduservice.entity.EduSubject
     * @Author suyuanyuan
     * @Date 21:20 2021/3/30
     * @Param @param subjectService
     * @param name
     */
    private EduSubject existOneSubject(EduSubjectService subjectService, String name) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id","0");
        EduSubject oneSubject = subjectService.getOne(wrapper);
        return oneSubject;
    }

    /**
     * 判断二级分类不能重复添加
     * @Return com.atguigu.eduservice.entity.EduSubject
     * @Author suyuanyuan
     * @Date 21:20 2021/3/30
     * @Param @param subjectService
     * @param name
     * @param pid
     */
    private EduSubject existTwoSubject(EduSubjectService subjectService,String name,String pid) {
        QueryWrapper<EduSubject> wrapper = new QueryWrapper<>();
        wrapper.eq("title",name);
        wrapper.eq("parent_id",pid);
        EduSubject twoSubject = subjectService.getOne(wrapper);
        return twoSubject;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
