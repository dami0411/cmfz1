package com.baizhi.yym.dao;

import com.baizhi.yym.entity.Banner;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by yamin on 2018/7/5.
 */
public interface BannerDao {
    //查所有
    public List<Banner> selectAllBanner();
    //查一个
    public Banner selectOne(String id);
    //修改
    public void updateBanner(Banner banner);
    //删除
    public void deleteBanner(String id);
    //添加
    public void insertBanner(Banner banner);
    public Integer selectCount();
    //分页查所有
    public List<Banner> selectAllBannerSplit(@Param("start")Integer start, @Param("rows")Integer rows);
}
