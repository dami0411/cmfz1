package com.baizhi.yym.service;

import com.baizhi.yym.aop.LogAnnotation;
import com.baizhi.yym.dao.AlbumDao;
import com.baizhi.yym.dto.AlbumDto;
import com.baizhi.yym.entity.Album;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * Created by yamin on 2018/7/6.
 */
@Service("albumService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AlbumServiceImpl implements AlbumService{

    @Autowired
    private AlbumDao albumDao;

    @Override
    @Transactional
    @LogAnnotation(name = "轮播图保存")
    public void addAlbum(Album album,MultipartFile file1, String realPath) {
        //id
        album.setId(UUID.randomUUID().toString());
        album.setCount(0);
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
        String newCoverImg = "/uploadAlbum"+newName;
        album.setCoverImg(newCoverImg);
        try {
            // 上传
            file1.transferTo(new File(realPath+"/"+newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        albumDao.insertAlbum(album);
    }

    @Override
    public List<Album> queryAllAlbum() {
        return albumDao.selectAllAlbum();
    }

    @Override
    public Album queryOneAlbum(String id) {
        return albumDao.selectOneAlbum(id);
    }

    @Override
    public AlbumDto queryAllBySplit(Integer page, Integer rows) {
        List<Album> albumList = albumDao.selectAllAlbumSplit((page-1)*rows,rows);
        AlbumDto dto = new AlbumDto();
        dto.setTotal(albumDao.selectCount());
        dto.setRows(albumList);
        return dto;
    }
}
