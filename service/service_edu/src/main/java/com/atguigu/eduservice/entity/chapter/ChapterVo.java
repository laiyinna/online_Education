package com.atguigu.eduservice.entity.chapter;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author SuSu
 * @version 1.0
 * @date 2021/4/3 14:48
 */
@Data
public class ChapterVo {

    /**
     * 章节id
     */
    private String id;

    /**
     * 章节名称
     */
    private String title;

    /**
     * 章节下的小节
     */
    private List<VideoVo> videoVoList = new ArrayList<VideoVo>();
}
