package com.baizhi.yym.dao;

import com.baizhi.yym.entity.Admin;

/**
 * Created by yamin on 2018/7/5.
 */
public interface AdminDao {
    //查一个
    public Admin selectOneAdmin(String name);
    //修改
    public void updateAdmin(Admin admin);
    //添加
    public void insertAdmin(Admin admin);
}
