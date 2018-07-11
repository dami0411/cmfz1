package com.baizhi.yym.service;

import com.baizhi.yym.dao.AlbumDao;
import com.baizhi.yym.dao.ChapterDao;
import com.baizhi.yym.entity.Album;
import com.baizhi.yym.entity.Chapter;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * Created by yamin on 2018/7/6.
 */
@Service("chapterService")
@Transactional
public class ChapterServiceImpl implements ChapterService{
    @Autowired
    private ChapterDao chapterDao;
    @Autowired
    private AlbumDao albumDao;
    @Override
    public void addChapter(Chapter chapter, MultipartFile file1, String realPath) {
        //id
        chapter.setId(UUID.randomUUID().toString());
        chapter.setTimes(0);
        // 获取原始文件名 1.jpg
        String filename = file1.getOriginalFilename();
        //扩展名 .jpg
        String extension = FilenameUtils.getExtension(filename);
        File file = new File(realPath);
        if(!file.exists()){
            file.mkdir();
        }
        UUID uuid = UUID.randomUUID();
        //dadssdsds.jpg
        String newName = uuid+"."+extension;
        //upload
        String newCoverImg = "/uploadChapter/"+newName;
        chapter.setUrl(newCoverImg);
        chapter.setCreateTime(new Date());
        try {
            // 上传
            file1.transferTo(new File(realPath+"/"+newName));
        }catch (IOException e) {
            e.printStackTrace();
        }
        chapterDao.insertChapter(chapter);
        Album album = albumDao.selectOneAlbum(chapter.getAlbum().getId());
        albumDao.updateAlbum(album.getCount()+1,album.getId());
    }

    @Override
    @Transactional
    public void changeTimes(String id) {
        Integer times = chapterDao.selectTimes(id);
        chapterDao.updateChapter(id,times+1);
    }
}
