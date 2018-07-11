package com.baizhi.yym.service;

import com.baizhi.yym.entity.Admin;

/**
 * Created by yamin on 2018/7/5.
 */
public interface AdminService {
    //查一个
    public Admin queryOneAdmin(String name);
    //修改
    public void changeAdmin(Admin admin);
    //添加
    public void addAdmin(Admin admin);
}
