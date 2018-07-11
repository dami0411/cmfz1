package com.baizhi.yym.service;

import com.baizhi.yym.dao.BannerDao;
import com.baizhi.yym.dto.BannerDto;
import com.baizhi.yym.entity.Banner;
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
 * Created by yamin on 2018/7/5.
 */
@Service("bannerService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> queryAllBanner() {
        return bannerDao.selectAllBanner();
    }

    @Override
    public Banner queryOne(String id) {
        return bannerDao.selectOne(id);
    }

    @Override
    @Transactional
    public void changeBanner(Banner banner) {
        bannerDao.updateBanner(banner);
    }

    @Override
    @Transactional
    public void removeBanner(String id) {
        bannerDao.deleteBanner(id);
    }

    @Override
    @Transactional
    public void addBanner(Banner banner, MultipartFile file1,String realPath) {
        //id
        banner.setId(UUID.randomUUID().toString());
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
        banner.setPicName(newName);
        //upload
        banner.setPicPath("/upload");
        try {
            // 上传
            file1.transferTo(new File(realPath+"/"+newName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bannerDao.insertBanner(banner);
    }

    @Override
    public BannerDto queryAllBySplit(Integer page, Integer rows) {
        List<Banner> bannerList = bannerDao.selectAllBannerSplit((page-1)*rows,rows);
        BannerDto dto = new BannerDto();
        dto.setTotal(bannerDao.selectCount());
        dto.setRows(bannerList);
        return dto;
    }
}
