package com.baizhi.yym.controller;

import com.baizhi.yym.dto.BannerDto;
import com.baizhi.yym.entity.Banner;
import com.baizhi.yym.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by yamin on 2018/7/5.
 */
@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired
    private BannerService bannerService;
    //查所有
    @RequestMapping("/queryAllBanner")
    public List<Banner> queryAllBanner(){
        return bannerService.queryAllBanner();
    }

    //查所有
    @RequestMapping("/queryAllBannerSplit")
    public BannerDto queryAllBannerSplit(Integer page,Integer rows){
        return bannerService.queryAllBySplit(page,rows);
    }

    //查一个
    @RequestMapping("/queryOneBanner/{id}")
    public Banner queryOneBanner(@PathVariable("id")String id){
        return bannerService.queryOne(id);
    }
    //修改
    @RequestMapping("/changeBanner")
    public void changeBanner(Banner banner){
        bannerService.changeBanner(banner);
    }
    //删除
    @RequestMapping("/removeBanner/{id}")
    public void removeBanner(@PathVariable("id") String id){
        bannerService.removeBanner(id);
    }
    //添加
    @RequestMapping("/addBanner")
    public void addBanner(Banner banner, MultipartFile file1, HttpSession session){
        String realPath = session.getServletContext().getRealPath("/upload");
       // return "index";
        bannerService.addBanner(banner,file1,realPath);
    }
}
