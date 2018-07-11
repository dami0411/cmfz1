package com.baizhi.yym.service;

import com.baizhi.yym.aop.LogAnnotation;
import com.baizhi.yym.dao.AdminDao;
import com.baizhi.yym.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by yamin on 2018/7/5.
 */
@Service("adminService")
@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin queryOneAdmin(String name) {
        return adminDao.selectOneAdmin(name);
    }

    @Override
    @Transactional
    public void changeAdmin(Admin admin) {
        adminDao.updateAdmin(admin);
    }

    @Override
    @Transactional
    @LogAnnotation(name = "用户保存")
    public void addAdmin(Admin admin) {
        adminDao.insertAdmin(admin);
    }
}
