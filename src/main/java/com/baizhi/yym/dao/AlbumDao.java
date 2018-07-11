package com.baizhi.yym.dao;

import com.baizhi.yym.entity.Album;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yamin on 2018/7/6.
 */
public interface AlbumDao {
    //添加
    public void insertAlbum(Album album);
    //查所有
    public List<Album> selectAllAlbum();
    //查一个
    public Album selectOneAlbum(String id);
    //修改数量
    public void updateAlbum(@Param("count")Integer count,@Param("id")String id);
    public Integer selectCount();
    public List<Album> selectAllAlbumSplit(@Param("start")Integer start, @Param("rows")Integer rows);
}
