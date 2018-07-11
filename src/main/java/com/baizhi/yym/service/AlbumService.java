package com.baizhi.yym.service;

import com.baizhi.yym.dto.AlbumDto;
import com.baizhi.yym.entity.Album;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by yamin on 2018/7/6.
 */
public interface AlbumService {
    //添加
    public void addAlbum(Album album, MultipartFile coverImg, String realPath);
    //查所有
    public List<Album> queryAllAlbum();
    //查一个
    public Album queryOneAlbum(String id);
    public AlbumDto queryAllBySplit(Integer page, Integer rows);
}
