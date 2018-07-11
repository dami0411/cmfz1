package com.baizhi.yym.testDao;

import com.baizhi.yym.AppEnter;
import com.baizhi.yym.entity.Admin;
import com.baizhi.yym.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yamin on 2018/7/5.
 */
@SpringBootTest(classes = AppEnter.class)
@RunWith(SpringRunner.class)
public class TestAdmin {
    @Autowired
    private AdminService adminService;
    @Test
    public void queryOneAdmin(){
        Admin admin = adminService.queryOneAdmin("huxz");
        System.out.println(admin);
    }
}
