package com.baizhi.yym.dao;

import com.baizhi.yym.entity.Chapter;
import org.apache.ibatis.annotations.Param;

/**
 * Created by yamin on 2018/7/6.
 */
public interface ChapterDao {
    //添加
    public void insertChapter(Chapter chapter);
    public void updateChapter(@Param("id") String id,@Param("times") Integer times);
    //查原来的次数
    public Integer selectTimes(String id);

}
