package com.baizhi.yym.service;

import com.baizhi.yym.dto.BannerDto;
import com.baizhi.yym.entity.Banner;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Created by yamin on 2018/7/5.
 */
public interface BannerService {
    public List<Banner> queryAllBanner();
    //查一个
    public Banner queryOne(String id);
    //修改
    public void changeBanner(Banner banner);
    //删除
    public void removeBanner(String id);
    //添加
    public void addBanner(Banner banner, MultipartFile file1,String realPath);
    public BannerDto queryAllBySplit(Integer page, Integer rows);
}
