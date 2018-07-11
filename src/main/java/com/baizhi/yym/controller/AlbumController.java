package com.baizhi.yym.controller;

import com.baizhi.yym.dto.AlbumDto;
import com.baizhi.yym.entity.Album;
import com.baizhi.yym.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yamin on 2018/7/6.
 */
@RestController
@RequestMapping("/album")
public class AlbumController {
    @Autowired
    private AlbumService albumService;
    @RequestMapping("/queryAllAlbum")
    public List<Album> queryAllAlbum(){
         return albumService.queryAllAlbum();
    }

    @RequestMapping("/queryOneAlbum/{id}")
    public Album queryOneAlbum(@PathVariable("id")String id){
        System.out.println(albumService.queryOneAlbum(id));
        return albumService.queryOneAlbum(id);
    }
    //

    @RequestMapping("/addAlbum")
    public void addAlbum(Album album,MultipartFile file1, HttpSession session){
        String realPath = session.getServletContext().getRealPath("/uploadAlbum");
        albumService.addAlbum(album,file1,realPath);
    }

    @RequestMapping("/queryAllAlbumSplit")
    public AlbumDto queryAllAlbumSplit(Integer page, Integer rows){
        return albumService.queryAllBySplit(page,rows);
    }
}
