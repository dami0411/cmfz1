package com.baizhi.yym.testDao;

import com.baizhi.yym.AppEnter;
import com.baizhi.yym.dao.ChapterDao;
import com.baizhi.yym.entity.Album;
import com.baizhi.yym.service.AlbumService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by yamin on 2018/7/6.
 */
@SpringBootTest(classes = AppEnter.class)
@RunWith(SpringRunner.class)
public class TestAlbum {
    @Autowired
    private AlbumService albumService;
    @Autowired
    private ChapterDao chapterDao;
    @Test
    public void queryAlbum(){
        List<Album> list = albumService.queryAllAlbum();
        for (Album album : list) {
            System.out.println(album);
        }
    }
    @Test
    public void q(){
        Integer integer = chapterDao.selectTimes("11");
        System.out.println(integer);
    }
}
