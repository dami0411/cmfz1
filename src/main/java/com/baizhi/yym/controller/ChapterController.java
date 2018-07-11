package com.baizhi.yym.controller;

import com.baizhi.yym.entity.Album;
import com.baizhi.yym.entity.Chapter;
import com.baizhi.yym.service.ChapterService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by yamin on 2018/7/6.
 */
@RestController
@RequestMapping("chapter")
public class ChapterController {
    @Autowired
    private ChapterService chapterService;
    @RequestMapping("addChapter")
    public void addChapter(Chapter chapter, String id,MultipartFile file1, HttpSession session){
        String realPath = session.getServletContext().getRealPath("/uploadChapter");
        Album album = new Album();
        album.setId(id);
        chapter.setAlbum(album);
        chapterService.addChapter(chapter,file1,realPath);
    }
    @RequestMapping("/download")
    public void download(String url, HttpSession session, HttpServletResponse response) throws IOException {
        String realPath = session.getServletContext().getRealPath("/");
        byte[] bs = FileUtils.readFileToByteArray(new File(realPath+url));
        response.setHeader("context-disposition","inline ;filename="+ URLEncoder.encode(url,"UTF-8"));
        ServletOutputStream out = response.getOutputStream();
        out.write(bs);
        if(out!=null){
            out.flush();
            out.close();
        }
    }
    @RequestMapping("/changeTimes")
    public void changeTimes(String id){
        chapterService.changeTimes(id);
    }
}
