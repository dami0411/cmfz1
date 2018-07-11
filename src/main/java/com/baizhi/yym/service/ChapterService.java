package com.baizhi.yym.service;

import com.baizhi.yym.entity.Chapter;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yamin on 2018/7/6.
 */
public interface ChapterService {
    //添加
    public void addChapter(Chapter chapter, MultipartFile file1, String realPath);

    public void changeTimes(String id);
}
